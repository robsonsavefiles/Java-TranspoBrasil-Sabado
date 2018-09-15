package exercicios.writer;

import java.io.File;
import java.io.FileNotFoundException;
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
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Informe o nome do usuário:");
            String nome = teclado.nextLine();
            System.out.println("Informe a idade do usuário:");
            String idade = teclado.nextLine();
            System.out.println("Informe o email do usuário:");
            String email = teclado.nextLine();
            System.out.println("Informe o telefone do usuário:");
            String telefone = teclado.nextLine();
            
            gravarArquivo(new File(nome + ".txt"), "Idade: " + idade, "Email: " + email, "Telefone: " + telefone);
        }
    }

    public static void gravarArquivo(File file, String... linhas) {
        try {
            PrintWriter pw = new PrintWriter(file);
            for (String linha : linhas) {
                pw.println(linha);
            }
            pw.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao criar arquivo");
            Logger.getLogger(Exercicio01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
