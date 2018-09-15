package br.tiago.comparacao;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ExercicioComparacao3 {

    public static void main(String[] args) {
        String[] nomes = new String[4];
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Forneça o nome " + (i + 1));
            nomes[i] = teclado.nextLine();
        }

        System.out.println("Primeiro igual ao terceiro? " + nomes[0].equals(nomes[2]));
        System.out.println("Segundo igual ao último? " + nomes[1].equals(nomes[3]));
    }
}
