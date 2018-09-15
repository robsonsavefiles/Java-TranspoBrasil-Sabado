package comparacoeslogicas;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ExercicioWhile2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String input = "";
        while (!input.equals("10") && !input.toLowerCase().equals("sair")) {
            System.out.println("Informe o número 10 ou \"Sair\" para sair:");
            input = teclado.nextLine();
        }
    }
}
