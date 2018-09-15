package exercicios.file;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio01 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o caminho de um recurso:");
        String path = teclado.nextLine();
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("� um arquivo.");
            } else if (file.isDirectory()) {
                System.out.println("� um diret�rio.");
            }
        } else {
            System.out.println("N�o existe.");
        }
    }
}
