public class Handy{

	public static void main(String[] args) {
		int min = 221203; //Gespraechsminuten
		double basic_bill= 22.98;
		double bill = 0;
		int inc_min = 30;
		double price_min = 0.24;
		if(min>inc_min){
			bill = (bill+(price_min*(min-inc_min)));
		}

		System.out.println("Ihre Rechnung betraegt: ");
		System.out.println(basic_bill);
		System.out.println("+"+bill);
		System.out.println("-------------------------");
		System.out.println((basic_bill+bill));
	}
}