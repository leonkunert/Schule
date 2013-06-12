
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bay[] ship = new Bay[Constants.BAYS_COUNT];
		for (byte i = 0; i < ship.length; i++) {
			ship[i] = new Bay();
		}
		loadCargo(ship);
	}
	
	private static void loadCargo(Bay[] ship) {
		Container[] toLoad = new Container[12];
		putInTestData(toLoad);

		for (Container container : toLoad) {
			if (!loadContainer(ship, container)) {
				System.out.println("No space left!");
				break;
			}
		}

		System.out.println("Bays werden von unten nach oben ausgegeben");
		for (Bay bay : ship) {
			System.out.println("**Bay***");
			for (Container container : bay.getCargo()) {
				System.out.println(container.getContainerNr());
			}
		}
	}
	
	private static boolean loadContainer(Bay[] ship, Container toLoad) {
		boolean result = true;
		Bay bestBay = null;
		int bestWeight = 0;

		//search lowest weight
		for (Bay bay : ship) {
			//if there is space left
			if (!bay.isFull()) {
				if ((bay.getBayWeight() < bestWeight) || (bestBay == null)){
					bestWeight = bay.getBayWeight();
					bestBay = bay;
				}
			}
		}
		
		if (bestBay == null) {
			result = false;
		} else {
			bestBay.putContainer(toLoad);
		}
		return result;
	}
	
	private static void putInTestData(Container[] toLoad){
		Container tmp1,tmp2,tmp3,tmp4,tmp5,tmp6,tmp7,tmp8,tmp9,tmp10,tmp11,tmp12;
		tmp1 = new Container(1, (byte)23);
		tmp2 = new Container(2, (byte)22);
		tmp3 = new Container(3, (byte)11);
		tmp4 = new Container(4, (byte)10);
		tmp5 = new Container(5, (byte)9);
		tmp6 = new Container(6, (byte)9);
		tmp7 = new Container(7, (byte)8);
		tmp8 = new Container(8, (byte)8);
		tmp9 = new Container(9, (byte)8);
		tmp10 = new Container(10, (byte)7);
		tmp11 = new Container(11, (byte)7);
		tmp12 = new Container(12, (byte)6);
		
		toLoad[0] = tmp1;
		toLoad[1] = tmp2;
		toLoad[2] = tmp3;
		toLoad[3] = tmp4;
		toLoad[4] = tmp5;
		toLoad[5] = tmp6;
		toLoad[6] = tmp7;
		toLoad[7] = tmp8;
		toLoad[8] = tmp9;
		toLoad[9] = tmp10;
		toLoad[10] = tmp11;
		toLoad[11] = tmp12;

	}

}
