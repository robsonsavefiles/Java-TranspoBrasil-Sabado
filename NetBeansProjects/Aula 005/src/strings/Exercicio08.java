package strings;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio08 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            int[] numeros = new int[100];
            int posMenor = 0;
            int posMaior = 0;
            int soma = 0;

            System.out.println("Informe " + numeros.length + " números.");

            for (int i = 0; i < numeros.length; i++) {
                System.out.println("Número da posição " + (i) + ": ");
                numeros[i] = Integer.parseInt(teclado.nextLine());

                if (numeros[i] < numeros[posMenor]) {
                    posMenor = i;
                }

                if (numeros[i] > numeros[posMaior]) {
                    posMaior = i;
                }

                soma += numeros[i];
            }

            System.out.println("Menor número = " + numeros[posMenor] + ". Posição " + posMenor);
            System.out.println("Maior número = " + numeros[posMaior] + ". Posição " + posMaior);
            System.out.println("Média = " + soma / numeros.length);
        }
    }
}
