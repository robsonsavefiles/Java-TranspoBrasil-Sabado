package avaliacao;

import java.util.Scanner;

/**
 * Escreva um programa que solicite o nome e 5 notas de 10 alunos, em seguida escreva o nome de cada aluno, suas notas e a sua média.(Utilize Matriz)
 *
 * @author 78522
 */
public class Questao20 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            int qtdAlunos = 10;
            int qtdNotas = 5;
            String[] nomes = new String[qtdAlunos];
            double[][] notas = new double[qtdAlunos][qtdNotas];
            double[] mediaAluno = new double[notas.length];

            for (int i = 0; i < notas.length; i++) {
                System.out.println("Forneça o nome do aluno:");
                nomes[i] = teclado.nextLine();
                if (nomes[i].isEmpty()) {
                    i--;
                    continue;
                }

                System.out.println("Forneça as notas de " + nomes[i] + ".");
                for (int j = 0; j < notas[i].length; j++) {
                    System.out.println("Nota " + (j + 1) + ":");
                    try {
                        notas[i][j] = Double.parseDouble(teclado.nextLine());
                        if (notas[i][j] > 10 || notas[i][j] < 0) {
                            throw new IllegalArgumentException();
                        }
                        mediaAluno[i] += notas[i][j];
                    } catch (IllegalArgumentException e) {
                        System.out.println("Nota inválida.");
                        j--;
                    }
                }

                mediaAluno[i] /= notas[i].length;
            }

            for (int i = 0; i < notas.length; i++) {
                System.out.println("\nNotas do aluno " + nomes[i] + ":");
                for (int j = 0; j < notas[i].length; j++) {
                    if (j != 0) {
                        System.out.print(", ");
                    }
                    System.out.print(notas[i][j]);
                }
                System.out.println("\nMédia: " + mediaAluno[i]);
            }
        }
    }
}
