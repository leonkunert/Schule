
public class Container {

	private int containerNr;
	private byte containerGewicht;
	
	public Container(int containerNr, byte containerGewicht) {
		this.setContainerNr(containerNr);
		this.setContainerGewicht(containerGewicht);
	}

	public int getContainerNr() {
		return containerNr;
	}

	public void setContainerNr(int containerNr) {
		this.containerNr = containerNr;
	}

	public byte getContainerGewicht() {
		return containerGewicht;
	}

	public void setContainerGewicht(byte containerGewicht) {
		this.containerGewicht = containerGewicht;
	}
	
}
