package comparacoeslogicas;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Exercicio4 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double[] notas = new double[3];
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Informe a nota " + (i + 1) + " do aluno:");
            try {
                notas[i] = Double.parseDouble(teclado.nextLine());
                if (notas[i] < 0 || notas[i] > 10) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Nota inválida.");
                i--;
            }
        }
        double media = (notas[0] + notas[1] + notas[2]) / 3;
        if (media >= 9) {
            System.out.println("Conceito A");
        } else if (media >= 7) {
            System.out.println("Conceito B");
        } else if (media >= 6) {
            System.out.println("Conceito C");
        } else {
            System.out.println("Conceito D");
        }
    }
}
