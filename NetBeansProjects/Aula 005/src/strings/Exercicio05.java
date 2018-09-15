package strings;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio05 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Informe uma palavra:");
            System.out.println(teclado.nextLine().replaceAll("[aeiouAEIOU]", ""));
        }
    }
}
