package comparacoeslogicas;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe sua idade:");
        int idade = Integer.parseInt(teclado.nextLine());
        if (idade >= 16) {
            System.out.println("Você já pode votar.");
        } else {
            System.out.println("Você não tem idade o suficiente para votar.");
        }
    }
}
