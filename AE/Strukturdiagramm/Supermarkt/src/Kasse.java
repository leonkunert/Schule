
public class Kasse {
	private String bez;
	private double einlage;
	private double kassenstand;
	private Supermarkt supermarkt;
	
	public String getBez() {
		return bez;
	}
	public void setBez(String bez) {
		this.bez = bez;
	}
	public double getEinlage() {
		return einlage;
	}
	public void setEinlage(double einlage) {
		this.einlage = einlage;
	}
	public double getKassenstand() {
		return kassenstand;
	}
	public void setKassenstand(double kassenstand) {
		this.kassenstand = kassenstand;
	}
	public Supermarkt getSupermarkt() {
		return supermarkt;
	}
	public Kasse(String bez, Supermarkt supermarkt) {
		super();
		this.bez = bez;
		this.supermarkt = supermarkt;
	}
	public void setSupermarkt(Supermarkt supermarkt) {
		this.supermarkt = supermarkt;
	}
	
	//Tageseinnahmen berechnen
	public double tageinges(){
		return this.kassenstand - this.einlage;
	}
}
