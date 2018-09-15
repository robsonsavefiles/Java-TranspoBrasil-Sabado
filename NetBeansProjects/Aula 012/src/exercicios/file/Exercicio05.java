package exercicios.file;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio05 {

    private static final String INDICADOR_NIVEL = "\t";

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o caminho de um diretório:");
        String path = teclado.nextLine();
        File file = new File(path);
        if (file.exists()) {
            listarConteudo(file, "");
        } else {
            System.out.println("Nome inválido, o caminho específicado não existe!");
        }
    }

    private static void listarConteudo(File file, String preComplemento) {
        System.out.printf(preComplemento);
//        System.out.printf(">");
        if (file.isDirectory()) {
            System.out.println("DIR " + file.getName());
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    listarConteudo(file1, preComplemento + INDICADOR_NIVEL);
                }
            }
        } else if (file.isFile()) {
            System.out.println("FILE " + file.getName());
        }
    }
}
