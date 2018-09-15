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
public class Exer3_IfElse {
   
    
    public static void main(String[] args) {
    
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe a primeira nota");
        int n1 = Integer.parseInt(teclado.nextLine());
        System.out.println("Informe a segunda nota");
        int n2 = Integer.parseInt(teclado.nextLine());
        System.out.println("Informe a segunda nota");
        int n3 = Integer.parseInt(teclado.nextLine());
        
      
        double media = (n1+n2+n3)/3;
        
      
        if(media>=6){
    
        System.out.println("Aprovado");
        
        }else{
            System.out.println("Reprovado");

        }
    }
}
    

