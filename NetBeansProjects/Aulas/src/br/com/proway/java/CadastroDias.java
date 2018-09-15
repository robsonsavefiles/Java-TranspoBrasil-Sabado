/*1)Crie um enum que contenha os dias da semana em seguida crie um aplicacao que receba
 *um numero de 1 a 7 e escreva o nome do dia, onde o dia 1 deve ser domingo e o dia 7 deve ser sabado; 
 */
package br.com.proway.java;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class CadastroDias {

    public static void main(String[] args) {

        int op;
        String sair = "";
        Scanner teclado = new Scanner(System.in);

        do {

            System.out.print("Digite algum numero de 1 ate 7 e 8 para sair:");
            op = Integer.parseInt(teclado.nextLine());

            switch (op) {
                case 1:
                    System.out.println(DiasSemana.DOMINGO);
                    break;
                case 2:
                    System.out.println(DiasSemana.SEGUNDA);
                    break;
                case 3:
                    System.out.println(DiasSemana.TERÇA);
                    break;
                case 4:
                    System.out.println(DiasSemana.QUARTA);
                    break;
                case 5:
                    System.out.println(DiasSemana.QUINTA);
                    break;
                case 6:
                    System.out.println(DiasSemana.SEXTA);
                    break;
                case 7:
                    System.out.println(DiasSemana.SABADO);
                    break;
                case 8:
                    System.out.println("Sistema Encerrado");
                    break;
                default:

            }
        } while (op != 8);

        teclado.close();

    }
}
