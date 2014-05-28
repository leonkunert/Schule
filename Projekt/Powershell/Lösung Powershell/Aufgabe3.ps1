# Import des AD Moduls
Import-Module ActiveDirectory

# Bildschirm leeren
cls

# MySql Treiber Laden
[void][system.reflection.Assembly]::LoadFrom("C:\MySql.Data.dll")

# Domain Config
$domain = 'R053-10'

# Verbindung zur DB aufbauen
$conn = New-Object MySql.Data.MySqlClient.MySqlConnection("Server=localhost; Database=schule; Uid=root")
# Und öffnen
$conn.Open()

# Funktion die die DB und AD abgleicht
Function syncro(){

    # Alle OUs aus der DB holen
    $objCommand = New-Object MySql.Data.MySqlClient.MySqlCommand("SELECT * FROM ou", $conn)
    $reader = $objCommand.ExecuteReader()

    # Für jede OU in der DB
    while ($reader.Read()) {
        # Beschreibung und Status in Variable speichern
        $beschreibung = $reader.GetValue(1)
        $deleted      = $reader.GetBoolean(2)

        # Alle OUs Löschen
        Try {
            Remove-ADOrganizationalUnit -Identity "OU=$beschreibung,DC=$domain,DC=local" -Confirm:$false -Recursive
        } Catch [Microsoft.ActiveDirectory.Management.ADIdentityNotFoundException] {
            echo "OU $beschreibung wurde neu angelegt"
        }
        
        # Alle OUs neu anlegen
        New-ADOrganizationalUnit -Name $beschreibung -ProtectedFromAccidentalDeletion $false -Path "DC=$domain,DC=local"
    }

    #Alle User aus der DB holen
    $objCommand = New-Object MySql.Data.MySqlClient.MySqlCommand("SELECT * FROM person LEFT JOIN ou ON person.klasse = ou.ou_id", $conn)

    # Reader Schließen, damit er erneut benutzt werden kann
    $reader.Close()
    $reader = $objCommand.ExecuteReader()

    # Für jeden User
    while($reader.Read()) {
        # Daten aus der DB in Variablen speichern
        $nachname = $reader.GetValue(1)
        $vorname  = $reader.GetValue(2)
        $passwort = $reader.GetValue(3)
        $klasse   = $reader.GetValue(10)
        $deleted  = $reader.GetBoolean(7)
        $username = $reader.GetValue(8)

        # Passwort in korrekte Form konvertieren
        $pass = ConvertTo-SecureString -AsPlainText $passwort -Force

        # Neuen User Anlegen
        if ($deleted -eq $false) {
            Try {
                New-ADUser -name $username -GivenName $vorname -AccountPassword $pass -Surname $nachname -Path "OU=$klasse,DC=$domain,DC=local"
            }
            Catch [Microsoft.ActiveDirectory.Management.ADIdentityAlreadyExistsException] {
                echo "Der User "$username" ist bereits vorhanden"
            }
        }
    
    }
    $reader.Close()
}


# Funktion um neue User anzulegen
Function addUser($vorname, $nachname, $username, $passwort, $klasse) {

    # OU entsprechend dem Namen in der Datenbank anlegen
    Try {
        $query = "insert into schule.ou (ou_id, description, deleted) values (null, '$klasse', 0);"

        $objCommand = New-Object MySql.Data.MySqlClient.MySqlCommand($query, $conn)

        $objCommand.ExecuteNonQuery()
    } Catch {
    }
    # ID der Klasse(OU) entsprechend dem Namen auswählen
        $query = "select ou_id from ou where description like '$klasse';"

        $objCommand = New-Object MySql.Data.MySqlClient.MySqlCommand($query, $conn)

        $reader = $objCommand.ExecuteReader()

        $reader.Read()

        $klasse = $reader.GetValue(0)

        $reader.Close()

        # ID der Klasse in DB einfügen
        $query = "INSERT INTO schule.person (id,name,vorname,passwort,klasse,timestamp,deleted,username) VALUES (NULL, '$nachname', '$vorname', '$passwort', '$klasse', CURRENT_TIMESTAMP, '0', '$username');"

        echo $query | Out-Host

        $objCommand = New-Object MySql.Data.MySqlClient.MySqlCommand($query, $conn)

        $objCommand.ExecuteNonQuery()
}


# Check des Passworts auf Komplexität
Function passwordOk([String] $psw) {
    echo $psw | Out-Host
    if (($psw.Length -ge 7) -and ($psw -match '[!|§|$|%|&|(|)|=|?|+|*|#|-|_|.|:]+') -and ($psw -cmatch '[Q|W|E|R|T|Z|U|I|O|P|L|K|J|H|G|F|D|S|A|Y|X|C|V|B|N|M]+') -and ($psw -match '[1234567890]+'))
    {
        echo "dtuhaeiurzhieputh" | Out-Host
        return $true
    }
        return $false
    
}

# Funktion um den User zu entfernen
Function delUser([String] $usrname) {
    try {
        $query = "update person set deleted = 1 where username like '$usrname';"

        echo $query | Out-Host

        $objCommand = New-Object MySql.Data.MySqlClient.MySqlCommand($query, $conn)

        $objCommand.ExecuteNonQuery()
    } catch {}
    return $true
}

