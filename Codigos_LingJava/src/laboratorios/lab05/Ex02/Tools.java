package laboratorios.lab05.Ex02;

public class Tools {
	
	
	public static void validarSenha(String senha) 
			throws ExcepSenhaInvalida{
		
		String carak02 = "";
		String carak01 = "";
		Boolean simbolo = false;
		Boolean upper = false;
		Boolean num = false;
		char ch;
		
		
		// Validando o Tamanho
		if(senha.length() < 8 || senha.length() > 12) {
			throw new ExcepSenhaInvalida("Tamanho m�nimo 8 m�ximo 12");
		}
		
		for (int i=0; i<senha.length(); i++) {
			ch =senha.charAt(i);
			carak01 = ""+ch;
			
			
			//Verificando se tem sequ�ncia
			if(carak01.equals(carak02)) {
				throw new ExcepSenhaInvalida("N�o pode haver repeti��es: ex AA, cc");
			}else {
				carak02=""+senha.charAt(i);
			}
			
			//Verificando se tem espa�o
			if(ch == ' ') {
				throw new ExcepSenhaInvalida("N�o pode ter espa�os");
			}

			//verificando se tem simbolo
			if(carak01.equals("!") || carak01.equals("@") || carak01.equals("#") 
					|| carak01.equals("?") || carak01.equals("]")  ) {
				simbolo = true;
			}
			
			//Verificando se tem mai�scula
			if(Character.isUpperCase(ch)) {
				upper = true;
			}
			
			//Verificando se tem n�mero
			if(Character.isDigit(ch)) {
				num = true;
			}

		}
		
		if(!simbolo) {
			throw new ExcepSenhaInvalida("M�nimo um dos s�mbolos ! @ # ? ]");
		}
		
		if(!upper) {
			
			throw new ExcepSenhaInvalida("M�nimo uma letra mai�scula");
		}
		
		if(!num) {
			throw new ExcepSenhaInvalida("M�nimo um d�gito (0-9)");
		}
		
		
	}
}

