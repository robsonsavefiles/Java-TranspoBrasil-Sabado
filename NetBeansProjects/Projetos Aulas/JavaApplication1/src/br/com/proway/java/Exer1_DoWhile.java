package br.com.proway.java;

import java.util.Scanner;

public class Exer1_DoWhile {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcao ="";

        do {// vai executar ao menos uma vez

            System.out.println("1-Sacar:");
            System.out.println("2-Depositar");
            System.out.println("3-Verificar Saldo");
            System.out.println("4-Sair\n\n");

            System.out.print("Digite a Opção:");
            opcao = teclado.nextLine();

     
            switch (opcao){
                case "1":
                    System.out.println("Sacar\n");
                    break;
                case "2":
                    System.out.println("Depositar\n");
                    break;

                case "3":
                    System.out.println("Verificar Saldo\n");
                    break;
                case "4":
                    System.out.println("Sair\n");
                    break;

                default:
                    break;
            }
        }while (!opcao.equals("4"));

            teclado.close();

        }
    }
