/*
25) Escreva um progama que solicite o nome o telefone e o email de um usuário e em seguida 
grave estas informações em um arquivo que contenha como nome  a concatenação do nome do usuário 
juntamente com a data(dd-MM-yyyy) felipe_26-11-2015.txt
 */
package avaliação.lista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer25 {
    
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Informe o nome do usuário:");
            String nome = teclado.nextLine();
            System.out.println("Informe o telefone do usuário:");
            String telefone = teclado.nextLine();
            System.out.println("Informe o email do usuário:");
            String email = teclado.nextLine();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            File file = new File(nome.replace(" ", "_") + "_" + sdf.format(new Date()) + ".txt");
            gravarArquivo(file, nome, telefone, email);
        }
    }
    
    public static void gravarArquivo(File file, String... infos) {
        try {
            PrintWriter pw = new PrintWriter(file);
            for (String info : infos) {
                pw.println(info);
            }
            pw.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao criar arquivo");
        }
    }
}
