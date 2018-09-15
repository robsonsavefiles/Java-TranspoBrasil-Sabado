/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class ExemplosLerArquivos {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome do arquivo:");
        String nome = teclado.nextLine();

        leitorModoEasy(nome);
        teclado.close();

    }

    public static void leitorModoEasy(String nomeArquivo) {

        try (Scanner leitor = new Scanner(new File(nomeArquivo))) {
            while (leitor.hasNextLine()) {//verifica se tem uma linha
                System.out.println(leitor.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado");
        }

    }

    public static void leitorModoHard(String nomeArquivo) {
        final File file = new File(nomeArquivo);
        try (FileReader reader = new FileReader(file)) {

            char[] buffer = new char[1024];
            int pos = -1;
            while ((pos = reader.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, pos));
            }

        } catch (IOException ex) {
            System.out.println("Falha ao ler o arquivo ");
        }
    }
}
