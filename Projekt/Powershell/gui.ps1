. $PSScriptRoot\Aufgabe3.ps1
# Laden der Window.Forms
[reflection.assembly]::LoadWithPartialName( "System.Windows.Forms")

# Erzeugen des Windows
$win = New-Object Windows.Forms.Form

# Titel für Window
$win.text = "Sycronisieren der Datenbank mit dem AD"

# Label einfügen
$label = New-Object Windows.Forms.Label
$label.Location = New-Object Drawing.Point 50,30
$label.Size = New-Object Drawing.Point 200,15
$label.text = "Klick auf Syncronisieren"

# Button einfügen
$button = New-Object Windows.Forms.Button
$button.text = "Synchronisieren"
$button.Location = New-Object Drawing.Point 45,140
$button.Size = New-Object Drawing.Point 200,30

$btnOpenWin = New-Object Windows.Forms.Button
$btnOpenWin.text = "Nutzer hinzufügen"
$btnOpenWin.Location = New-Object Drawing.Point 45,170
$btnOpenWin.Size = New-Object Drawing.Point 200,30

$btnDelUsr = New-Object Windows.Forms.Button
$btnDelUsr.text = "Username löschen"
$btnDelUsr.Location = New-Object Drawing.Point 145,200
$btnDelUsr.Size = New-Object Drawing.Point 100,30


# Erstellen vom zweiten Window (User Hinzufügen)

$vName = New-Object Windows.Forms.Label
$vName.Location = New-Object Drawing.Point 50,30
$vName.Size = New-Object Drawing.Point 50,15
$vName.text = "Vorname"

$vtext = New-Object Windows.Forms.TextBox
$vtext.Location = New-Object Drawing.Point 140,30
$vtext.Size = New-Object Drawing.Point 200,30

$nName = New-Object Windows.Forms.Label
$nName.Location = New-Object Drawing.Point 50,60
$nName.Size = New-Object Drawing.Point 70,15
$nName.text = "Nachname"

$ntext = New-Object Windows.Forms.TextBox
$ntext.Location = New-Object Drawing.Point 140,60
$ntext.Size = New-Object Drawing.Point 200,30

$usrName = New-Object Windows.Forms.Label
$usrName.Location = New-Object Drawing.Point 50,90
$usrName.Size = New-Object Drawing.Point 70,15
$usrName.text = "Username"

$usrtext = New-Object Windows.Forms.TextBox
$usrtext.Location = New-Object Drawing.Point 140,90
$usrtext.Size = New-Object Drawing.Point 200,30

$password = New-Object Windows.Forms.Label
$password.Location = New-Object Drawing.Point 50,120
$password.Size = New-Object Drawing.Point 70,15
$password.text = "Passwort"

$pwrtext = New-Object Windows.Forms.TextBox
$pwrtext.Location = New-Object Drawing.Point 140,120
$pwrtext.Size = New-Object Drawing.Point 200,30

$class = New-Object Windows.Forms.Label
$class.Location = New-Object Drawing.Point 50,150
$class.Size = New-Object Drawing.Point 70,15
$class.text = "Klasse"

$classtext = New-Object Windows.Forms.TextBox
$classtext.Location = New-Object Drawing.Point 140,150
$classtext.Size = New-Object Drawing.Point 200,30

$btnAddUser = New-Object Windows.Forms.Button
$btnAddUser.text = "Hinzufügen"
$btnAddUser.Location = New-Object Drawing.Point 140,180
$btnAddUser.Size = New-Object Drawing.Point 70,30

$deltxt = New-Object Windows.Forms.TextBox
$deltxt.Location = New-Object Drawing.Point 45,205
$deltxt.Size = New-Object Drawing.Point 100,30



$button.add_click({

    syncro
    $label.Text = "Alles gut gelaufen"

})

$btnDelUsr.add_click({
    if ($deltxt.Text.Length -gt 0) {
        delUser $deltxt.Text
    }

})


$btnOpenWin.add_click({
    $form = New-Object Windows.Forms.Form
    $form.Size = New-Object Drawing.Point 400,280
    $form.text = "Neuer User"
    
    
    $form.controls.add($vName)
    $form.controls.add($nName)
    $form.controls.add($vtext)
    $form.controls.add($ntext)
    $form.controls.add($usrName)
    $form.controls.add($usrtext)
    $form.controls.add($password)
    $form.controls.add($pwrtext)
    $form.controls.add($class)
    $form.controls.add($classtext)
    $form.controls.add($btnAddUser)


    $btnAddUser.add_click({
        if ($usrName.Text.Equals("") -or (passwordOk $pwrtext.Text )) {        
            addUser $vtext.Text $ntext.Text $usrtext.Text $pwrtext.Text $classtext.Text
            Add-Type -AssemblyName System.Windows.Forms
            # $result = [System.Windows.Forms.MessageBox]::Show("My message", "Window Title", [System.Windows.Forms.MessageBoxButtons]::OK, [System.Windows.Forms.MessageBoxIcon]::None)
            $result = [System.Windows.Forms.MessageBox]::Show("User erfolgreich der Datenbank hinzugefügt." , "Status")
            $form.Close()
        } else {
            echo "Bitte nocheinmal die Eingaben überprüfen" | Out-Host
        }
    })
    
    # Display the dialog
    $form.ShowDialog()

})


$win.controls.add($label)
$win.controls.add($button)
$win.controls.add($btnOpenWin)
$win.controls.add($btnDelUsr)
$win.controls.add($deltxt)

# Display the dialog
$win.ShowDialog()

$conn.Close()