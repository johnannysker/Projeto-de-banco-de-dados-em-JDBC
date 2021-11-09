package br.com.gamesonline.aplicacao;

import javax.swing.JOptionPane;


public class Main {
	public static void main(String[] args) {
		
		
		
		while(true) {
			System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
			System.out.println("VOCÊ ESTA NO BANCO DE DADOS DO"+"\n"
											+" SHOPGAMES HARRIOT");
			System.out.println("------------------------------");
			System.out.println("O QUE DESEJA FAZER: ");
			System.out.println();
			System.out.println("1  - ADICIONAR GENERO");
			System.out.println("2  - ADICIONAR GAME");
			System.out.println("3  - ADICIONAR VENDA");
			System.out.println("4  - ATUALIZAR GENERO");
			System.out.println("5  - ATUALIZAR GAME");
			System.out.println("6  - VISUALIZAR GENEROS");
			System.out.println("7  - VISUALIZAR GAMES");
			System.out.println("8  - VISUALIZAR VENDAS");
			System.out.println("9  - DELETAR GENERO");
			System.out.println("10 - DELETAR GAME");
			System.out.println("11 - DELETAR VENDA");
			System.out.println("0  - SAIR DO BANCO DE DADOS");
			System.out.println("-------------------------------");
			
			String oopcao = JOptionPane.showInputDialog("Digite sua opção");
			int opcao = Integer.parseInt(oopcao);
			
			if(opcao == 0) {
				break;
			}else {
				
				switch (opcao) {
				case 1:
					GeneroMetodos.addGenero();
					break;
				case 2:
					GameMetodos.addGame();
					break;
				case 3:
					VendaMetodos.addVenda();
					break;
				case 4:
					while(true) {
						
						System.out.println("O QUE DESEJA FAZER: ");
						System.out.println();
						System.out.println("41  - ALTERAR O NOME DO GENERO");
						System.out.println("42  - ALTERAR A NOME DA PLATAFORMA");
						System.out.println("40  - SAIR");
						String tp = JOptionPane.showInputDialog("Escolha o que deseja alterar");
						int tip = Integer.parseInt(tp);
						if(tip == 40) {
							break;
							
						}else {
							
							switch (tip) {
							case 41:
								GeneroMetodos.alteraGeneroNome();
								break;
							case 42:
								GeneroMetodos.alteraGeneroPlataforma();
								break;							
							default:
								System.out.println("Digite uma opção válida!");
								break;
							}
						}
					}
					break;
				case 5:
					GameMetodos.alteraPrecoGame();
					break;
				case 6:
					GeneroMetodos.listaTodos();
					break;
				case 7:
					GameMetodos.listaTodosJogos();
					break;
				case 8:
					VendaMetodos.listaTodasVendas();
					break;
				case 9:
					GeneroMetodos.excluiGenero();
					break;
				case 10:
					GameMetodos.excluiGame();
					break;
				case 11:
					VendaMetodos.excluiVenda();
					break;
				default:
					System.out.println("DIGITE UMA OPÇÃO VÁLIDA!");
					break;
				
				}
			}
		}
		
		System.out.println("BASE DE DADOS FECHADA PELO USUÁRIO!");
		
	}

	

}
