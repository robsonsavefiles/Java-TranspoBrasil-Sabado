package comparacoeslogicas;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ExercicioWhile {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numero = 0;
        while (numero != 10) {
            System.out.println("Informe o número 10:");
            numero = Integer.parseInt(teclado.nextLine());
        }
    }
}
