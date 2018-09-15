package aula006;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ArrayLists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        String atual;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Escolha uma opção: 1 - Adicionar nomes, 2 - Listar nomes, 3 - Editar nomes, 4 - Remover nomes, 5 - Sair");
            atual = teclado.nextLine();
            switch (atual) {
                case "1":
                    adicionar(teclado, nomes);
                    break;
                case "2":
                    listar(teclado, nomes);
                    break;
                case "3":
                    editar(teclado, nomes);
                    break;
                case "4":
                    remover(teclado, nomes);
                    break;
                default:
                    break;
            }
        } while (!"5".equalsIgnoreCase(atual));
    }

    public static void adicionar(Scanner teclado, ArrayList<String> nomes) {
        String texto;
        System.out.println("\nADICIONAR");
        do {
            System.out.println("Digite um nome ou \"S\" para voltar ao menu principal:");
            texto = teclado.nextLine();
            if (!"S".equalsIgnoreCase(texto)) {
                nomes.add(texto);
                System.out.println(texto + " adicionado.");
                System.out.println();
            }
        } while (!"S".equalsIgnoreCase(texto));

    }

    private static void listar(Scanner teclado, ArrayList<String> nomes) {
        String texto;
        System.out.println("\nLISTAR ");
        do {
            if (nomes.isEmpty()) {
                System.out.println("Não há nomes cadastrados!");
            } else {
                for (int i = 0; i < nomes.size(); i++) {
                    System.out.println(i + " - " + nomes.get(i));
                }
            }
            System.out.println();
            System.out.println("Digite \"N\" para listar novamente ou qualquer outra tecla para sair:");
            texto = teclado.nextLine();
        } while ("N".equalsIgnoreCase(texto));
    }

    private static void remover(Scanner teclado, ArrayList<String> nomes) {
        String texto;
        System.out.println("\nREMOVER ");
        do {
            System.out.println("Digite o índice a ser removido ou \"S\" para sair:");
            texto = teclado.nextLine();
            if (!"S".equalsIgnoreCase(texto)) {
                int id = Integer.parseInt(texto);
                if (id >= 0 && id < nomes.size()) {
                    String nome = nomes.get(id);
                    nomes.remove(id);
                    System.out.println(nome + " removido com sucesso.");
                } else {
                    System.out.println("Índice inválido!");
                }
                System.out.println();
            }
        } while (!"S".equalsIgnoreCase(texto));
    }

    private static void editar(Scanner teclado, ArrayList<String> nomes) {
        String texto;
        System.out.println("\nEDITAR ");
        do {
            System.out.println("Digite o índice a ser editado ou \"S\" para sair:");
            texto = teclado.nextLine();
            if (!"S".equalsIgnoreCase(texto)) {
                int id = Integer.parseInt(texto);
                if (id >= 0 && id < nomes.size()) {
                    String nome = nomes.get(id);
                    System.out.println("Informe o novo nome para " + nome + ": ");
                    nomes.set(id, teclado.nextLine());
                    System.out.println(nome + " editado para " + nomes.get(id) + " com sucesso.");
                } else {
                    System.out.println("Índice inválido!");
                }
                System.out.println();
            }
        } while (!"S".equalsIgnoreCase(texto));
    }
}
