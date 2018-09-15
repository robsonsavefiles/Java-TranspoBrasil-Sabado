//Escreva um programa que leia uma palavra e escreva a quantidade de vogais que a palavra possui.
package br.com.proway.java;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer6_String {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite uma palavra :");
        String nome = teclado.nextLine();
        String qtde_string;

        for (int cont = 0; cont < nome.length(); cont++) {
            int quant = 0;
            if (nome.charAt(cont) == 'a' || nome.charAt(cont) == 'e' || nome.charAt(cont) == 'i'
                    || nome.charAt(cont) == 'o' || nome.charAt(cont) == 'u' || nome.charAt(cont) == 'A'
                    || nome.charAt(cont) == 'E' || nome.charAt(cont) == 'I' || nome.charAt(cont) == 'O'
                    || nome.charAt(cont) == 'U') {
                quant++;
            }
            System.out.println(quant);
        }

    }

}
