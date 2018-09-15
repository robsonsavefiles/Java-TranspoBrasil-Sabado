package comparacoeslogicas;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ExercicioConta {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String input;
        w:
        while (true) {
            System.out.println("Escolha uma opção: 1 - Sacar, 2 - Depositar, 3 - Verificar Saldo, 4 - Sair.");
            input = teclado.nextLine(); 
            switch (input) {
                case "1":
                    System.out.println("Opção escolhida: Sacar.");
                    break;
                case "2":
                    System.out.println("Opção escolhida: Depositar.");
                    break;
                case "3":
                    System.out.println("Opção escolhida: Verificar Saldo.");
                    break;
                case "4":
                    System.out.println("Opção escolhida: Sair.");
                    break w;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        System.out.println("Programa encerrado.");
    }
}
