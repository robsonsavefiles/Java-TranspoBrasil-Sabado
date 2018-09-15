/*Crie um programa que solicite o nome do usuario, sua idade, seu email e um telefone para contato
 * em seguida crie um arquivo com o nome do usuario e grave no arquivo as informaçoes passadas pelo
 * usuario, cada  informação deve estar em uma linha do arquivo. C
 */
package br.com.proway.arquivos;

import com.sun.javafx.print.PrintHelper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exe1_ArquivoWriter {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe o nome :");
        String nome = teclado.nextLine();

        System.out.println("Informe sua Idade:");
        String idade = teclado.nextLine();

        System.out.println("Informe seu Email:");
        String email = teclado.nextLine();

        System.out.println("Informe seu Telefone:");
        String telefone = teclado.nextLine();

        File dados = new File(nome + ".txt");

        try (PrintWriter gravador = new PrintWriter(dados)) {
            gravador.println(nome);
            gravador.println(idade);
            gravador.println(email);
            gravador.println(telefone);
            gravador.flush();
        } catch (IOException e) {
            System.out.println("Nao foi possivel gravar o arquivo");
        }
        teclado.close();
    }
}

// criaçao usando metodo 
// gravarUtilizandoFileWriter(dados,nome, idade,email,telefone);
//     private static void gravarUtilizandoFileWriter(File dados, String nome,String idade,String email, String telefone) {
//        boolean apendar = true;
//        FileWriter writer = null;
//        try (PrintWriter pWriter = new PrintWriter(new FileWriter(dados, true))) {
//            writer.write("\r\n");
//            pWriter.println(nome);
//            writer.write("\r\n");
//            pWriter.println(idade);
//            writer.write("\r\n");
//            pWriter.println(email);
//            writer.write("\r\n");
//            pWriter.println(telefone);
//            pWriter.flush();
//        } catch (IOException ex) {
//            System.out.println("FALHA AO GRAVAR O ARQUIVO");
//        }
//
//    }
//    
//}
////
