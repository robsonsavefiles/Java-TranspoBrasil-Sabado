/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

import java.util.ArrayList;
import java.util.Scanner;

public class ExemploLista {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<String> nomes = new ArrayList<String>();

        String atual = "";
        do {

            System.out.println("escolha uma das opções:");
            System.out.println("1 - Adicionar nome");
            System.out.println("2 - Listar nomes");
            System.out.println("3 - Editar nome");
            System.out.println("4 - Remover nome");
            System.out.println("5 - Sair");

            atual = teclado.nextLine();
            switch (atual) {
                case "1":
                    adicionar(teclado, nomes);
                    break;
                case "2":
                    listar(teclado, nomes);
                    break;
                case "3":
                    editar(teclado, nomes);
                    break;
                case "4":
                    remover(teclado, nomes);
                    break;
            }

        } while (!"4".equalsIgnoreCase(atual));
    }

    private static void adicionar(Scanner teclado, ArrayList<String> nomes) {

        String texto = "";
        do {
            System.out.println("=== ADICIONAR ====");
            System.out.println("Digite um nome ou 's' para voltar ao menu principal");
            texto = teclado.nextLine();
            if (!"s".equalsIgnoreCase(texto)) {
                nomes.add(texto);
            }
        } while (!"s".equalsIgnoreCase(texto));
    }

    private static void listar(Scanner teclado, ArrayList<String> nomes) {
        String texto = "";
        String nome = "";
        do {
            System.out.println("=== LISTAR ====");
            System.out.println("id   nome");
            for (int index = 0; index < nomes.size(); index++) {
                nome = nomes.get(index);
                System.out.printf("%d    %s\r\n", index, nome);
            }
            System.out.println("Digite enter para listar novamente ou qualquer outra tecla para voltar ao menu principal");
            texto = teclado.nextLine();

        } while ("".equalsIgnoreCase(texto));
    }

    private static void remover(Scanner teclado, ArrayList<String> nomes) {
        String texto = "";
        do {
            System.out.println("=== REMOVER ====");
            System.out.println("Digite o indice para remover ou 's' para voltar ao menu principal");
            texto = teclado.nextLine();
            if (!"s".equalsIgnoreCase(texto)) {
                int id = Integer.parseInt(texto);
                if (id > -1 && id < nomes.size()) {
                    nomes.remove(id);
                    System.out.println("Nome removido com sucesso!");
                } else {
                    System.out.println("Indice inválido");
                }
            }
        } while (!"s".equalsIgnoreCase(texto));
    }

    private static void editar(Scanner teclado, ArrayList<String> nomes) {
        String texto = "";
        String nome = "";
        do {
            System.out.println("=== EDITAR ====");
            System.out.println("Digite o indice para editar ou 's' para voltar ao menu principal");
            texto = teclado.nextLine();
            if (!"s".equalsIgnoreCase(texto)) {
                int id = Integer.parseInt(texto);
                if (id > -1 && id < nomes.size()) {
                    nome = nomes.get(id);
                    System.out.println("Digite o novo valor para o nome" + nome);
                    nome = teclado.nextLine();
                    nomes.set(id, nome);
                    System.out.println("Nome Alterado com sucesso!");
                } else {
                    System.out.println("Indice inválido");
                }
            }
        } while (!"s".equalsIgnoreCase(texto));
    }

}
