package exercicios.file;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio04 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o caminho de um recurso para deletar:");
        String path = teclado.nextLine();
        File file = new File(path);
        if (file.exists()) {
            System.out.println("Tem certeza que deseja deletar " + file.getAbsolutePath() + "? (y/n)");
            String resposta = teclado.nextLine();
            if ("y".equals(resposta)) {
                deletarConteudo(file);
            }
        } else {
            System.out.println("Nome inválido, o caminho específicado não existe!");
        }
    }

    private static void deletarConteudo(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    deletarConteudo(file1);
                }
            }
            file.delete();
        } else if (file.isFile()) {
            file.delete();
        }
    }
}
