package be.com.gamesonline.models;


public class Venda {

	private int venda_id;
	
	private int id_game;
	
	private int id_gen;
	
	private int qtd_itens;
	
	private  String data_venda;

	public int getVenda_id() {
		return venda_id;
	}

	public void setVenda_id(int venda_id) {
		this.venda_id = venda_id;
	}

	public int getId_game() {
		return id_game;
	}

	public void setId_game(int id_game) {
		this.id_game = id_game;
	}

	public int getId_gen() {
		return id_gen;
	}

	public void setId_gen(int id_gen) {
		this.id_gen = id_gen;
	}

	public int getQtd_itens() {
		return qtd_itens;
	}

	public void setQtd_itens(int qtd_itens) {
		this.qtd_itens = qtd_itens;
	}

	public String getData_venda() {
		return data_venda;
	}

	public void setData_venda(String data_venda) {
		this.data_venda = data_venda;
	}


	
	
}
