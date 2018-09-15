package comparacoeslogicas;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class DoWhile {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String controle = "";

        do {
            System.out.println("Digite um número:");
            controle = teclado.nextLine();
        } while (!controle.equals("10"));
        teclado.close();
    }
}
