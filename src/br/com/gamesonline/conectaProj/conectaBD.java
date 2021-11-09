package br.com.gamesonline.conectaProj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conectaBD {
	
	static final String URL = "jdbc:postgresql://localhost:5432/loja_gamesBD";
	static final String USER = "postgres";
	static final String PASS = "postgre";
	
	public static Connection CriaConexao() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection conexao = DriverManager.getConnection(URL, USER, PASS);
		
		if(conexao != null) {
			System.out.println("Conexão OK");
			return conexao;
		}
		return null;
		
	}

}
