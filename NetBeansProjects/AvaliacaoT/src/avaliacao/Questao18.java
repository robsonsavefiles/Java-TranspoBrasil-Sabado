package avaliacao;

import java.io.File;
import java.util.Scanner;

/**
 * Escreva um programa que solicite o nome de um recurso e em seguida escreva se o recurso existe, se é um arquivo ou se é uma pasta.
 *
 * @author 78522
 */
public class Questao18 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o caminho de um recurso:");
        String path = teclado.nextLine();
        verificarFile(new File(path));
    }

    private static void verificarFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                System.out.println(file.getName() + " existe e é um arquivo.");
            } else if (file.isDirectory()) {
                System.out.println(file.getName() + " existe e é uma pasta.");
            }
        } else {
            System.out.println(file.getName() + " não existe");
        }
    }
}
