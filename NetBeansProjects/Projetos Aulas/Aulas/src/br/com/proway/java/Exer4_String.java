//4)Crie um programa  que solicite uma palavra ao usuario  e altere todas as letras 'a' por 'o'.
package br.com.proway.java;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer4_String {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite uma palavra com a ou e :");
        String nome = teclado.nextLine();

        // substitui todas as ocorrências de "a" por "e"
        String frase2 = nome.replace('a', 'e');

        System.out.println(frase2);

        System.exit(0);
    }
}
