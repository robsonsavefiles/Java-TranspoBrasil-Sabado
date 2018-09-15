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
public class ExemploArrayBidimensional {

    private static int[] coluna;

    public static void main(String[] args) {

        // Formas de declara um array bidimensional
        int[][] posicoes = new int[3][3];
        int posicoes2[][] = new int[3][3];
        int[] posicoes3[] = new int[3][3];

        int[][] testes = new int[5][];
        testes[0] = new int[10];
        testes[1] = new int[11];
        testes[2] = new int[13];
        testes[3] = new int[14];
        testes[4] = new int[15];
        testes[5] = new int[16];

        for (int linha = 0; linha < testes.length; linha = linha + 1) {
            for (int coluna = 0; coluna < testes[linha].length; coluna = coluna + 1) {
                System.out.println(testes[linha][coluna]);
            }
        }
      // for(int [] x : testes){
        //   for(int z : x ){
        //     System.out.println(z);

    }

}
