package exercicios.enums.semana;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ExercicioSemana {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Forneça um número de 1 a 7:");
        int dia = Integer.parseInt(teclado.nextLine());
        System.out.println("Dia escolhido = " + DiasSemana.values()[dia - 1]);
    }
}
