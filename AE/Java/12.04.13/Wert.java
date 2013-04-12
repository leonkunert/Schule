public class Wert{

	public static void main(String[] args) {
		int value 			= 1000;
		int years			= 0;
		double  value_shortage 	= 0.15;

		for(int i=0; i<years; i++){
			value = (value-(value*(1-value_shortage)));
		}

		System.out.println(value);
	}
}