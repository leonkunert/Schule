cls

function accountExists($username) {
    $user = Get-ADUser -Filter {SamAccountName -eq $username}
    if($user -ne $null) {
        return $false
    }
    else {
        return $true
    }
}

function createDefaultSchueler($username, $password='Changeme1', $name, $nachname, $klasse) {
    if(accountExists($username)) {
        New-ADUser -SamAccountName $username -UserPrincipalName $username'@Dom53-02.local' -Name ($name+' '+$nachname) -GivenName $name -Surname $nachname -Path "OU=$klasse,DC=Dom53-02,DC=local" -AccountPassword (ConvertTo-SecureString -AsPlainText $password -Force)
        echo "Account $username erstellt"
    }
    else {
        echo "Account $username existiert bereits"
    }
}

function createClass($klasse) {
    if([adsi]::Exists("LDAP://OU=$klasse,DC=Dom53-02,DC=local") -ne $true) {
        New-ADOrganizationalUnit -Name $klasse
        echo "Klasse $klasse erstellt!"
    }
    else {
        echo "Klasse $klasse existiert bereits!"
    }
}


$all_users = Import-Csv -Delimiter ";" -Path "C:\new-users.csv"
foreach ($User in $all_users) {
    $UserName        = $User.Name
    $UserPassword    = $User.Password
    $UserFirstName   = $User.Vorname
    $UserLastName    = $User.Nachname
    $UserClass       = $User.Klasse

    createClass $UserClass
    createDefaultSchueler $UserName $UserPassword $UserFirstName $UserLastName $UserClass
}