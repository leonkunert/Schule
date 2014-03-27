package konto;

public class Konto {
	private String nummer;
	private float saldo;
	Konto() {
		setSaldo(0);
	}
	
	public Konto(String nummer) {
		super();
		setNummer(nummer);
	}
	
	public String getNummer() {
		return nummer;
	}
	
	public void setNummer(String nummer) {
		this.nummer = nummer;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public void anzeigen() {
		System.out.println("Kontostand: "+saldo);
	}
	
	public void einzahlen(float betrag) {
		if (betrag>0) {
			setSaldo(getSaldo()+betrag);
		}
	}
	
	public void auszahlen(float betrag) {
		if (betrag>0) {
			setSaldo(getSaldo()-betrag);
		}
	}
}