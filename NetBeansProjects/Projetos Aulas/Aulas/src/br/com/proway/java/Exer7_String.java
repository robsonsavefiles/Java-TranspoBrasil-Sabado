//7)Escreva um programa que leia uma palavra e escreva a quantidade de consoantes da palavra.
package br.com.proway.java;

import java.util.Scanner;

public class Exer7_String {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite uma palavra :");
        String nome = teclado.nextLine();

        String vogais = "aeiou";
        String consoantes = "bcdfghjklmnpqrstvxwyz";
        int total_vogais = 0, total_consoantes = 0;

        System.out.println("Digite uma palavra :");
        String texto = teclado.nextLine();

        int NumeroLetras = texto.length();
        for (int i = 0; i < NumeroLetras; i++) {
            if (vogais.indexOf(texto) >= 0) {
                total_vogais++;
            } else if (consoantes.indexOf(texto) >= 0) {
                total_consoantes++;
            }

        }

    }
}
