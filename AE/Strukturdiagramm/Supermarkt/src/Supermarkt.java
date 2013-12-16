import java.util.ArrayList;


public class Supermarkt {
	private String name;
	private double tageseinnahme;
	private Zentrale zentrale;
	private ArrayList<Kasse> kassen = new ArrayList<Kasse>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTageseinnahme() {
		return tageseinnahme;
	}
	public void setTageseinnahme(double tageseinnahme) {
		this.tageseinnahme = tageseinnahme;
	}
	public Zentrale getZentrale() {
		return zentrale;
	}
	public void setZentrale(Zentrale zentrale) {
		this.zentrale = zentrale;
	}
	public ArrayList<Kasse> getKassen() {
		return kassen;
	}
	public void setKassen(ArrayList<Kasse> kassen) {
		this.kassen = kassen;
	}
	public Supermarkt(String name, Zentrale zentrale) {
		super();
		this.name = name;
		this.zentrale = zentrale;
	}
	
	//um TagesEinnahmen der Superm�rkte zu berechnen
	public double tageinges(){
		//damit immer das Richtige rauskommt
		this.tageseinnahme = 0;
		//':' steht f�r 'in'
		for(Kasse k:this.kassen){
			this.tageseinnahme = this.tageseinnahme + k.tageinges();
		}
		return this.tageseinnahme;
	}
	
	
}
