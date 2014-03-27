package konto;
import org.junit.*;

public class KontoTest {
	@Test
	public void testKonto() {
		Konto k = new Konto();
		
		Assert.assertNotNull(k);
		Assert.assertTrue(0 == k.getSaldo());
	}
	
	@Test
	public void testKontoString() {
		Konto k = new Konto("12");
		
		Assert.assertNotNull(k);
		Assert.assertTrue(0 == k.getSaldo());
		Assert.assertEquals("12", k.getNummer());
	}
	
	@Test
	public void testKontonummer() {
		Konto k = new Konto();
		k.setNummer("7");
		
		Assert.assertEquals("7", k.getNummer());
	}
	
	@Test
	public void testSaldo() {
		Konto k = new Konto();
		float geld = 200.2f;
		k.setSaldo(geld);
		
		Assert.assertTrue(geld == k.getSaldo());
	}
	
	@Test
	public void testEinzahlen() {
		float cashStart = 200.5f;
		float cashAdd = 50.5f;
		float cashTarget = cashStart + cashAdd;
		Konto k = new Konto();
		
		k.setSaldo(cashStart);
		k.einzahlen(cashAdd);
		
		Assert.assertTrue(cashTarget == k.getSaldo());
	}
	
	@Test
	public void testAuszahlen() {
		float cashStart = 200.5f;
		float cashRemove = 50.5f;
		float cashTarget = cashStart - cashRemove;
		Konto k = new Konto();
		
		k.setSaldo(cashStart);
		k.auszahlen(cashRemove);
		
		Assert.assertTrue(cashTarget == k.getSaldo());
	}
}