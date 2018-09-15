package comparacoeslogicas;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe sua idade:");
        int idade = Integer.parseInt(teclado.nextLine());
        if (idade >= 18) {
            System.out.println("Você pode fazer a CNH.");
        }
    }
}
