package br.com.gamesonline.modelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import be.com.gamesonline.models.Venda;
import br.com.gamesonline.conectaProj.conectaBD;

public class VendaDAO {
	
	private Connection con;
	
	
	public VendaDAO() throws SQLException, ClassNotFoundException{
		super();
		this.con = conectaBD.CriaConexao();
	}


	public void insertVenda(Venda venda) {
		String sql = "INSERT INTO venda(venda_id, id_game, id_gen, qtd_itens, data_venda) VALUES (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement org = (PreparedStatement) con.prepareStatement(sql);
			org.setInt(1, venda.getVenda_id());;
			org.setInt(2, venda.getId_game());
			org.setInt(3, venda.getId_gen());
			org.setInt(4, venda.getQtd_itens());
			org.setString(5, venda.getData_venda());
			
			
			org.execute();
			org.close();
			
			System.out.println("Venda adicionado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro - "+ e.getMessage());
		}
		
	}
	
	//Listando todas as vendas
	public List<Venda> vendaVerTodos(){
		String sql = "SELECT * FROM venda";
		List<Venda> lista = new ArrayList<Venda>();
		
		try {
			PreparedStatement selecao = (PreparedStatement) con.prepareStatement(sql);
			ResultSet dados = selecao.executeQuery();
			while(dados.next()) {
				Venda venda2 = new Venda();
				venda2.setVenda_id(dados.getInt("venda_id"));
				venda2.setId_game(dados.getInt("id_game"));
				venda2.setId_gen(dados.getInt("id_gen"));
				venda2.setQtd_itens(dados.getInt("qtd_itens"));
				venda2.setData_venda(dados.getString("data_venda"));
				lista.add(venda2);
			}
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getLocalizedMessage());
			
		}	
		return lista;	
	}
	
	//Excluindo venda
	public void delVenda(Venda venda) {
		String sql = "DELETE FROM venda WHERE venda_id = ?";
		
		try {
			PreparedStatement delete = (PreparedStatement) con.prepareStatement(sql);
			delete.setInt(1, venda.getVenda_id());
			
			delete.execute();
			delete.close();
			
			System.out.println("Venda deletada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getMessage());
			
		}
	}

}
