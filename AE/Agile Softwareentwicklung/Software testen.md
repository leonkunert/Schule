 # Software testen #

## Was versteht man unter einem Softwaretest? ##

Softwaretest sind eine Möglichkeit des Entwicklers oder Benutzers zu überprüfen, ob eine Software wie gedacht funktioniert, und wenn nicht mögliche informationen über fehlfunktionen zu geben.

## Warum wird Software getestet? ##
Um die Funktionalität von Software gewährleisten zu können sollte man sie testen. Tests verringern die Wahrscheinlichkeit, dass Fehler beim Programmieren gemacht werden. Testing erhöht die Qualität von Code grundsätzlich und auch das Vertrauen der Entwickler Änderungen an Software durchzuführen wird gestärkt. 


## Welche Testverfahren gibt es und wozu dienen sie? (11 Stück) ##
### Unit Test ###
Test einer Logischen Einheit z.B. einer Klasse.
### Integration Test ###
Test von mehreren logischen Einheiten die Kombiniert werden, und damit auch ihrer Interaktion.
### End-to-End / System Test ###
Tests bei denen alle Einheiten eines Programms kombiniert werden und inklusive ihrer Interaktion getestet werden. 
### Mock Test ###
Logische Einheit testen, mit ihren Abhängigkeiten, ohne Interaktion mit anderen Logischen Einheiten, stattdessen werden Objekte die gebraucht werden Simuliert.
### Acceptance Test ###
Basis für die Abnahme eines Gesamtsystems, die vom Benutzer ausgeführt und geschrieben wird.
### Regression Test ###
Test um bereits vorhandene und funktionierende Bereiche von einem Programm auf ihre Funktionsfähigkeit über den Zeitraum der Entwicklung weiter zu garantieren.
### Performance Test ###
Test zur Performance eines Programms im allgemeinen oder Teilbereichen im speziellen.
### Exploration Test ###
Wird dazu eingesetzt die Funktion von gewissen Bereichen von Software zu verstehen. Dient auch zu Dokumentation und kann beim Refactoring eingesetzt werden, um Veränderungen zu entdecken.
### Black-Box-Test ###
Zum Testen von Spezifikationen gedacht. Haben prinzipiell keine Kenntnis über die Logik eines Programms.
### White-Box-Test ###
Zum Testen der Implementierung und inneren Logik eines Programms.
### Grey-Box-Test ###
Mischung von Black- und White-Box-Test bei der über die Spezifikation getestet wird, aber über den inneren Aufbau eines Programms bekannte Probleme getestet werden.
## Erläutern Sie die Unterschiede zwischen "dummys", "stubs", "fakes" und "mocks". ##
Mit *Dummys* testet man Attribute und Methoden Parameter.
*Stubs* haben die gleichen Eigenschaften wie die Objekte für die sie stehen sie geben außerdem die Parameter weiter.
*Fakes* ersetzen Komponenten durch eine schnelle, stark vereinfachte Variante von ihnen. Sie sollten nur bestimmte Eigenschaften haben.
Mit *Mocks* kann man Inputs und Outputs von Einzelnen Objekten verifizieren und aufzeichnen.
