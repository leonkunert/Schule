public class Zufallsort{

	public static void main(String[] args) {
		int zahlen[]= new int[300];
		int temp;
		boolean flag = true;
		for(int i = 0; i < zahlen.length; i++){
			zahlen[i]= (int) (Math.random()*300);
		}
		while(flag){
			flag = false;
			for(int i=0; i<zahlen.length-1; i++){
				if(zahlen[i]< zahlen[(i+1)]){
					temp = zahlen[i];
					zahlen[i] = zahlen[(i+1)];
					zahlen[(i+1)] = temp;
					flag = true;
				}
			}
		}
		for(int element:zahlen){
			System.out.println(element);
		}
	}
}