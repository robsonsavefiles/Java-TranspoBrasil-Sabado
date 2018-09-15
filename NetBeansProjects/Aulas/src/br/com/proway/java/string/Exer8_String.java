//8)Escreva um programa que leia  100 valores inteiros e armazene-os em um vetor, em seguida escreva qual é o menor número,
//qual é o maior número, qual é a média dos números, qual a posição do menor número, qual a posição do maior número.
package br.com.proway.java.string;

import br.com.proway.java.*;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer8_String {

    public static void main(String[] args) {

        int menorN = 0;
        int maiorN = 0;
        int maiorInd = 0;
        int menorInd = 0;
        double media = 0;

        int[] numeros = new int[10];

        for (int i = 0; i < numeros.length; i = i + 1) {

            Scanner teclado = new Scanner(System.in);
            System.out.print("Informe os Numeros: ");
            numeros[i] = Integer.parseInt(teclado.nextLine());

            menorN = numeros[0];

            if (numeros[i] < menorN) {
                menorN = numeros[i];
                menorInd = i;
            }
            if (numeros[i] > maiorN) {
                maiorN = numeros[i];
                maiorInd = i;
            }

            media = media + numeros[i];

        }

        System.out.println("A Media dos numeros é " + media / numeros.length);
        System.out.println("Menor Numero" + menorN);
        System.out.println("Maior Numero" + maiorN);
        System.out.println("A posicao do Maior Numero" + maiorInd);
        System.out.println("A posicao do Menor Numero" + menorInd);

    }

}
