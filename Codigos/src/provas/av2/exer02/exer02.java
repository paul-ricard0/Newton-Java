package provas.av2.exer02;



public class exer02 {
	
	public static void main(String[] args) {
		
		int num = 12;
		
		var x1 = 1;
		var x0 = 0;
		var x = 0;
		
		for(int i = 1; i<=num-1; i++) {
			x = x1 + x0; 
			x0= x1;
			x1= x;
		}
		
		System.out.println("Resultado: "+ x);
		
	}
}
