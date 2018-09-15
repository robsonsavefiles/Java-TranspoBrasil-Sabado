/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

import java.util.Scanner;


public class Exer1_Array {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int[] alunos = new int[10];
        double[] notas = new double[10];
        double media =0;
        
       
        for(int index = 0;index<notas.length;index = index+1){
        
        System.out.print("Informe as notas dos alunos:"+index+1);
        notas[index]=Double.parseDouble(teclado.nextLine());
        media = media+notas[index];
        
       System.out.println("a media das medias é"+media);
        }
        
        
        }
         
    }
    
    
