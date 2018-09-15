package br.com.proway.java;

import java.util.Scanner;

public class Exer2While {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String sair = "";

        while (!sair.toLowerCase().equals("sair") && !sair.equals("10")) {//Comparando a String Sair;

            System.out.print("Informe um Numero: ");
            sair = (teclado.nextLine());

        }

        System.out.println("Aplicação Encerrada");

    }
}
