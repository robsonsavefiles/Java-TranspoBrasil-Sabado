/*
 3)Crie um programa que solicite ao usuario o nome de um arquivo e em seguida apresente as informaçoes abaixo:
 a)nome completo do arquivo;
 b)tamanho do arquivo;
 c)extensão do arquivo;
 d)Pasta onde o arquivo foi criado(parent) caso o arquivo nao exista ou seja invalido apresenta uma mensagem para o usuario

 */
package br.com.proway.arquivos;

import java.io.File;
import java.util.Scanner;

public class Exer3_Arquivos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        File arquivo = new File("pasta");

        System.out.println("Informe o Nome do arquivo:");
        String rec = teclado.nextLine();

        File file = new File(rec);

        if (file.isFile()) {
            System.out.println(file.getParentFile());
            System.out.println(file.length());
            String ext = rec.substring(rec.lastIndexOf('.') + 1);
    
            System.out.println("A extensao do arquivo e: " + ext);


        }
        

    }
}
