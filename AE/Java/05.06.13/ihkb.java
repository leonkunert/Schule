public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long code = 73813642111L;
		String result = getLand(code);
		System.out.println(result);
	}
	private static String getLand(long code){
		char erster, zweiter, dritter;
		int jahr = (int)code % 2300;
		code = code-jahr;
		code = code/2300;
		
		int kw = (int)code % 54;
		code = code-kw;
		code = code/54;
		
		erster = (char)(code % 91);
		code = code- code%91;
		code = code/91;
		
		zweiter = (char)(code % 91);
		code = code- code%91;
		code = code/91;
		
		dritter = (char)(code % 91);
		
		String result = String.valueOf(dritter) + String.valueOf(zweiter) +  String.valueOf(erster);
		return result;
	}
}
