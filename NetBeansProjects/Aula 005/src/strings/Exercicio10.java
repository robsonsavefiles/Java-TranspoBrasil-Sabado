package strings;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio10 {

    private static final int IDX_NOME = 0;
    private static final int IDX_RUA = 1;
    private static final int IDX_NUMERO = 2;
    private static final int IDX_BAIRRO = 3;
    private static final int IDX_CIDADE = 4;

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            String[][] matriz = new String[2][5];

            System.out.println("Forneça o nome e endereço de " + matriz.length + " pessoas.");
            for (int i = 0; i < matriz.length; i++) {
                System.out.println("Nome da pessoa " + (i + 1) + ":");
                matriz[i][IDX_NOME] = teclado.nextLine();

                System.out.println("Rua de " + matriz[i][IDX_NOME] + ":");
                matriz[i][IDX_RUA] = teclado.nextLine();

                System.out.println("Número de " + matriz[i][IDX_NOME] + ":");
                matriz[i][IDX_NUMERO] = teclado.nextLine();

                System.out.println("Bairro de " + matriz[i][IDX_NOME] + ":");
                matriz[i][IDX_BAIRRO] = teclado.nextLine();

                System.out.println("Cidade de " + matriz[i][IDX_NOME] + ":");
                matriz[i][IDX_CIDADE] = teclado.nextLine();
            }

            System.out.println();
            System.out.println("Lista de endereços: ");

            for (String[] matriz1 : matriz) {
                System.out.printf("%nNome: %s. Endereço: Rua %s, %s. Bairro %s, %s.%n", matriz1[IDX_NOME], matriz1[IDX_RUA],
                        matriz1[IDX_NUMERO], matriz1[IDX_BAIRRO], matriz1[IDX_CIDADE]);
            }
        }
    }
}
