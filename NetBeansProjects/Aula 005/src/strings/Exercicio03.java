package strings;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio03 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Informe uma palavra:");
            String palavra = teclado.nextLine();
            String palavraInverso = "";

            for (int i = palavra.length() - 1; i >= 0; i--) {
                palavraInverso += palavra.charAt(i);
            }

            System.out.println(palavra.equalsIgnoreCase(palavraInverso) ? "É um palíndromo" : "Não é um palíndromo");
        }
    }
}
