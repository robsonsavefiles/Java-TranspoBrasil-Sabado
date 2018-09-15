package arrays;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int qtd = 10;
        String[] nomes = new String[10];
        int[] idades = new int[10];
        int maisNovo = 0;
        int maisVelho = 0;
        double somaIdades = 0;

        for (int i = 0; i < qtd; i++) {
            System.out.println("Informe o nome do aluno " + (i + 1) + ": ");
            nomes[i] = teclado.nextLine();
            System.out.println("Informe a idade de " + nomes[i] + ": ");
            idades[i] = Integer.parseInt(teclado.nextLine());

            somaIdades += idades[i];

            if (idades[i] > idades[maisVelho]) {
                maisVelho = i;
            }
            if (idades[i] < idades[maisNovo]) {
                maisNovo = i;
            }
        }

        System.out.println("Média de idades: " + somaIdades / qtd);
        System.out.println("Aluno mais velho: " + nomes[maisVelho] + ", " + idades[maisVelho]);
        System.out.println("Aluno mais novo: " + nomes[maisNovo] + ", " + idades[maisNovo]);

        teclado.close();
    }
}
