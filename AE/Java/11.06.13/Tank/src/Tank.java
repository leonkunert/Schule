
public class Tank {
	
	private int maximum;
	private float fuellstand;

	public Tank(int maximum, float fuellstand) {
		super();
		this.maximum = maximum;
		this.fuellstand = fuellstand;
	}
	
	public float zeigeFullstand() {
		return this.fuellstand;
	}
	
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public float getFuellstand() {
		return fuellstand;
	}
	public void setFuellstand(float fuellstand) {
		this.fuellstand = fuellstand;
	}
	
	@Override
	public String toString() {
		return "Tank [maximum=" + maximum + ", fuellstand=" + fuellstand + "]";
	}
	
}
