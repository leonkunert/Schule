import java.util.ArrayList;

public class Termin {
	private String beschreibung;
	private Person person;
	private ArrayList<Person> teilnehmer = new ArrayList<Person>();
	
	public Termin(String beschreibung, Person person) {
		super();
		this.beschreibung = beschreibung;
		this.person = person;
		person.addTermin(this);
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public ArrayList getTeilnehmer() {
		return teilnehmer;
	}
	public void setTeilnehmer(ArrayList teilnehmer) {
		this.teilnehmer = teilnehmer;
	}
	public void addTeilnehmer(Person p) {
		this.teilnehmer.add(p);
		p.addTermin(this);
	}
}
