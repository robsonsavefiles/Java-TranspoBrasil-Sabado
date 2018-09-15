package exercicios.file;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio02 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o caminho de um diretório:");
        String path = teclado.nextLine();
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    System.out.println("Arquivos e diretórios contidos:");
                    for (File file1 : files) {
                        System.out.println((file1.isDirectory() ? "Diretório" : "Arquivo") + " - " + file1.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("Nome inválido, o caminho específicado não pertence a um diretório!");
            }
        } else {
            System.out.println("Nome inválido, o caminho específicado não existe!");
        }
    }
}
