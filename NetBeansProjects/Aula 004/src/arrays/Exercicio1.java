package arrays;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double[] notas = new double[10];
        double soma = 0;

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Informe a nota do aluno " + (i + 1));
            notas[i] = Double.parseDouble(teclado.nextLine());
            soma += notas[i];
        }

        System.out.println("Média da turma = " + soma / notas.length);

        teclado.close();
    }
}
