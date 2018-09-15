package strings;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio06 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Informe uma palavra:");
            String vogais = "aeiouAEIOU";
            String palavra = teclado.nextLine();
            int qtd = 0;

            for (int i = 0; i < palavra.length(); i++) {
                if (vogais.contains(String.valueOf(palavra.charAt(i)))) {
                    qtd++;
                }
            }

            System.out.println("Quantidade de vogais = " + qtd);
        }
    }
}
