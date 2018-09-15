package exemplos.file;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("ARQUIVO");
        File file = new File("teste.txt");
        try {
            System.out.println("Existe? " + file.exists());
            System.out.println("Criou? " + file.createNewFile());
            System.out.println("Nome: " + file.getName());
            System.out.println("Caminho: " + file.getAbsolutePath());
            //System.out.println("Deletou? " + file.delete());
            //System.out.println("Existe? " + file.exists());
        } catch (IOException ex) {
            System.out.println("Não foi possível criar o arquivo.");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("\nPASTA");
        File dir = new File("pasta");
        System.out.println("Existe? " + dir.exists());
        System.out.println("Criou? " + dir.mkdir());
        System.out.println("Nome: " + dir.getName());
        System.out.println("Caminho: " + dir.getAbsolutePath());
        //System.out.println("Deletou? " + dir.delete());
        //System.out.println("Existe? " + dir.exists());

        System.out.println("\nVERIFICAÇÃO");
        verificarTipoFile(file);
        verificarTipoFile(dir);
    }

    private static void verificarTipoFile(File file) {
        if (file.isFile()) {
            System.out.println(file.getName() + " é um arquivo.");
        } else if (file.isDirectory()) {
            System.out.println(file.getName() + " é uma pasta.");
        }
    }
}
