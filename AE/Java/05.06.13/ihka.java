import java.util.Date;
import java.util.Calendar;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		generateCode(2321, new Date());
	}
	
	private static long generateCode(int kdnr, Date date) {
		String herkunft = getHerkunft(kdnr);
		String kw = getKWJahr(date);
		
		int woche = Integer.valueOf(kw.substring(0, 2));
		int jahr = Integer.valueOf(kw.substring(2, 6));
		int ascii1 = (int)herkunft.charAt(0);
		int ascii2 = (int)herkunft.charAt(1);
		int ascii3 = (int)herkunft.charAt(2);
		
		long result = (((((((ascii1*91)+ascii2)*91 )+ ascii3)*54 )+ woche)* 2300 )+ jahr;
		System.out.println(ascii1);
		System.out.println(ascii2);
		System.out.println(ascii3);
		System.out.println(woche);
		System.out.println(jahr);
		System.out.println(result);
		return result;
	}
	
	private static String getHerkunft(int kdnr){
		return "GER";
	}
	
	private static String getKWJahr(Date date){
		return "392011";
	}
}