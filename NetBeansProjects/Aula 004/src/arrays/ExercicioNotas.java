package arrays;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ExercicioNotas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double[][] notas = new double[5][3];
        double mediaTurma = 0;
        double[] mediaAluno = new double[notas.length];

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Forneça as notas do aluno " + (i + 1) + ".");
            for (int j = 0; j < notas[i].length; j++) {
                System.out.println("Nota " + (j + 1) + ":");
                notas[i][j] = Double.parseDouble(teclado.nextLine());
                if (notas[i][j] > 10 || notas[i][j] < 0) {
                    System.out.println("Nota inválida.");
                    j--;
                    continue;
                }
                mediaAluno[i] += notas[i][j];
                mediaTurma += notas[i][j];
            }
            mediaAluno[i] /= notas[i].length;
        }

        mediaTurma = mediaTurma / (notas.length * notas[0].length);

        for (int i = 0; i < notas.length; i++) {
            System.out.println("\nNotas do aluno " + (i + 1) + ":");
            for (int j = 0; j < notas[i].length; j++) {
                if (j != 0) {
                    System.out.print(", ");
                }
                System.out.print(notas[i][j]);
            }
            System.out.println("\nMédia: " + mediaAluno[i]);
        }
        System.out.println("\nMédia da turma: " + mediaTurma);

        teclado.close();
    }
}
