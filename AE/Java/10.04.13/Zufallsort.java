public class Zufallsort{

	public static void main(String[] args) {
		int zahlen[]= new int[400];//array anlegen
		int temp;//zwischenspeicher anlegen
		boolean flag = true;
		for(int i = 0; i < zahlen.length; i++){
			zahlen[i]= (int) (Math.random()*((300-10)+1)+10);
		}
		while(flag){
			flag = false;
			for(int i=0; i<zahlen.length-1; i++){
				if(zahlen[i]> zahlen[(i+1)]){
					temp = zahlen[i];
					zahlen[i] = zahlen[(i+1)];
					zahlen[(i+1)] = temp;
					flag = true;
				}
			}
		}
		for(int element:zahlen){
			for (int element2:element) {
				System.out.println(element2);
			}
			System.out.println(element);
		}
		System.out.println(zahlen);
	}
}