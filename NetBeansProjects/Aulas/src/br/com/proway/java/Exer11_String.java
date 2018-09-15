/*Escreva um programa que leia o nome dos alunos e a nota de uma turma de 50 alunos e em seguida calcule a média da turma. 
 Escreva qual foi a média e o nome dos alunos que tiveram nota maior ou igual a médiaa
 */
package br.com.proway.java;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer11_String {

    public static void main(String[] args) {

        int contador = 0;
        // declaração do vetor ‘notas’ capaz de armazenar valores do tipo double
        double[] notas;
        // alocação de memória para o vetor ‘notas’: pode armazenar até 10 double
        notas = new double[10];
        double soma = 0;
        while (contador < 10) {
            System.out.println("Entre com a nota: ");
           //+(contador+1)
            // uso de um elemento do vetor ‘notas’ cuja posição é ‘contador’
            notas[contador] = new Scanner(System.in).nextDouble();
            soma = soma + notas[contador];
            contador = contador + 1;
        }
        double media = soma / contador;
        contador = 0;
        System.out.println("Notas maiores do que a média " + media);
        while (contador < 10) {
            if (notas[contador] >= media) {
                System.out.println(notas[contador]);
            }
            contador = contador + 1;
        }
    }
}
