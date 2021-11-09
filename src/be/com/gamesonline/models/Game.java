package be.com.gamesonline.models;

public class Game {
	
	private int game_id;
	
	private int id_Gen;
	
	private String nome_game;
	
	private double preco;
	
	private int classificacao;

	
	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public String getNome_game() {
		return nome_game;
	}

	public void setNome_game(String nome_game) {
		this.nome_game = nome_game;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public int getId_Gen() {
		return id_Gen;
	}

	public void setId_Gen(int id_Gen) {
		this.id_Gen = id_Gen;
	}
	
	
	

}
