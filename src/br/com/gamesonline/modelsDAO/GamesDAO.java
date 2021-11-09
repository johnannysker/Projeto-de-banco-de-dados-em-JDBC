package br.com.gamesonline.modelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.com.gamesonline.models.Game;
import br.com.gamesonline.conectaProj.conectaBD;

public class GamesDAO {
	
private Connection con;
	
	
	public GamesDAO() throws SQLException, ClassNotFoundException{
		super();
		this.con = conectaBD.CriaConexao();
	}


	public void insertGame(Game game) {
		String sql = "INSERT INTO game(game_id, id_Gen, nome_game, preco, classificacao) VALUES (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement org = (PreparedStatement) con.prepareStatement(sql);
			org.setInt(1,  game.getGame_id());
			org.setInt(2, game.getId_Gen());
			org.setString(3, game.getNome_game());
			org.setDouble(4, game.getPreco());
			org.setInt(5, game.getClassificacao());
			
			
			org.execute();
			org.close();
			
			System.out.println("Game adicionado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro - "+ e.getMessage());
		}
	}
	
	public void updateGame(Game game) {
		String sql = "UPDATE game SET preco = ? WHERE game_id = ?";
		
		try {
			PreparedStatement update = (PreparedStatement) con.prepareStatement(sql);
			update.setDouble(1, game.getPreco());
			update.setInt(2, game.getGame_id());
			
			update.execute();
			update.close();
			
			System.out.println("Alteração realizada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getMessage());
			
		}
	}
	
	//Listando os games
	public List<Game> gameVerTodos(){
		String sql = "SELECT * FROM game";
		List<Game> lista = new ArrayList<Game>();
		
		try {
			PreparedStatement selecao = (PreparedStatement) con.prepareStatement(sql);
			ResultSet dados = selecao.executeQuery();
			while(dados.next()) {
				Game game2 = new Game();
				game2.setGame_id(dados.getInt("game_id"));
				game2.setId_Gen(dados.getInt("id_Gen"));
				game2.setNome_game(dados.getString("nome_game"));
				game2.setPreco(dados.getDouble("preco"));
				game2.setClassificacao(dados.getInt("classificacao"));
				lista.add(game2);
			}
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getLocalizedMessage());
			
		}
	
		return lista;	
	}
	
	public void delGame(Game game) {
		String sql = "DELETE FROM game WHERE game_id = ?";
		
		try {
			PreparedStatement delete = (PreparedStatement) con.prepareStatement(sql);
			delete.setInt(1, game.getGame_id());
			
			delete.execute();
			delete.close();
			
			System.out.println("Game deletado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getMessage());
			System.out.println("Exclua primeiro a venda referente a esse game");
			
		}
	}

}
