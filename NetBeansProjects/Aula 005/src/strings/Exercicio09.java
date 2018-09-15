package strings;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio09 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            int tamanho = 5;
            int[] num1 = new int[tamanho];
            int[] num2 = new int[tamanho];
            int[] soma = new int[tamanho];
            int[] inclusivos = new int[tamanho];
            int[] exclusivos1 = new int[tamanho];
            int[] exclusivos2 = new int[tamanho];
            int[] mesclado = new int[tamanho];
            int idxInc = -1;
            int idxExc1 = -1;
            int idxExc2 = -1;

            System.out.println("Forneça os números para o vetor 1.");
            for (int i = 0; i < num1.length; i++) {
                System.out.println("Posição " + i + ": ");
                num1[i] = Integer.parseInt(teclado.nextLine());

                // Array Soma
                soma[i] += num1[i];
            }

            System.out.println("Forneça os números para o vetor 2.");
            for (int i = 0; i < num2.length; i++) {
                System.out.println("Posição " + i + ": ");
                num2[i] = Integer.parseInt(teclado.nextLine());

                // Array Soma
                soma[i] += num2[i];
            }

            for (int i = 0; i < tamanho; i++) {

                // Array Inclusivos
                if (contem(num1[i], num2)) {
                    inclusivos[++idxInc] = num1[i];
                }

                // Array Exclusivos 1
                if (!contem(num1[i], num2)) {
                    exclusivos1[++idxExc1] = num1[i];
                }

                // Array Exclusivos 2
                if (!contem(num2[i], num1)) {
                    exclusivos2[++idxExc2] = num2[i];
                }

                // Array Mesclado
                mesclado[i] = i % 2 == 0 ? num1[i] : num2[i];
            }

            System.out.println();

            System.out.println("Array 1: ");
            imprimeVetor(num1, num1.length);

            System.out.println("Array 2: ");
            imprimeVetor(num2, num2.length);

            System.out.println("Array Soma: ");
            imprimeVetor(soma, soma.length);

            System.out.println("Array Inclusivos: ");
            imprimeVetor(inclusivos, idxInc + 1);

            System.out.println("Array Exclusivos 1: ");
            imprimeVetor(exclusivos1, idxExc1 + 1);

            System.out.println("Array Exclusivos 2: ");
            imprimeVetor(exclusivos2, idxExc2 + 1);

            System.out.println("Array Mesclado: ");
            imprimeVetor(mesclado, mesclado.length);
        }
    }

    public static boolean contem(int numero, int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) {
                return true;
            }
        }
        return false;
    }

    public static void imprimeVetor(int[] vetor, int qtd) {
        for (int i = 0; i < qtd; i++) {
            System.out.print("[");
            System.out.print(vetor[i]);
            System.out.print("] ");
        }
        System.out.printf("%n%n");
    }
}
