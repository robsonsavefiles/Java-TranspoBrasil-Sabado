//Crie um programa que leia o nome e o endereço de 10 pessoas, em seguida apresente  os valores lidos.
package br.com.proway.java;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer10_String {

    public static void main(String[] args) {

        String[][] enderecos = new String[2][5];
        final int nome = 0;
        final int rua = 1;
        final int numero = 2;
        final int bairro = 3;
        final int cidade = 4;
        String mensagem = "";
        Scanner teclado = new Scanner(System.in);
        for (int contato = 0; contato < enderecos.length; contato++) {
            for (int codigo = 0; codigo < enderecos[contato].length; codigo++) {
                switch (codigo) {
                    case nome:
                        mensagem = "Informe o nome do contato";
                        break;
                    case rua:
                        mensagem = "Informe a Rua";
                        break;
                    case numero:
                        mensagem = "Informe o número";
                        break;
                    case bairro:
                        mensagem = "Informe o bairro";
                        break;
                    case cidade:
                        mensagem = "Informe a cidade";
                        break;
                }
                System.out.println(mensagem);
                enderecos[contato][codigo] = teclado.nextLine();
            }
        }
        System.out.println("os dados cadastrados foram:");
        for (int contato = 0; contato < enderecos.length; contato++) {
            System.out.printf("Contato: %s\r\n", enderecos[contato][nome]);
            System.out.printf("endereco: %s ,%s, %s %s\r\n",
                    enderecos[contato][rua],
                    enderecos[contato][numero],
                    enderecos[contato][bairro],
                    enderecos[contato][cidade]);
        }

        teclado.close();
    }
}
