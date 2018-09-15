package strings;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio02 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Informe seu nome:");
            String nome = teclado.nextLine();
            String nomeInverso = "";

            for (int i = nome.length() - 1; i >= 0; i--) {
                nomeInverso += nome.charAt(i);
            }

            System.out.println(nomeInverso);
        }
    }
}
