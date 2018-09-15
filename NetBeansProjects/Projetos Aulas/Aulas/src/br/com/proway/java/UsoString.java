/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

/**
 *
 * @author 89087
 */
public class UsoString {

    public static void main(String[] args) {

        String texto = "Abacaxi Abacaxi cade o meu Caqui?:";
        //System.out.println(args.length);// atributo

        //Informa a quantidade de caracteres da string
        System.out.println(texto.length());// metodo()

        //concatenar
        String nome = "Robson";
        String lastName = "Melo";
        System.out.println(nome + " " + lastName);

        System.out.println(nome.concat(" ").concat(lastName));

        //
        for (int index = 0; index < texto.length(); index++) {
            System.out.println(texto.charAt(index));// cada caracter em cada linha

            System.out.print(nome.contains("ro")); // retorna um boolean
            System.out.print(nome.indexOf("ro"));
            System.out.print(nome.indexOf("RO"));
            System.out.println(nome.replace('e', '1')); // troca e remove a string

            String teste = "         teste 123";
            System.out.println(">" + teste + "<");
            System.out.println(">" + teste.trim() + "<");// metoto trim retirar os espaços em brancos no começo ou no fim 
            teste = "                                         ";
            System.out.println("".equals(teste.trim()) ? "vazio " : "nao vazio");

            System.out.println(texto.substring(10));
            System.out.println(texto.substring(16, 20));

            System.out.println(nome.toUpperCase());// caixa alta
            System.out.println(nome.toLowerCase());// caixa baixa

            // dividir a string por palavra
            String[] palavras = texto.split(" ");

            for (String palavra : palavras) {
                System.out.println(palavra);

            }
            String dadosContato = "Robson Ferreira de Melo;robson.ferreiramelo@gmail.com;92633291";
            String[] dados = dadosContato.split(";");

            for (String dado : dados) {
                System.out.println(dados);
            }

        }

    }

}
