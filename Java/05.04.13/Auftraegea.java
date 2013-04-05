public class Auftraegea{

	public static void main(String[] args) {
		int anz = 7;
		String str = "";
		for (int i = 1; i<=anz;i++) {//Printing lines
			for(int y = 1; y<=i; y++){//Printing Numbers
				str = str+i;
			}
			System.out.println(str);//printing variable in the console
			str = "";
		}
	}
}