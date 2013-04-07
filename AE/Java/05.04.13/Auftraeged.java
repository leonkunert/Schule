public class Auftraeged{

	public static void main(String[] args) {
		int anz = 20;//width and height
		String str = "";
		for (int y = 1; y<=anz; y++) {//vertical
			for(int x = 1; x<=anz; x++){//horizontal
				str = str+" "+(x*y);
				System.out.print(str);
				str = "";
			}
			System.out.println();
		}
	}
}