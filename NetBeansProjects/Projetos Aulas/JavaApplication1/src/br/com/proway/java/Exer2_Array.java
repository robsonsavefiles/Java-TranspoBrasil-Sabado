/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer2_Array {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String[] nomes = new String[10];
        int[] idades = new int[10];
        double media =0;
        int posMenor =0;
        int posMaior = 0;
        
        for(int posicao =0;posicao < nomes.length;posicao = posicao+1){
            System.out.print("Informe o nome:"+(posicao));
            nomes[posicao] = teclado.nextLine();
            System.out.print("Informe a idade do "+ nomes[posicao]);
            idades[posicao] = Integer.parseInt(teclado.nextLine());
            media= media + idades[posicao];
            if(idades[posicao]< idades[posMenor]){
                posMenor = posicao;
            }
            if(idades[posicao]< idades[posMaior]){
                posMaior = posicao;
        }
    }
        media = media/idades.length;
        System.out.println("Média de idades é "+media);
        System.out.printf("%s tem %d e é o mais novo\r\n",nomes[posMenor],
                                                          idades[posMenor]);
        System.out.printf("%s tem %d e é o mais Velho\r\n",nomes[posMaior],
                                                          idades[posMaior]);
        

        teclado.close();
    
    
}
}
