package roupasDeMargarida;

import java.util.Scanner;



public class Menu {

	private static final Scanner leia = new Scanner(System.in);
		
	public static void main(String[] args) {

			byte opcao;

			while (true) {

				System.out.println("*****************************************************");
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

				opcao = leia.nextByte();
				leia.nextLine();

				if (opcao == 0) {
					System.out.println("\nObrigada por colaborar conosco :D");
					sobre();
	                leia.close();
					System.exit(0);
				}

				switch (opcao) {
					case 1:
						System.out.println("Cadastrar produto\n\n");
						keyPress();
						break;
					case 2:
						System.out.println("Listar produtos cadastrados\n\n");
						keyPress();
						break;
					case 3:
						System.out.println("Atualizar dados produto\n\n");
						keyPress();
						break;
					case 4:
						System.out.println("Excluir produto do sistema\n\n");
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
}

