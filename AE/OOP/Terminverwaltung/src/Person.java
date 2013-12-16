import java.util.ArrayList;

public class Person {
	private String name;
	private ArrayList<Termin> termine = new ArrayList<Termin>();
	
	public Person(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Termin> getTermine() {
		return termine;
	}
	public void setTermine(ArrayList<Termin> termine) {
		this.termine = termine;
	}
	public void addTermin(Termin t) {
		this.termine.add(t);
	}
	
	// Übersicht der Temine generieren
	public void uebersicht(){
		for(Termin t:this.termine){
			System.out.println(this.name+" hat "+t.getBeschreibung());
		}
	}
}