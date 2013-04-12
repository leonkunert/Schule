public class Handy{

	public static void main(String[] args) {
		int min = 400; //Gespraechsminuten
		double bill= 22.98;
		if(min>30){
			bill = (bill+(0.24*(min-30)));
		}
		System.out.println("Ihre Rechnung betraegt:" +bill);
	}
}