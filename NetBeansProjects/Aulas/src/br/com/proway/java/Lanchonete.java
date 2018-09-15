package br.com.proway.java;

import java.util.Scanner;

public class Lanchonete {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int qtde = 0, tipo = 0, refri = 0;

        Scanner teclado = new Scanner(System.in);

        System.out.print("\n\tLANCHONETE MCRONALDS \t\n");

        System.out.print("\nEspecificacao \t	Codigo  Preco\n");
        System.out.print("\nCachorro quente \t 100     1.20\n");
        System.out.print("Bauru simples 	    \t 101     1.30\n");
        System.out.print("Bauru com ovo 	   \t 102     1.50\n");
        System.out.print("Hamburger 	    \t 103     1.20\n");
        System.out.print("Cheeseburguer 	 \t 104     1.30\n");
        System.out.print("Refrigerante 	  \t 105     ---\n\n");

        System.out.print("Digite a quantidade de pedidos:");
        int qtde_pedido = Integer.parseInt(teclado.nextLine());

        for (int i = 1; i <= qtde_pedido; i = i++) {

            System.out.print("\n\nDigite o Codigo do produto: ");
            int codigo1 = Integer.parseInt(teclado.nextLine());

            switch (codigo1) {

                case 100:
                    System.out.printf("#####CACHORRO QUENTE#####");
                    System.out.println("Informe a quantidade:");
                    qtde = Integer.parseInt(teclado.nextLine());

                    System.out.printf("\n%d CACHORRO QUENTE = %.2f", qtde, (qtde * 1.20));
                    break;

                case 101:
                    System.out.println("#####BAURU SIMPLES#####");
                    System.out.println("Informe a quantidade:");
                    qtde = Integer.parseInt(teclado.nextLine());

                    System.out.printf("\n%d BAURU SIMPLES = %.2f", qtde, (qtde * 1.30));
                    break;

                case 102:

                    System.out.printf("#####BAURU COM OVO#####");
                    System.out.printf("Informe a quantidade:");
                    qtde = Integer.parseInt(teclado.nextLine());

                    System.out.printf("\n%d BAURU COM OVO = %.2f", qtde, (qtde * 1.50));

                    break;

                case 103:

                    System.out.printf("#####HAMBURGUER#####");
                    System.out.printf("Informe a quantidade:");
                    qtde = Integer.parseInt(teclado.nextLine());

                    System.out.printf("\n%d HAMBURGUER= %.2f", qtde, (qtde * 1.20));
                    break;

                case 104:

                    System.out.printf("#####CHESEBURGUE#####");
                    System.out.printf("Informe a quantidade:");
                    qtde = Integer.parseInt(teclado.nextLine());

                    System.out.printf("\n%d CHESEBURGUE = %.2f", qtde, (qtde * 1.30));
                    break;
                case 105:

                    System.out.println("#####REFRIGERANTE#####");
                    System.out.println("\n1 - Garrafa (2 litros)\n2 - Lata (350ml)\n");
                    System.out.print("Informe o tipo :");
                    tipo = Integer.parseInt(teclado.nextLine());

                    //System.out.printf("\n%d REFRIGERANTE = %.2f", qtde, (qtde *1.30));   
                    if (tipo == 1) {
                        System.out.printf("\n\t\t\t***** GARRAFAS *****\n");
                        System.out.printf("\n\tMarca\t\t\t\t Valor\n\n");
                        System.out.printf("1 - Coca-Cola (light/zero)\t\t 2.95\n");
                        System.out.printf("2 - Pepsi\t\t\t\t 2.60\n");
                        System.out.printf("3 - Fanta (Uva ou Laranja)\t\t 2.49\n");
                        System.out.printf("4 - Sprite\t\t\t\t 2.50\n");

                    } else if (tipo == 2) {
                        System.out.printf("\n\t\t\t***** LATAS *****\n");
                        System.out.printf("\n\tMarca\t\t\t\t Valor\n\n");
                        System.out.printf("1 - Coca-Cola (light/zero)\t\t 1.15\n");
                        System.out.printf("2 - Pepsi\t\t\t\t 0.95\n");
                        System.out.printf("3 - Fanta (Uva ou Laranja\t\t 0.89\n");
                        System.out.printf("4 - Sprite\t\t\t\t 1.05\n");

                    }
                    System.out.printf("\nEscolha a marca: ");
                    refri = Integer.parseInt(teclado.nextLine());

                    if (refri == 1 && tipo == 1) {
                        System.out.printf("\n\t\t\t***** COCA-COLA *****\n");
                        System.out.printf("\nDigite a quantidade: ");
                        int qtde_cocag = Integer.parseInt(teclado.nextLine());

                        System.out.printf("\n%d REFRIGERANTE(S) = %.2f\n", qtde, (qtde_cocag * 2.95));

                    } else {

                        if (refri == 2 && tipo == 1) {

                            System.out.printf("\n\t\t\t***** PEPSI *****\n");
                            System.out.printf("\nDigite a quantidade: ");
                            int qtde_pepsig = Integer.parseInt(teclado.nextLine());
                            System.out.printf("\n%d REFRIGERANTE(S) = %.2f", qtde, (qtde_pepsig * 2.60));
                        } else {
                            if (refri == 3 && tipo == 1) {
                                System.out.printf("\n\t\t\t***** FANTA (UVA OU LARANJA) *****\n");
                                System.out.printf("\nDigite a quantidade: ");
                                int qtde_fantag = Integer.parseInt(teclado.nextLine());

                                System.out.printf("\n%d REFRIGERANTE(S) = %.2f", qtde, (qtde_fantag * 2.49));

                            } else {
                                if (refri == 4 && tipo == 1) {

                                    System.out.printf("\n\t\t\t***** SPRITE *****\n");

                                    System.out.printf("\nDigite a quantidade: ");
                                    int qtde_spriteg = Integer.parseInt(teclado.nextLine());
                                    System.out.printf("\n%d REFRIGERANTE(S) = %.2f", qtde, (qtde_spriteg * 2.50));

                                } /* COMEÇO DO CÓDIGO DAS LATAS DE REFRIGERANTE*/ else {
                                    if (refri == 1 && tipo == 2) {
                                        System.out.printf("\n\t\t\t***** COCA-COLA *****\n");

                                        System.out.printf("\nDigite a quantidade: ");
                                        int qtde_cocal = Integer.parseInt(teclado.nextLine());
                                        System.out.printf("\n%d REFRIGERANTE(S) = %.2f", qtde, (qtde_cocal * 1.15));

                                    } else {
                                        if (refri == 2 && tipo == 2) {
                                            System.out.printf("\n\t\t\t***** Pepsi *****\n");

                                            System.out.printf("\nDigite a quantidade: ");
                                            int qtde_pepsil = Integer.parseInt(teclado.nextLine());

                                            System.out.printf("\n%d REFRIGERANTE(S) = %.2f", qtde, (qtde_pepsil * 0.95));

                                        } else {
                                            if (refri == 3 && tipo == 2) {
                                                System.out.printf("\n\t\t\t***** Fanta (Uva ou Laranja *****\n");

                                                System.out.printf("\nDigite a quantidade: ");
                                                int qtde_fantal = Integer.parseInt(teclado.nextLine());

                                                System.out.printf("\n%d REFRIGERANTE(S) = %.2f", qtde, (qtde_fantal * 0.89));

                                            } else {
                                                if (refri == 4 && tipo == 2) {
                                                    System.out.printf("\n\t\t\t***** Sprite *****\n");

                                                    System.out.printf("\nDigite a quantidade: ");
                                                    int qtde_spritel = Integer.parseInt(teclado.nextLine());

                                                    System.out.printf("\n%d REFRIGERANTE(S) = %.2f", qtde, (qtde_spritel * 1.05));
                                                }

                                                break;

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
            }

        }
    }
}
