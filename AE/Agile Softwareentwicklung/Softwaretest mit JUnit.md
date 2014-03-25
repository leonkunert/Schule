# Softwaretest mit JUnit #
## Was ist JUnit? ##
JUnit ist ein Unit Testing Framework für Java. Es ist bekannt, in der Testgetriebene Entwicklung, und ist eines der Unit-Tests Frameworks insgesamt als xUnit bekannt.
## Welche Eigenschaften hat JUnit? ##
Es ist Open-Source. Besteht aus einem Test-runner und bietet Assertations und Annotations. Tests können in Test-Suits organisiert werden. 
## Was Ist Ein JUnit TestCase? ##
Ein Test Case ist ein Teil eines JUnit tests, der aus mehreren Tests bestehen kann, aber eine Funktionalität testet.
## Wie erzeugt man einen JUnit TestCase mit Eclipse? ##
Man Klickt mit der rechten Maustaste auf das Projekt und wählt, neue JUnit Klasse. Das erzeugt einen neuen JUnit Test.
## Wie Führt Man Einen TestCase in Eclipse Aus Und Welches Ergebnis Erhält Man? ##
Um einen Test laufen zu lassen, klickt man auf RUN. Genauso, wie man ein Programm laufen lässt.
## Was Versteht Man Unter Einem Regressions- Testframework? ##
Ein Regressions-Test soll gewährleisten, dass eine Änderung an einem Programm keine Fehler hat, die bereits getestet worden sind.
## Was Versteht Man Unter Einer Testsuite? ##
Eine Testsuite ist eine Sammlung von Tests um ein Programm zu testen.
## Nennen Sie Die Wichtigsten Assertions Und Ihre Bedeutung/Verwendung. ##
AssertEquals(Var1, Var2) testet ob Var1 gleich Var2 ist.
AssertTrue(Var) testet ob Var Wahr ist.
## Erstellen Sie eine komplette Testabdeckung für die Klasse Konto: ##
	import static org.junit.Assert.*;
	import org.junit.Test;
	public class KontoTest {
	
		@Test
		public void isItRight() {
			assertEquals(1,1);
		}

		@Test
		public void testGetNummer() {
			Konto k1 = new Konto("12");
			assertEquals(k1.getNummer(), "12");
		}

		@Test
		public void testSetNummer() {
			Konto k1 = new Konto();
			k1.setNummer("nummer");
			assertEquals(k1.getNummer(), "nummer");
		}

		@Test
		public void testGetSaldo() {
			Konto k1 = new Konto();
			k1.setSaldo(12.3);
			assertEquals(k1.getSaldo(), 12.3, 0);
		}

		@Test
		public void testSetSaldo() {
			Konto k1 = new Konto();
			k1.setSaldo(12.3);
			assertEquals(k1.getSaldo(), 12.3, 0);
		}

		@Test
		public void testEinzahlen() {
			Konto k1 = new Konto();
			k1.setSaldo(12.3);
			k1.einzahlen(12.3);
			assertEquals(k1.getSaldo(), 24.6, 0);
		}

		@Test
		public void testAuszahlen() {
			Konto k1 = new Konto();
			k1.setSaldo(12.3);
			k1.auszahlen(12.3);
			assertEquals(k1.getSaldo(), 0, 0);
		}
	}