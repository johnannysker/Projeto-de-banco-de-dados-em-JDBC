package br.com.gamesonline.modelsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import be.com.gamesonline.models.Genero;
import br.com.gamesonline.conectaProj.conectaBD;

public class GeneroDAO {
	
	private Connection con;
	
	
	public GeneroDAO() throws SQLException, ClassNotFoundException{
		super();
		this.con = conectaBD.CriaConexao();
	}


	public void insertGenero(Genero genero) {
		
		String sql = "INSERT INTO genero(gen_id, nome_genero, plataforma) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement org = (PreparedStatement) con.prepareStatement(sql);
			org.setInt(1,  genero.getGen_id());
			org.setString(2, genero.getNome_genero());
			org.setString(3, genero.getPlataforma());
			
			
			org.execute();
			org.close();
			
			System.out.println("Genero adicionado ao genero com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro - "+ e.getMessage());
		}
	}
	
	public void updateGeneroNome(Genero genero) {
		
		String sql = "UPDATE genero SET nome_genero = ? WHERE gen_id = ?";
		
		try {
			PreparedStatement update = (PreparedStatement) con.prepareStatement(sql);
			update.setString(1, genero.getNome_genero());
			update.setInt(2, genero.getGen_id());
			
			update.execute();
			update.close();
			
			System.out.println("Alteração realizada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getMessage());
			
		}
	}
	
	public void updateGeneroPlataforma(Genero genero) {
		
		String sql = "UPDATE genero SET plataforma = ? WHERE gen_id = ?";
		
		try {
			PreparedStatement update = (PreparedStatement) con.prepareStatement(sql);
			update.setString(1, genero.getPlataforma());
			update.setInt(2, genero.getGen_id());
			
			update.execute();
			update.close();
			
			System.out.println("Alteração realizada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getMessage());
			
		}
	}
	//Excluindo genero
	public void delGenero(Genero genero) {
		String sql = "DELETE FROM genero WHERE gen_id = ?";
		
		try {
			PreparedStatement delete = (PreparedStatement) con.prepareStatement(sql);
			delete.setInt(1, genero.getGen_id());
			
			delete.execute();
			delete.close();
			
			System.out.println("Genero deletado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getMessage());
			System.out.println("Exclua primeiro o game referente a esse genero");
			
		}
	}
	
	//Visualizando todos os genero
	public List<Genero> generoVerTodos(){
		String sql = "SELECT * FROM genero";
		List<Genero> lista = new ArrayList<Genero>();
		
		try {
			PreparedStatement selecao = (PreparedStatement) con.prepareStatement(sql);
			ResultSet dados = selecao.executeQuery();
			while(dados.next()) {
				Genero gen2 = new Genero();
				gen2.setGen_id(dados.getInt("gen_id"));
				gen2.setNome_genero(dados.getString("nome_genero"));
				gen2.setPlataforma(dados.getString("plataforma"));
				lista.add(gen2);
			}
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getLocalizedMessage());
			
		}
	
		return lista;
		
	}
}
