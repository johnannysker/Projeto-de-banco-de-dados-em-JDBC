package br.com.gamesonline.aplicacao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import be.com.gamesonline.models.Venda;
import br.com.gamesonline.modelsDAO.VendaDAO;


public class VendaMetodos {

	//Criação do método para preencher a tabela
			public static void addVenda() {
				Venda venda = new Venda();
				String sid = JOptionPane.showInputDialog("Digite o id da venda");
				int id = Integer.parseInt(sid);
				venda.setVenda_id(id);
				String sidGame = JOptionPane.showInputDialog("Digite o id do game");
				int idGame = Integer.parseInt(sidGame);
				venda.setId_game(idGame);
				String sidGen = JOptionPane.showInputDialog("Digite o id do genero");
				int idGen = Integer.parseInt(sidGen);
				venda.setId_gen(idGen);
				String sqtd = JOptionPane.showInputDialog("Digite a quantidade de itens");
				int qtdI = Integer.parseInt(sqtd);
				venda.setQtd_itens(qtdI);
				String data = JOptionPane.showInputDialog("Digite a data da venda (dd/MM/yyyy)");
				venda.setData_venda(data);
				
				VendaDAO venDAO = null;
				
				try {
					venDAO = new VendaDAO();
				} catch (ClassNotFoundException e) {
					System.out.println("Classe inexistente!");
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("Busque o erro "+e.getLocalizedMessage());
					e.printStackTrace();
				}
				
				venDAO.insertVenda(venda);
			}
			//Listando as vendas
			public static void listaTodasVendas() {
				VendaDAO vendaDAO = null;
				
				try {
					vendaDAO = new VendaDAO();
				} catch (ClassNotFoundException e) {
					System.out.println("Classe não encontrada");
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("Busque o erro"+e.getLocalizedMessage());			
				}
				List<Venda> resulDados = vendaDAO.vendaVerTodos();
				System.out.println("TABELA DE VENDAS");
				for(Venda v: resulDados) {
					System.out.println("ID: "+v.getVenda_id()+"\n"+
									"ID Game: "+v.getId_game()+"\n"+
									"ID Genero: "+v.getId_gen()+"\n"+
									"Quantidade: "+v.getQtd_itens()+"\n"+
									"Data da venda: "+v.getData_venda());
				}
			}
			
			//Excluindo venda
			public static void excluiVenda() {
				Venda venda = new Venda();
				String sid = JOptionPane.showInputDialog("Digite o id da venda para excluir");
				int id = Integer.parseInt(sid);
				venda.setVenda_id(id);
				
				VendaDAO vendaDAO = null;
				
				try {
					vendaDAO = new VendaDAO();
				} catch (ClassNotFoundException e) {
					System.out.println("Classe inexistente.");
					
				} catch (SQLException e) {
					System.out.println("Busque o erro"+e.getLocalizedMessage());
					
				}
				
				vendaDAO.delVenda(venda);
			}
}
