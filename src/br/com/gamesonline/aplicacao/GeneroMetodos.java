package br.com.gamesonline.aplicacao;



import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import be.com.gamesonline.models.Genero;
import br.com.gamesonline.modelsDAO.GeneroDAO;

public class GeneroMetodos {
	//Criação do método para preencher a tabela
	public static void addGenero() {
		Genero gen = new Genero();
		String sid = JOptionPane.showInputDialog("Digite o id de um novo genero");
		int id = Integer.parseInt(sid);
		gen.setGen_id(id);
		String NomeGenero = JOptionPane.showInputDialog("Digite o nome do genero");
		gen.setNome_genero(NomeGenero);
		String platf = JOptionPane.showInputDialog("Digite o nome da plataforma do game");
		gen.setPlataforma(platf);
		
		//Instanciando a classe generoDAO nula
		GeneroDAO genDAO = null;
		
		//inicializando o objeto 
			try {
				genDAO = new GeneroDAO();
			} catch (ClassNotFoundException e) {
				System.out.println("Classe inexistente.");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Busque o erro"+e.getLocalizedMessage());
				e.printStackTrace();
			}
			
			//Inserindo a tabela no BD
			genDAO.insertGenero(gen);
	}
	
	public static void alteraGeneroNome() {
		Genero gen = new Genero();
		String sid = JOptionPane.showInputDialog("Digite o id do genero");
		int id = Integer.parseInt(sid);
		gen.setGen_id(id);
		String NomeGenero = JOptionPane.showInputDialog("Digite o novo nome do genero");
		gen.setNome_genero(NomeGenero);
		
		
		GeneroDAO genDAO = null;
		
		//inicializando o objeto 
			try {
				genDAO = new GeneroDAO();
			} catch (ClassNotFoundException e) {
				System.out.println("Classe inexistente.");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Busque o erro"+e.getLocalizedMessage());
				e.printStackTrace();
			}
			
			genDAO.updateGeneroNome(gen);
	}
	
	public static void alteraGeneroPlataforma() {
		Genero gen = new Genero();
		String sid = JOptionPane.showInputDialog("Digite o id do genero");
		int id = Integer.parseInt(sid);
		gen.setGen_id(id);
		String platf = JOptionPane.showInputDialog("Digite o nome da nova plataforma do game");
		gen.setPlataforma(platf);
		
		
		GeneroDAO genDAO = null;
		
		//inicializando o objeto 
			try {
				genDAO = new GeneroDAO();
			} catch (ClassNotFoundException e) {
				System.out.println("Classe inexistente.");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Busque o erro"+e.getLocalizedMessage());
				e.printStackTrace();
			}
			
			genDAO.updateGeneroPlataforma(gen);
	}
	
	//Excluindo Genero
	public static void excluiGenero() {
		Genero gen = new Genero();
		String sid = JOptionPane.showInputDialog("Digite o id do genero para excluir");
		int id = Integer.parseInt(sid);
		gen.setGen_id(id);
		
		GeneroDAO genDAO = null;
		
		try {
			genDAO = new GeneroDAO();
		} catch (ClassNotFoundException e) {
			System.out.println("Classe inexistente.");
			
		} catch (SQLException e) {
			System.out.println("Busque o erro"+e.getLocalizedMessage());
			
		}
		
		genDAO.delGenero(gen);
	}

	//Listando todos generos
	public static void listaTodos() {
		GeneroDAO genDAO = null;
		
		try {
			genDAO = new GeneroDAO();
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Busque o erro"+e.getLocalizedMessage());			
		}
		List<Genero> resulDados = genDAO.generoVerTodos();
		System.out.println("TABELA DE GENERO");
		for(Genero g: resulDados) {
			System.out.println("ID: "+g.getGen_id()+"\n"+
							"Nome: "+g.getNome_genero()+"\n"+
							"Plataforma: "+g.getPlataforma());
		}
	}
}
