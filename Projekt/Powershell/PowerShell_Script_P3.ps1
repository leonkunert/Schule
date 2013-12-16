# -- IMPORTS -- #
Import-Module ActiveDirectory

# -- CLEAR SCREEN -- #
cls

# -- CONNECTION TO DATABASE -- #
[void][system.reflection.Assembly]::LoadFrom("C:\MySQL.Data.dll");
$con = New-Object MySql.Data.MySqlClient.MySqlConnection
$con.ConnectionString = "Server=localhost; Database=ad; Uid=root;"
try {
    $con.Open()
}
catch {
    echo "Kann nicht zur Datenbank verbinden!"
    return
}


# -- USER AND GROUP LISTS -- #
$users  = Get-ADUser -Filter {name -like "*"}
$groups = Get-ADGroup -Filter {name -like "*"}

# -- DOMAIN NAME -- #
$domain = 'R053-10'


# -- FUNCTION CREATESCHUELER String Username, String Password (default = "Changeme1"), String Name, String Nachname, String Klasse
# Erstellt neuen User
function createSchueler($username, $password='Changeme1', $name, $nachname, $klasse) {
    if(accountExists($username)) {
        New-ADUser -SamAccountName $username -UserPrincipalName $username'@'$domain'.local' -Name ($name+' '+$nachname) -GivenName $name -Surname $nachname -Path "OU=$klasse,DC=$domain,DC=local" -AccountPassword (ConvertTo-SecureString -AsPlainText $password -Force)
        echo "Account $username erstellt"
    }
    else {
        echo "Account $username existiert bereits"
    }
}

# -- FUNCTION DELETESCHUELER String Username -- #
# User wird gelöscht
function deleteSchueler($username) {
    try {
        Remove-ADUser -Identity $username -Confirm:$false
        echo "User $username gelöscht!"
    }
    catch {
        echo "Konnte User $username nicht löschen!"
    }
}

# -- FUNCTION CREATECLASS String Klasse -- #
# Erstellt eine neue Klasse
function createClass($klasse) {
    if([adsi]::Exists("LDAP://OU=$klasse,DC=$domain,DC=local") -ne $true) {
        New-ADOrganizationalUnit -Name $klasse -ProtectedFromAccidentalDeletion $false -Path "DC=$domain,DC=local"
        echo "Klasse $klasse erstellt!"
    }
    else {
        echo "Klasse $klasse existiert bereits!"
    }
}
# -- FUNCTION ACCOUNTEXISTS String Username -- #
# Überprüfung ob Account existiert
function accountExists($username) {
    $user = Get-ADUser -Filter {SamAccountName -eq $username}
    if($user -ne $null) {
        return $false
    }
    else {
        return $true
    }
}

# -- FUNCTION READCSV -- #
# Lesen der CSV
function readCSV() {
    $all_Users = Import-Csv -Delimiter ";" -Path ".\userslist.csv"  
    foreach ($User in $all_Users)  
    {  
        $Password          = $User.Password
        $UserFirstname     = $User.Vorname 
        $UserBenutzername  = $User.Benutzername
        $UserClass         = $User.Klasse

        If (doesObjectExists($UserClass) == $True){
            echo("Jo")
        }else{
            echo("Nö")
            New-ADOrganizationalUnit -Name $UserClass
        }

        newUser($User.name)
    }
}

# -- FUNCTION CREATESQLUSERS -- #
# Erstellt Datenbank-User
function createSQLUsers() {
    $command = New-Object MySql.Data.MySqlClient.MySqlCommand("SELECT * FROM person", $con)
    $reader = $command.ExecuteReader()

    while($reader.Read()) {
        
        $UserFirstName   = $reader.GetValue(2)
        $UserLastName    = $reader.GetValue(1)
        $UserPassword    = $reader.GetValue(3)
        $UserName        = $reader.GetValue(4)
        $UserClass       = $reader.GetValue(5)

        createClass $UserClass
        createSchueler $UserName $UserPassword $UserFirstName $UserLastName $UserClass
    }
    $reader.Close()
}
# -- FUNCTION SYNCLOCALUSERS -- #
# Synchronisiert locale User
function syncLocalUsers() {
    $command = New-Object MySql.Data.MySqlClient.MySqlCommand("SELECT DISTINCT klasse FROM person", $con)
    $reader = $command.ExecuteReader()

    $localUsers = @()

    while($reader.Read()) {
        $klasse = $reader.GetValue(0)

        $user = Get-ADUser -SearchBase “OU=$klasse,dc=$domain,dc=local” -Filter *
        $uname = $user.SamAccountName

        $localUsers += $uname
    }

    $reader.Close()

    foreach($localUser in $localUsers) {
        $c = New-Object MySql.Data.MySqlClient.MySqlCommand("SELECT * FROM person WHERE user = '$localUser'", $con)
        $userReader = $c.ExecuteReader()

        if($userReader.HasRows) {
            echo $localUser" exists!"
        }
        else {
            echo $localUser" does not exist!"
            deleteSchueler $localUser
        }
        $userReader.Close()
    }
}


createSQLUsers
syncLocalUsers