//9)Escreva um programa que leia 60 números  inteiros e os armazene em dois vetores. Em seguida crie um terceiro vetor que deve conter
//a soma de cada item do primeiro vetor com o item de mesmo índice do segundo vetor. Um quarto vetor que possua todos os elementos que
//estão no Primeiro vetor e que estão no segundo vetor. Crie um outro vetor para conter os elementos que estão no primeiro vetor mais não 
//estão no segundo vetor. Crie um outro vetor que contenha os elementos que estão no segundo vetor mais não estão no primeiro vetor. 
//Crie um outro vetor que contenha em suas posições pares os elementos do primeiro vetor e em suas posições impares os elementos do segundo vetor.
//
package br.com.proway.java;

import java.util.Scanner;

public class Exer9_String {
   

    public static void main(String[] args) {
        
         int quantidade = 5;
        int[] vetor1 = new int[quantidade];
        int[] vetor2 = new int[quantidade];
        int[] vetorSoma = new int[quantidade];
        int[] vetorInter = new int[quantidade];
        int[] vetorSo1 = new int[quantidade];
        int[] vetorSo2 = new int[quantidade];
        int[] vetorUniao = new int[quantidade * 2];

        Scanner teclado = new Scanner(System.in);
        //leitura dos números
        for (int index = 0; index < vetor1.length; index++) {
            System.out.println("Informe  valor do numero " + (index + 1));
            vetor1[index] = Integer.parseInt(teclado.nextLine());
        }
        for (int index = 0; index < vetor1.length; index++) {
            System.out.println("Informe  valor do numero " + (index + 1 + quantidade));
            vetor2[index] = Integer.parseInt(teclado.nextLine());
        }

         //============================================================
        //SOMA dos elementos de mesmo índice
        //============================================================
        for (int index = 0; index < vetorSoma.length; index++) {
            vetorSoma[index] = vetor1[index] + vetor2[index];
        }
         //============================================================
        //Intercecção dos vetores
        //============================================================
        int qtInter = -1;
        for (int index = 0; index < vetor1.length; index++) {
            for (int idx = 0; idx < vetor2.length; idx++) {
                if (vetor1[index] == vetor2[idx]) {
                    vetorInter[++qtInter] = vetor1[index];
                    break;
                }
            }
        }
         //============================================================
        //Elementos que estão Somente no vetor 1
        //============================================================
        int qtSo1 = -1;
        boolean contem = false;
        for (int index = 0; index < vetor1.length; index++) {
            contem = false;
            for (int idx = 0; idx < vetor2.length; idx++) {
                if (vetor1[index] == vetor2[idx]) {
                   contem = true;
                    break;
                }
            }
            if(!contem){
                vetorSo1[++qtSo1] = vetor1[index];
            }
        }
        
        //============================================================
        //Elementos que estão Somente no vetor 2
        //============================================================
        
        int qtSo2 = -1;
        for (int index = 0; index < vetor2.length; index++) {
            contem = false;
            for (int idx = 0; idx < vetor1.length; idx++) {
                if (vetor1[idx] == vetor2[index]) {
                   contem = true;
                    break;
                }
            }
            if(!contem){
                vetorSo2[++qtSo2] = vetor2[index];
            }
        }
        
         //============================================================
        //União pares e impares
        //============================================================
        int idx1 =0;
        int idx2 = 0;
        int valor = 0;
        for (int index = 0; index < vetorUniao.length; index++) {
           
            if(index % 2 == 0){
                valor = vetor1[idx1++];
            }else{
                valor = vetor2[idx2++];
            }
            vetorUniao[index] = valor;
        }
        
        //imprimir o vetor 1
        System.out.println("Dados do vetor1");
        for(int index = 0; index< vetor1.length; index++){
            System.out.printf("[%d] ",vetor1[index]);
        }
        System.out.println("");
        
        //imprimir o vetor 2
        System.out.println("Dados do vetor2");
        for(int index = 0; index< vetor2.length; index++){
            System.out.printf("[%d] ",vetor2[index]);
        }
        System.out.println("");
        
         //imprimir o vetorSoma
        System.out.println("Dados da Soma");
        for(int index = 0; index< vetorSoma.length; index++){
            System.out.printf("[%d] ",vetorSoma[index]);
        }
        System.out.println("");
        
        if(qtInter >-1){
            System.out.println("Dados da Intercecção");
            for(int index = 0; index<= qtInter; index++){
            System.out.printf("[%d] ",vetorInter[index]);
        }
         System.out.println("");
        }else{
            System.out.println("Não existem números comuns aos dois vetores");
        }
        
        if(qtSo1 >-1){
            System.out.println("Dados apenas no primeiro Vetor");
            for(int index = 0; index<= qtSo1; index++){
            System.out.printf("[%d] ",vetorSo1[index]);
        }
         System.out.println("");
        }else{
            System.out.println("Não existem números que são apenas do primeiro vetor");
        }
        
        if(qtSo2 >-1){
            System.out.println("Dados apenas no Segundo Vetor");
            for(int index = 0; index<= qtSo2; index++){
            System.out.printf("[%d] ",vetorSo2[index]);
        }
         System.out.println("");
        }else{
            System.out.println("Não existem números que são apenas do segundo vetor");
        }
        System.out.println("União intercalada");
        for(int index = 0; index< vetorUniao.length; index++){
            System.out.printf("[%d] ",vetorUniao[index]);
        }
        System.out.println("");

        teclado.close();


       
    }
}
