#### Import des AD Moduls ####
Import-Module ActiveDirectory

#### Nach neuem Namen Fragen ####
$name = Read-Host "Neuer Benutzername???"

#### Neuen User anlegen ####
Try { New-ADUser -name $name }
Catch { echo "Benutzer Existiert schon!" }

#### Test obs geklappt hat ####
Get-ADUser -Filter {name -like $name}