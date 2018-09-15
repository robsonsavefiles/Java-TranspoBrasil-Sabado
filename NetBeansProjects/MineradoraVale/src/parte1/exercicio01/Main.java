package parte1.exercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        // Scanner teclado = new
        int numero = 20;
        Scanner scanner = new Scanner(System.in);
        List<Thread> lista = new ArrayList();

        lista.add(new Thread01(10));
        lista.add(new Thread02(10));
        lista.add(new Thread03(21, 34));
        lista.add(new Thread04(233, 144));
        lista.add(new Thread05(10));
        lista.add(new Thread06(10));
        lista.add(new Thread07(6));

        System.out.println("1 - 10 primeiros múltiplos");
        System.out.println("2 - 10 primeiros pares");
        System.out.println("3 - Sequencia de Fibonacci");
        System.out.println("4 - Sequencia de Fibonacci invertida");
        System.out.println("5 - 10 primeiros valores");
        System.out.println("6 - 10 valores anteriores");
        System.out.println("7 - O fatorial de um número");

        while (true) {
            String opcao = scanner.nextLine();
            lista.get(Integer.parseInt(opcao)).start();
        }

    }
}
