package roupasDeMargarida;

import java.util.InputMismatchException;
import java.util.Scanner;

import roupasDeMargarida.controller.RoupasController;
import roupasDeMargarida.model.Roupas;
import roupasDeMargarida.model.Saia;



public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final RoupasController roupasController = new RoupasController();
		
	public static void main(String[] args) {

			byte opcao;


			while (true) {

				System.out.println("\n*****************************************************");
				System.out.println("                                                     ");
				System.out.println("                ROUPAS DE MARGARIDA                  ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("                                                     ");
				System.out.println("            1 - Cadastrar produto                    ");
				System.out.println("            2 - Listar produtos cadastrados          ");
				System.out.println("            3 - Atualizar dados produto              ");
				System.out.println("            4 - Excluir produto do sistema           ");
				System.out.println("            0 - Sair                                 ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("Entre com a opção desejada:                          ");
				System.out.println("                                                     ");

				try {
				opcao = leia.nextByte();
				leia.nextLine();
				}
				catch (InputMismatchException e) {
					opcao = -1;
					System.out.println("\nDigite um número inteiro!");
					leia.nextLine();
				}
				
				if (opcao == 0) {
					System.out.println("\nObrigada por colaborar conosco :D");
					sobre();
	                leia.close();
					System.exit(0);
				}

				switch (opcao) {
					case 1:
						System.out.println("Cadastrar produto\n\n");
						cadastrarProduto();
						keyPress();
						break;
					case 2:
						System.out.println("Listar produtos cadastrados\n\n");
						listarProdutos();
						keyPress();
						break;
					case 3:
						System.out.println("Atualizar dados de um produto\n\n");
						atualizarProduto();
						keyPress();
						break;
					case 4:
						System.out.println("Excluir produto do sistema\n\n");
						excluirProduto();
						keyPress();
						break;

					default:
						System.out.println("\nOpção Inválida!\n");
						keyPress();
						break;
			}
		}
			
}
	    
		public static void sobre() {
				System.out.println("\n*********************************************************");
				System.out.println("Projeto Desenvolvido por: Flame Souza");
				System.out.println("Generation Brasil - flames@genstudents.org");
				System.out.println("https://github.com/PraFlame/projeto_final_bloco_01");
				System.out.println("***********************************************************");
		}


//Adicionando o keypress
		public static void keyPress() {
			System.out.println("\nPressione Enter para Continuar...");
			leia.nextLine();
		}
// Adicionando funções apresentadas no menu
		private static void excluirProduto() {
			System.out.println("Digite o código do produto: ");
			int num = leia.nextInt();
			leia.nextLine();
			
			System.out.println("Tem certeza que deseja excluir este item? (S/N): ");
			String confirmacao = leia.nextLine();
			
			if(confirmacao.equalsIgnoreCase("S")) {
				roupasController.deletar(num);
			}
			else {
				System.out.println("Operação cancelada!!");
			}
			
			}
		private static void atualizarProduto() {
			System.out.println("Digite o código do produto a ser atualizado: ");
			int num = leia.nextInt();
			leia.nextLine();
			
			Roupas roupa = roupasController.buscarNaCollection(num);
			
			if(roupa != null) {
				
				byte numeracao = roupa.getNumeracao();
				String nome = roupa.getNome();
				float preco = roupa.getPreco();
				int quantidade = roupa.getQuantidade();
				String tipo = ((Saia) roupa).getTipo();
				
				System.out.println("O nome associado, no momento, é: " + nome + "\nNovo nome (Pressione ENTER para manter): ");
				String entrada = leia.nextLine();
				nome = entrada.isEmpty() ? nome : entrada;
				
				System.out.println("A numeração associada, no momento, é: " + numeracao + "\nNova numeração (Pressione ENTER para manter): ");
				entrada = leia.nextLine();
				numeracao = entrada.isEmpty() ? numeracao : Byte.parseByte(entrada);
						
				System.out.printf("O preço associado, no momento, é: %.2f\nNovo preço (Pressione ENTER para manter): ", preco);
				entrada = leia.nextLine();
				preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(',', '.'));
				
				System.out.println("A quantidade associada, no momento, é: " + quantidade + "\nNova quantidade (Pressione ENTER para manter): ");
				entrada = leia.nextLine();
				quantidade = entrada.isEmpty() ? quantidade : Integer.parseInt(entrada);
				
				System.out.println("O tipo associado, no momento, é: " + tipo + "\nNovo tipo (Pressione ENTER para manter): ");
				entrada = leia.nextLine();
				tipo = entrada.isEmpty() ? tipo : entrada;	
				
				
			}
			else {
				System.out.println("\nO produto de código " + num + " não foi encontrado!");
			}
		}
		
		private static void cadastrarProduto() {
			byte numeracao = 0;
			String nome = "";
			float preco = 0.0f;
			int quantidade = 0;
			String tipo = "";
			
			System.out.println("Digite o nome do produto: ");
			nome = leia.nextLine();
			
			System.out.println("Digite o preço do produto: ");
			leia.skip("\\R");
			String entrada = leia.nextLine();
			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(',', '.'));
			
			System.out.println("Digite a quantidade diponível no estoque: ");
			quantidade = leia.nextInt();
			
			System.out.println("O produto tem variações: (S/N):");
			String confirmacao = leia.nextLine();
			
			if(confirmacao.equalsIgnoreCase("S")) {
				System.out.println("Digite o tipo do produto:");
				tipo = leia.nextLine();
			}
			else {
				System.out.println("Ok!!");
			}
			if(tipo == "") {
				System.out.println("Produto ainda não suportado pelo sistema. Estamos trabalhando nisso.");
			}
			else {
				roupasController.cadastrar(new Saia(roupasController.gerarCodigo(), numeracao, nome, preco, quantidade, tipo));
			}
			
		}
		private static void listarProdutos() {
			roupasController.listarTodas();
		}
		
}

