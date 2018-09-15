package exercicios.calculadora;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Valor 1: ");
        double valor1 = Double.parseDouble(teclado.nextLine());
        System.out.println("Valor 2: ");
        double valor2 = Double.parseDouble(teclado.nextLine());
        System.out.println(valor1 + " + " + valor2 + " = " + Calculadora.adicao(valor1, valor2));
        System.out.println(valor1 + " - " + valor2 + " = " + Calculadora.subtracao(valor1, valor2));
        System.out.println(valor1 + " * " + valor2 + " = " + Calculadora.multipliacao(valor1, valor2));
        System.out.println(valor1 + " / " + valor2 + " = " + Calculadora.divisao(valor1, valor2));
    }
}
