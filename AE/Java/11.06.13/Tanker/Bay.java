
public class Bay {

	private boolean isFull = false;
	private int bayWeight = 0;
	private Container[] cargo = new Container[Constants.MAX_TIERS_COUNT];
	private byte fillCount = 0;
	
	public Container[] getCargo() {
		return cargo;
	}
	public void setCargo(Container[] cargo) {
		this.cargo = cargo;
	}
	public boolean isFull() {
		return isFull;
	}
	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	public int getBayWeight() {
		return bayWeight;
	}
	public void setBayWeight(int bayWeight) {
		this.bayWeight = bayWeight;
	}
	public byte getFillCount() {
		return fillCount;
	}
	public void setFillCount(byte fillCount) {
		this.fillCount = fillCount;
	}
	
	public void putContainer(Container toPut){
		if (!isFull) {
			cargo[fillCount] = toPut;
			fillCount++;
			bayWeight += toPut.getContainerGewicht();
			if (fillCount >= cargo.length) {
				isFull = true;
			}
		}
	}
}
