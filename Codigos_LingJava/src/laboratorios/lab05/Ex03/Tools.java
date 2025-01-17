package laboratorios.lab05.Ex03;

import java.util.HashSet;
import java.util.Set;

public class Tools {
	
	public static void validarCPF(String cpf)throws  ExcepFormatoInvalido, 
				ExcepNaoDigito, ExcepVazio, ExcepSequenciaInvalida, ExcepDigitoInvalido{
		
		verificarFormatoCPF(cpf);
		verificarSequencia(cpf);
		verificarDigito01(cpf);
		verificarDigito02(cpf);
		

	}


	//*************** M�TODOS ********************//

	private static void verificarFormatoCPF(String cpfStr) throws ExcepFormatoInvalido, ExcepNaoDigito, ExcepVazio{

		if(!cpfStr.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")) {
			throw new ExcepFormatoInvalido();
		}
		
		//por seguran�a
		verificarDigitos(cpfStr);
		verificarVazio(cpfStr);
	}
	
	//validando primeiro digito
	private static void verificarDigito01 (String cpfStr)throws  ExcepDigitoInvalido {
		
		cpfStr=cpfStr.replace(".", " ");
		cpfStr=cpfStr.replace("-", " ");
		cpfStr=cpfStr.replaceAll(" ", "");
		
		int cont = 10;
		int total = 0;
		for(int i = 0; i<cpfStr.length()-2; i++) {
			int cpf = Integer.parseInt((cpfStr.charAt(i)+""));
			cpf = cpf * cont;
			total = total + cpf;
			cont--;
		}
		
		total = (total * 10) % 11;
		
		if(total == 10) {
			total = 0;
		}
		
		
		if(total != Integer.parseInt(cpfStr.charAt(9)+"")){
			throw new   ExcepDigitoInvalido();
			
		}
	}
	
	//validando segundo digito
	private static void verificarDigito02 (String cpfStr)throws  ExcepDigitoInvalido {
		
		cpfStr=cpfLimpo(cpfStr);
		
		int cont = 11;
		int total = 0;
		for(int i = 0; i<cpfStr.length()-1; i++) {
			int cpf = Integer.parseInt((cpfStr.charAt(i)+""));
			cpf = cpf * cont;
			total = total + cpf;
			cont--;
		}
		
		total = (total * 10) % 11;
		
		if(total == 10) {
			total = 0;
		}
		
		
		if(total != Integer.parseInt(cpfStr.charAt(10)+"")){
			throw new   ExcepDigitoInvalido();
			
		}
		
		
	}
	
	//Validando sequencia
	private static void verificarSequencia(String cpfStr)throws ExcepSequenciaInvalida{
        Set<Character> cpfSet = new HashSet<>();
        cpfStr=cpfLimpo(cpfStr);
        
        for(int i=0; i< cpfStr.length(); i++) {
        	cpfSet.add(cpfStr.charAt(i));
        }
        
        if(cpfSet.size() == 1 | cpfSet.size() ==0) {
        	throw new ExcepSequenciaInvalida();
        }
    }
	
	//deixar s� n�meros no cpf
	private static String cpfLimpo(String cpfStr) {
		cpfStr=cpfStr.replace(".", " ");
		cpfStr=cpfStr.replace("-", " ");
		cpfStr=cpfStr.replaceAll(" ", "");
		
		return cpfStr;
	}
	
	//ver se tem apenas n�meros
	private static void verificarDigitos(String cpfStr) throws ExcepNaoDigito{
		cpfStr = cpfLimpo(cpfStr);
		for(int i=0; i < cpfStr.length(); i++) {
			if(!Character.isDigit(cpfStr.charAt(i))) {
				throw new ExcepNaoDigito();
			}
		}
	}
	
	//verificar vazio
	private static void verificarVazio(String cpf) throws ExcepVazio{
		if(cpf.isBlank() || cpf.isEmpty()){
			throw new ExcepVazio();
		}
	}
	
	
	
}

