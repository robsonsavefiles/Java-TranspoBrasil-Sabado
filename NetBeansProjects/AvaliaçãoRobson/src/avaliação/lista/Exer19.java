/*
 * 19)escreva um programa que solicite  10 notas de uma turma, em seguida escreva as notas digitadas, a média das notas,
 a menor nota e a maior nota.(Utilize Array)
 */
package avaliação.lista;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer19 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        double[] notas = new double[10];
        double soma = 0;
        int menorNotaPos = 0;
        int maiorNotaPos = 0;

        System.out.println("Forneça " + notas.length + " notas");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Nota " + (i + 1) + ":");
            try {
                notas[i] = Double.parseDouble(teclado.nextLine());
                if (notas[i] < 0 || notas[i] > 10) {
                    throw new IllegalArgumentException();
                }
                soma += notas[i];
                if (notas[i] < notas[menorNotaPos]) {
                    menorNotaPos = i;
                }
                if (notas[i] > notas[maiorNotaPos]) {
                    maiorNotaPos = i;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Nota inválida.");
                i--;
            }
        }
        System.out.println("===================================================");
        System.out.println("Notas Informadas: ");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);
            if (i != notas.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("");
        System.out.println("===================================================");
        System.out.println("Média das Notas: " + (soma / notas.length));
        System.out.println("Maior nota: " + notas[maiorNotaPos]);
        System.out.println("Menor nota: " + notas[menorNotaPos]);
        System.out.println("===================================================");
    }
}
