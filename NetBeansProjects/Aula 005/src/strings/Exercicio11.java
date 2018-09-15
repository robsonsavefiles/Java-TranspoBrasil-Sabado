package strings;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio11 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            int tamanho = 5;
            String[] nomes = new String[tamanho];
            double[] notas = new double[tamanho];
            double soma = 0;
            double media;

            for (int i = 0; i < tamanho; i++) {
                System.out.println("Nome do aluno " + (i + 1) + ":");
                nomes[i] = teclado.nextLine();
                while (true) {
                    System.out.println("Nota de " + nomes[i] + ":");
                    notas[i] = Double.parseDouble(teclado.nextLine());
                    if (notas[i] < 0 || notas[i] > 10) {
                        System.out.println("Nota inválida.");
                        continue;
                    }
                    soma += notas[i];
                    break;
                }
            }

            media = soma / tamanho;

            System.out.println("Média da turma = " + media);

            for (int i = 0; i < tamanho; i++) {
                if (notas[i] >= media) {
                    System.out.println(nomes[i] + ". Nota: " + notas[i]);
                }
            }
        }
    }
}
