package exercicios.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class Exercicio01 {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome de um arquivo:");
        String arquivo = teclado.nextLine();
        System.out.println("Informe o nome de um diretório:");
        String diretorio = teclado.nextLine();
        File dir = new File(diretorio);
        System.out.println(dir.getPath() + arquivo);
        File file2 = new File(dir.getPath() + arquivo);
        String conteudo = ler(arquivo);
        gravar(file2, conteudo);
    }
    
    public static String ler(String nomeArquivo) {
        String retorno = "";
        try (FileReader fr = new FileReader(new File(nomeArquivo))) {
            char[] buffer = new char[1024];
            int pos;
            while ((pos = fr.read(buffer)) != -1) {
                retorno += new String(buffer, 0, pos);
            }
        } catch (IOException ex) {
            System.out.println("Falha ao ler arquivo!");
        }
        return retorno;
    }
    
    public static void gravar(File file, String conteudo) {
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.print(conteudo);
            pw.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao criar arquivo");
            Logger.getLogger(exercicios.writer.Exercicio01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
