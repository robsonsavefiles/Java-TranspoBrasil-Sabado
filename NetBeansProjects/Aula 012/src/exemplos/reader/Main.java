package exemplos.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Informe o nome do arquivo: ");
            String nome = teclado.nextLine();
            leitorHard(nome);
        }
    }

    public static void leitorEasy(String nomeArquivo) {
        try (Scanner leitor = new Scanner(new File(nomeArquivo))) {
            while (leitor.hasNextLine()) {
                System.out.println(leitor.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        }
    }

    public static void leitor(String nomeArquivo) {
        try (FileReader fr = new FileReader(new File(nomeArquivo));
                BufferedReader br = new BufferedReader(fr);) {
            String linha = br.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Falha ao ler arquivo!");
        }
    }

    public static void leitorHard(String nomeArquivo) {
        try (FileReader fr = new FileReader(new File(nomeArquivo))) {
            char[] buffer = new char[1024];
            int pos;
            while ((pos = fr.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, pos));
            }
        } catch (IOException ex) {
            System.out.println("Falha ao ler arquivo!");
        }
    }
}
