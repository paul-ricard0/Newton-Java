package provas.av2.exer03;

import java.util.Scanner;

public class Exer03 {
	
	public static void main(String[] args) throws ExcepNaoNumero, ExcepVazio{
		Scanner scan = new Scanner(System.in);
		try {
			
			System.out.print("Digite um n�mero: ");
			var entrada = scan.nextLine();
			
			validarVazio(entrada);
			validarTrueNumero(entrada);
			float valor = Float.parseFloat(entrada);

			System.out.println("Voc� digitou: " + valor);
		} catch (ExcepNaoNumero | ExcepVazio ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private static void validarVazio(String num) throws ExcepVazio{
		if(num == null || num.trim().length() == 0){
			throw new ExcepVazio();
		}
	}

	private static void validarTrueNumero(String num) throws ExcepNaoNumero{
		for (int i=0; i<num.length(); i++) {
			char ch = num.charAt(i);
			if(!Character.isDigit(ch)) {
				throw new ExcepNaoNumero(num);
			}
		}
	}
}
