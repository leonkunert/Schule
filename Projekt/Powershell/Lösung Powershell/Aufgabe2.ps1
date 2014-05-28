#### Import des AD Moduls ####
Import-Module ActiveDirectory

#### Daten aus der CSV lesen ####
$daten = Import-Csv C:\Users\Administrator\Documents\daten.csv -Delimiter ';'

#### Für jeden Datensatz in den Daten
ForEach ($user in $daten) {
    #### Alte user Löschen
    Try {
        Remove-ADUser $user.Benutzername
    }
    Catch {
        echo "Voll was falsch gelaufen beim Löschen"
    }

    #### Neue User anlegen
    $pass = ConvertTo-SecureString -AsPlainText $user.Password -Force
    New-ADUser -name $user.Benutzername -GivenName $user.Vorname -AccountPassword $pass
        
    #### OU festlegen
    $location = "OU="+$user.Klasse+",DC=Dom53-06,DC=local"
    
    #### Benutzername zwischenspeichern 
    $benutzername = $user.Benutzername

    #### DistinguishedName zwischenspeichern
    $dn = (Get-ADUser -Filter {name -like $benutzername}).DistinguishedName

    Try {
        New-ADOrganizationalUnit -name $user.Klasse
    }
    Catch { echo "Guck mal hier" }

    #### Benutzer in OU bewegen
    Move-ADObject -Identity $dn -TargetPath $location
}

#### Ausgabe als test
#Get-ADUser -Filter {name -like "*"} | echo 