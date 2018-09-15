package parte2.exercicio03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantidade de Threads a serem criadas:");
        int qtd = Integer.parseInt(scanner.nextLine());
        List<MyThread> lista = new ArrayList();
        for (int i = 0; i < qtd; i++) {
            System.out.println("Nome da thread " + (i + 1) + ":");
            String nome = scanner.nextLine();
            System.out.println("Valor máximo da thread " + (i + 1) + ":");
            int valor = Integer.parseInt(scanner.nextLine());
            lista.add(new MyThread(nome, valor));
        }
        System.out.println("Executando...");
        lista.stream().forEach((thread) -> thread.start());
    }
}
