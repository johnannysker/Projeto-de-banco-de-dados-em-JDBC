package br.com.gamesonline.aplicacao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import be.com.gamesonline.models.Game;
import br.com.gamesonline.modelsDAO.GamesDAO;



public class GameMetodos {

	//Criação do método para preencher a tabela
		public static void addGame() {
			Game game = new Game();
			String sid = JOptionPane.showInputDialog("Digite o id do game");
			int id = Integer.parseInt(sid);
			game.setGame_id(id);
			String sidG = JOptionPane.showInputDialog("Digite o id do genero");
			int idGen = Integer.parseInt(sidG);
			game.setId_Gen(idGen);
			String NomeGame = JOptionPane.showInputDialog("Digite o nome do game");
			game.setNome_game(NomeGame);
			String spreco = JOptionPane.showInputDialog("Digite o preço do game");
			double preco = Double.parseDouble(spreco);
			game.setPreco(preco);
			String sclass = JOptionPane.showInputDialog("Qual a classificação do game?");
			int clss = Integer.parseInt(sclass);
			game.setClassificacao(clss);
			
			GamesDAO gamDAO = null;
			
			try {
				gamDAO = new GamesDAO();
			} catch (ClassNotFoundException e) {
				System.out.println("Classe inexistente!");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Busque o erro "+e.getLocalizedMessage());
				e.printStackTrace();
			}
			
			gamDAO.insertGame(game);
		}
		
		//UpdateGame
		public static void alteraPrecoGame() {
			Game game = new Game();
			String sid = JOptionPane.showInputDialog("Digite o id do game");
			int id = Integer.parseInt(sid);
			game.setGame_id(id);
			String spreco = JOptionPane.showInputDialog("Digite o novo preço do game");
			double preco = Double.parseDouble(spreco);
			game.setPreco(preco);
			
			GamesDAO gamDAO = null;
			
			try {
				gamDAO = new GamesDAO();
			} catch (ClassNotFoundException e) {
				System.out.println("Classe inexistente!");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Busque o erro "+e.getLocalizedMessage());
				e.printStackTrace();
			}
			
			gamDAO.updateGame(game);
		}
		//Listando os jogos
		public static void listaTodosJogos() {
			GamesDAO gameDAO = null;
			
			try {
				gameDAO = new GamesDAO();
			} catch (ClassNotFoundException e) {
				System.out.println("Classe não encontrada");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Busque o erro"+e.getLocalizedMessage());			
			}
			List<Game> resulDados = gameDAO.gameVerTodos();
			System.out.println("TABELA DE GAMES");
			for(Game g: resulDados) {
				System.out.println("ID: "+g.getGame_id()+"\n"+
								"ID Genero: "+g.getId_Gen()+"\n"+
								"Nome: "+g.getNome_game()+"\n"+
								"Preço: "+g.getPreco()+"\n"+
								"Classificação: "+g.getClassificacao());
			}
		}
		
		//Excluindo game
		public static void excluiGame() {
			Game game = new Game();
			String sid = JOptionPane.showInputDialog("Digite o id do game para excluir");
			int id = Integer.parseInt(sid);
			game.setGame_id(id);
			
			GamesDAO gameDAO = null;
			
			try {
				gameDAO = new GamesDAO();
			} catch (ClassNotFoundException e) {
				System.out.println("Classe inexistente.");
				
			} catch (SQLException e) {
				System.out.println("Busque o erro"+e.getLocalizedMessage());
				
			}
			
			gameDAO.delGame(game);
		}
}
