/*
 /*UM Programa  para exibir  calculos simples 0 usuario devera poder escolher entre 7
 opçoes de calculos para o programa resolver e ele devera poder resolver varios calculos
 ao tempo.

 As 7 opçoes serão:
 os 10 primeiros multiplos de um numero
 os 10 primeiros numeros pares apartir de um valor
 os 10 proximos numeros de fibonnaci de um valor
 os 10 numeros anteriores da fibonnaci de um valor
 os 10 proximos numeros de um valor;
 os 10 numeros anteriores
 Qual o fatorial de um valor;
 */
package parte1;

import dados.Thread4;
import dados.Thread5;
import dados.Thread6;
import dados.Thread7;
import dados.Thread8;
import dados.Threads1;
import dados.Threads2;
import dados.Threads3;
import java.util.Scanner;

/**
 *
 * @author 88178
 */
public class Executor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String op ="";
        do {            
            
        
        System.out.println("Digite a opção desejada");
        System.out.println("1 - 10 primeiros multiplos");
        System.out.println("2 - 10 primeiros pares");
        System.out.println("3 - sequencia de fibonnaci");
        System.out.println("4 - sequencia de fibonnaci invertida");
        System.out.println("5 - Os 10 proximos valores");
        System.out.println("6 - Os valores anteriores");
        System.out.println("7 - O fatorial de um numero");
        System.out.println("8 - Sair");
       op = teclado.nextLine();

        
        switch (op) {
            case "1":
                System.out.println("Digite um numero");
                int numero = Integer.parseInt(teclado.nextLine());
                Threads2 thread2 = new Threads2(numero);
                thread2.start();
                break;
            case "2":
                 System.out.println("Digite um numero");
                int num = Integer.parseInt(teclado.nextLine());
                Threads3 thread3 = new Threads3(num);
                thread3.start();
                break;
            case "3":
                System.out.println("Digite um numero");
                int num1 = Integer.parseInt(teclado.nextLine());
                System.out.println("Digite um numero");
                int num2 = Integer.parseInt(teclado.nextLine());               
                Thread4 thread4 = new Thread4(num1,num2);
                thread4.start();
                break;
            case "4":
                System.out.println("Digite um numero");
                int num3 = Integer.parseInt(teclado.nextLine());
                System.out.println("Digite um numero");
                int num4 = Integer.parseInt(teclado.nextLine());               
                Thread5 thread5 = new Thread5(num3,num4);
                thread5.start();
                break;
            case "5":
                 System.out.println("Digite um numero");
                int num5 = Integer.parseInt(teclado.nextLine());
                Thread6 thread6 = new Thread6(num5);
                thread6.start();
                break;
            case "6":
                System.out.println("Digite um numero");
                int num6 = Integer.parseInt(teclado.nextLine());
                Thread7 thread7 = new Thread7(num6);
                thread7.start();
                break;
            case "7":
                System.out.println("Digite um numero");
                int num7 = Integer.parseInt(teclado.nextLine());
                Thread8 thread8 = new Thread8(num7);
                thread8.start();
                break;
                
            default:
                throw new AssertionError();
        }
        } while (!op.equalsIgnoreCase("8"));
    }

}
