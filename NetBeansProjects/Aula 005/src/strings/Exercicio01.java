package strings;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio01 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Informe seu nome:");
            System.out.println("Tamanho: " + teclado.nextLine().length());
        }
    }
}
