package parte1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 89087
 */
public class MenuThreads {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String opcao = "";

        do {
            System.out.println("\t\t O Escolha uma opçao\n");
            System.out.println("1-Os 10 primeiros multiplos de um numero:");
            System.out.println("2-Os 10 primeiros numeros pares a partir do valor informado:");
            System.out.println("3-Os 10 proximos numeros de fibonnaci de um valor:");
            System.out.println("4-Os 10 proximos anteriores da fibonacci de um valor:");
            System.out.println("5-Os 10 proximos numereos de um valor:");
            System.out.println("6-Os 10 proximos anteriores:");
            System.out.println("7-Qual o fatorial de um valor:");
            System.out.println("8-SAIR!!!");
            System.out.println("Informe a Opção:");
            opcao = teclado.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println("1-Os 10 primeiros multiplos de um numero:");
                    System.out.println("Informe um numero:");
                    int num = Integer.parseInt(teclado.nextLine());
                    Exer1_Thread r1 = new Exer1_Thread(num);
                    r1.start();
                    break;

                case "2":
                    System.out.println("2-Os 10 primeiros numeros pares a partir do valor informado:");
                    System.out.println("Informe um numero:");
                    int num2 = Integer.parseInt(teclado.nextLine());
                    Exer2_Thread r2 = new Exer2_Thread(num2);
                    r2.start();
                    break;

                case "3":
                    System.out.println("3-Os 10 proximos numeros de fibonnaci de um valor:");
                    System.out.println("Informe um numero:");
                    int num1 = Integer.parseInt(teclado.nextLine());
                    System.out.println("Informe um numero:");
                    int num3 = Integer.parseInt(teclado.nextLine());
                    Exer3_Thread r3 = new Exer3_Thread(num1, num3);
                    r3.start();
                    break;

                case "4":
                    System.out.println("4-Os 10 proximos anteriores da fibonacci de um valor:");
                    System.out.println("Informe um numero:");
                    int num4 = Integer.parseInt(teclado.nextLine());
                    System.out.println("Informe um numero:");
                    int num9 = Integer.parseInt(teclado.nextLine());
                    Exer4_Thread r4 = new Exer4_Thread(num4, num9);
                    r4.start();

                    break;

                case "5":
                    System.out.println("5-Os 10 proximos numeros de um valor:");
                    System.out.println("Informe um numero:");
                    int num5 = Integer.parseInt(teclado.nextLine());
                    Exer5_Thread r5 = new Exer5_Thread(num5);
                    r5.start();
                    break;

                case "6":
                    System.out.println("6-Os 10 proximos anteriores:");
                    System.out.println("Informe um numero:");
                    int num7 = Integer.parseInt(teclado.nextLine());
                    Exer6_Thread r6 = new Exer6_Thread(num7);
                    r6.start();
                    break;
                case "7":
                    System.out.println("7-Qual o fatorial de um valor:");
                    System.out.println("Informe um numero:");
                    int num8 = Integer.parseInt(teclado.nextLine());
                    Exer7_Thread r7 = new Exer7_Thread(num8);
                    r7.start();
                case "8":
                    break;

                default:
                    throw new AssertionError();
            }
        } while (!opcao.equalsIgnoreCase("8"));

    }

}
