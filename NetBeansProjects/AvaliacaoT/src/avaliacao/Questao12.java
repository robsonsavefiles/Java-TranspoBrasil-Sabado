package avaliacao;


import java.util.Scanner;

/**
 * Fazer um programa que mostre um menu conforme abaixo até que o usuário escolha a opção sair.
 * "1 - sacar" "2 - depositar" "3 - saldo" "4 - transferir" "5 -
 * sair"
 *
 * @author 78522
 */
public class Questao12 {

    private final static String OPCAO_SACAR = "1";
    private final static String OPCAO_DEPOSITAR = "2";
    private final static String OPCAO_SALDO = "3";
    private final static String OPCAO_TRANSFERIR = "4";
    private final static String OPCAO_SAIR = "5";

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            String opcao = "";
            do {
                if (!opcao.isEmpty()) {
                    System.out.println();
                }
                System.out.println("MENU PRINCIPAL");
                System.out.println(OPCAO_SACAR + " - Sacar");
                System.out.println(OPCAO_DEPOSITAR + " - Depositar");
                System.out.println(OPCAO_SALDO + " - Saldo");
                System.out.println(OPCAO_TRANSFERIR + " - Transferir");
                System.out.println(OPCAO_SAIR + " - Sair");
                opcao = teclado.nextLine();
            } while (!OPCAO_SAIR.equalsIgnoreCase(opcao));
        }
    }
}
