package comparacoeslogicas;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ExercicioFor3 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num1;
        int num2;

        System.out.println("Informe o menor número:");
        num1 = Integer.parseInt(teclado.nextLine());
        num2 = num1;

        while (num2 <= num1) {
            System.out.println("Informe o maior número:");
            num2 = Integer.parseInt(teclado.nextLine());
        }

        System.out.println("\nNúmeros pares entre eles:");

        for (int i = num1; i <= num2; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
