//2)Crie um programa que solicite ao usuario seu nome em seguida imprima o nome informado ao contrario;
package br.com.proway.java;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer2_String {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe seu Nome:");
        String nome = teclado.nextLine();

        for (int i = nome.length() - 1; i >= 0; i--) {
            System.out.print(nome.charAt(i));
        }
        System.out.println("\n");

    }

}
