package comparacoeslogicas;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ExercicioFor4 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe um número para o fatorial.");
        int fatorial = Integer.parseInt(teclado.nextLine());
        long soma = fatorial;
        for (int i = fatorial - 1; i > 0; i--) {
            soma *= i;
        }
        System.out.println(soma);
        teclado.close();
    }
}
