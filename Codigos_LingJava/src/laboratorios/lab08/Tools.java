package laboratorios.lab08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Tools {
	
	static final String DRIVER = "org.h2.Driver";
	static final String URL = "jdbc:h2:file:~/NewtonDados/livros/livros";
	static final String USER = "root";
	static final String PW = "";

	public static int menu() {
		return Integer.parseInt( JOptionPane.showInputDialog(""
				+ "                            < MENU > \n"
				+ "1 - Listar tabela\n"
				+ "2 - Adicionar na tabela\n"
				+ "3 - Listar por titulo\n"
				+ "4 - Listar para categorias\n"
				+ "5 - Deletar\n"
				+ "6 - Sair\n"
				+ "\nSelecione uma das op��es acima:"));
	}
	
	public static Connection obterConecao() throws Exception {
		Connection con = null;
		
		Class.forName(DRIVER); //testando carga do driver
		
		con = DriverManager.getConnection(URL, USER, PW); // Obtendo conex�o
		System.out.println("Conex�o obtida com SUCESSO!\n");
		
		return con;
	}
	
	public static void closeCon(Connection con) throws SQLException{
			if (con != null && !con.isClosed()) {
				con.close();
				System.out.println("\nINFO: conex�o com o banco ENCERRADA");
			}else {
				System.out.println("\nINFO: conex�o inexistente ou j� encerrada");
			}
	 }
	
	public static void select(Connection con) throws SQLException{

		var statement = con.createStatement();
		var txtSql = "select * from livros";
		
		var result = statement.executeQuery(txtSql);
		var tabela = new ArrayList<String>();
		
		if(result.next() == false) {
			System.out.println("Nenhum resultado encontrado.");
		}else {
			//Processamento
			
			while(result.next()) {
				var id = result.getInt("id");
				var titulo = result.getString("titulo");
				var autor = result.getString("autor");
				var ano_publicacao = result.getInt("ano_publicacao");
				var editora = result.getString("editora");
				var categorias = result.getString("categorias");
				
				var line = id + " | " + titulo + " | " + autor + " | "
						+ ano_publicacao  + " | " + editora  + " | " + categorias;
				
				tabela.add(line);
			}
		}

		result.close();
		statement.close();
		String JO = "";
		System.out.println("\n=========================================");
		for(var item: tabela) {
			JO = JO+"\n"+item;
			System.out.println(item);
		}
		System.out.println("\n=========================================");
		JOptionPane.showInputDialog(JO);
	}
	
	public static void criar(Connection con, String titulo, String autor, 
			int ano_publicacao, String editora, String categorias) throws Exception{
		
		var statement = con.createStatement();
		var sql = "insert into livros (titulo, autor, ano_publicacao, editora, categorias) "
				+ "values('" +titulo+ "', '" +autor+  "', " +ano_publicacao+ ", '" +
				editora+ "', '" +categorias+ "')"; 
		
		var res = statement.executeUpdate(sql);
		System.out.println("\nLinhas atualizadas: " + res);
		
		statement.close();
	}

	public static void selectTitulo(Connection con, String titulo) throws SQLException{
		var  statement = con.createStatement();
		
		var sql = "select * from livros where titulo = '"+titulo.toLowerCase()+"'";
		var result = statement.executeQuery(sql);
		
		var tabela = new ArrayList<String>();
		if (result.next() == false) {
			System.out.println("=========================================");
			System.out.println("Nenhum resultado encontrado.");
			System.out.println("=========================================");
		}else {
			do{
				var id = result.getInt("id");
				var titulox = result.getString("titulo");
				var autor = result.getString("autor");
				var ano_publicacao = result.getInt("ano_publicacao");
				var editora = result.getString("editora");
				var categorias = result.getString("categorias");
				
				var line = id + " | " + titulox + " | " + autor + " | "
						+ ano_publicacao  + " | " + editora  + " | " + categorias;
				
				tabela.add(line);
			}while(result.next()); 
			
			System.out.println("=========================================");
			for(var item: tabela) {
				System.out.println(item);
			}
			System.out.println("=========================================");
		}
		
		result.close();
		statement.close();
		
		
	}
	
	public static void selectCategorias(Connection con, String categorias) throws SQLException{
		var  statement = con.createStatement();
		
		var sql = "select * from livros where categorias = '"+categorias.toLowerCase()+"'";
		var result = statement.executeQuery(sql);
		
		var tabela = new ArrayList<String>();
		if (result.next() == false) {
			System.out.println("=========================================");
			System.out.println("Nenhum resultado encontrado.");
			System.out.println("=========================================");
		}else {
			do{
				var id = result.getInt("id");
				var titulo = result.getString("titulo");
				var autor = result.getString("autor");
				var ano_publicacao = result.getInt("ano_publicacao");
				var editora = result.getString("editora");
				var categoriasx = result.getString("categorias");
				
				var line = id + " | " + titulo + " | " + autor + " | "
						+ ano_publicacao  + " | " + editora  + " | " + categoriasx;
				
				tabela.add(line);
			}while(result.next()); 
			
			System.out.println("=========================================");
			for(var item: tabela) {
				System.out.println(item);
			}
			System.out.println("=========================================");
		}
		
		result.close();
		statement.close();
		
		
		
	}
	
	public static void deleteId(Connection con, int id) throws SQLException{
		
		var statement = con.createStatement();
		var sql = "delete from livros where id = "+id;
		
		var res = statement.executeUpdate(sql);
		System.out.println("\nLinhas atualizadas: " + res);
		statement.close();
	}
}
