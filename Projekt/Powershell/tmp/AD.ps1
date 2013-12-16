d#### Import des AD Moduls ####
Import-Module ActiveDirectory

#### Um User aus zu lesen ####
#Get-ADUser -Filter {name -like "*"} | Out-GridView

#### Benutzer name ist das was unter name nach dem Punkt steht
#### z.B. Bob der Baumeister. Bob
#### Username = Bob

#### Um Eigenschaften von Usern zu Setzten ####
#Set-ADUser -Identity S3 -StreetAddress "ABC-Strasse 123" -HomePage "http://www.abc.de"

#### Nach neuem Namen Fragen ####
$name = Read-Host "Neuer Benutzername???"

#### Neuen User anlegen ####
Try { New-ADUser -name $name }
Catch { echo "Benutzer Existiert schon!" }

#### Test obs geklappt hat ####
Get-ADUser -Filter {name -like $name}