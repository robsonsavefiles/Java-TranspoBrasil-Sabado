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
public class Uso_Array {

    public static void main(String[] args) {
        int[] idades = new int[5];//declaraçao de um array de inteiros

        //atribuição de valores para o array
        idades[0] = 34;
        idades[1] = 25;
        idades[2] = 12;
        idades[3] = 40;
        idades[4] = 17;
        
        
        //for(int idade: idades){//FOR APRIMORADO
        //System.out.println(idade);
        
        
        for (int posicao = 0; posicao < idades.length; posicao = posicao + 1) {
            System.out.println(posicao + "->" + idades[posicao]);
        }

    }

}
