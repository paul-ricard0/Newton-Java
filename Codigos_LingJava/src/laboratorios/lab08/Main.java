package laboratorios.lab08;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws Exception {
		Connection con = null;
		int op=0;
		
		try {
			con = Tools.obterConecao();
			
			while(op != 6) {
				op = Tools.menu();
				
				switch (op) {
					case 1: // listagem
						Tools.select(con);
						
						break;
					case 2: // criar
						var titulo2 = JOptionPane.showInputDialog("Informe o Titulo:");
						var autor2 = JOptionPane.showInputDialog("Informe o Autor:");
						var ano_publicacao2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano de publicacao:"));
						var editora2 = JOptionPane.showInputDialog("Informe a editora:");
						var categorias2 = JOptionPane.showInputDialog("Informe a categoria:");
						Tools.criar(con,titulo2, autor2, ano_publicacao2, editora2, categorias2);
						
						break;
					case 3: // obter por ID
						var titulo3 =JOptionPane.showInputDialog("Informe o Titulo:");
						Tools.selectCategorias(con, titulo3);
						
						break;
					case 4: // obter por ID
						var categorias4 =JOptionPane.showInputDialog("Informe a categoria:");
						Tools.selectCategorias(con, categorias4);
						
						break;
					case 5: // obter por ID
						var id5 =Integer.parseInt(JOptionPane.showInputDialog("Informe o ID deseja deletar:"));
						Tools.deleteId(con, id5);
						
						break;
				}
			}
			System.out.println("Tenha um �timo dia :)");
		} catch (ClassNotFoundException e) {
			System.out.println("ERRO: driver de conex�o n�o encontrado.");
			
		} catch (SQLException e) {
			System.out.println("ERRO: n�o foi poss�vel conectar com banco - " + e.getMessage());
			
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}  finally {
			Tools.closeCon(con);
		}

	}
	
}
