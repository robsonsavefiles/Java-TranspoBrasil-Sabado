//5)crie um programa que solicite uma palavra ao usuario e escreva a palavra informda sem as vogais;
package br.com.proway.java.string;

import br.com.proway.java.*;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer5_String {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite uma palavra :");
        String nome = teclado.nextLine();

        nome = nome.replace("a", "");
        nome = nome.replace("A", "");
        nome = nome.replace("e", "");
        nome = nome.replace("E", "");
        nome = nome.replace("i", "");
        nome = nome.replace("I", "");
        nome = nome.replace("o", "");
        nome = nome.replace("O", "");
        nome = nome.replace("u", "");
        nome = nome.replace("U", "");

        System.out.println(nome);

        teclado.close();

    }

}
