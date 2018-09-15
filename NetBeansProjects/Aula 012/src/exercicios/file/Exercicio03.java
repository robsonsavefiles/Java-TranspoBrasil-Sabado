package exercicios.file;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio03 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o caminho de um arquivo:");
        String path = teclado.nextLine();
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("Nome do Arquivo: " + file.getName());
                System.out.println("Tamanho do Arquivo: " + file.length());
                System.out.println("Extens�o do Arquivo: " + file.getName().substring(file.getName().lastIndexOf('.')));
                System.out.println("Parente do Arquivo: " + file.getParent());
            } else if (file.isDirectory()) {
                System.out.println("� um diret�rio.");
            }
        } else {
            System.out.println("N�o existe.");
        }
    }
}
