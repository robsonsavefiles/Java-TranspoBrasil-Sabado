//1)Crie um programa que solicite ao usuario seu nome e em seguida  informe a quantidade de caracteres
//do nome informado.
package br.com.proway.java;

import java.util.Scanner;

public class Exer1_String {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe seu Nome:");
        String nome = teclado.nextLine();

        System.out.println("Total de Caracteres"+nome.length());

        teclado.close();
    }

}
