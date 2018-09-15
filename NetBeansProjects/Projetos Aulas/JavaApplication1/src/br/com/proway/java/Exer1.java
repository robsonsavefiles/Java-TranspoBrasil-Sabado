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
public class Exer1{
    
    
     public static void main(String[] args) {
         
        Scanner teclado = new Scanner(System.in);
       
        System.out.print("Informe um Numero:");	
	String num1 = teclado.nextLine();
	int n1 = Integer.parseInt(num1);
        
         System.out.println("O numero é maior que 10?:"+(n1>10));
         System.out.println("O numero é menor que 100?:"+(n1<100));
         System.out.println("o numero é diferente de 27?:"+(n1!=27));
         System.out.println("o numero é igual a 25?:"+(n1==25));
         System.out.println("o numero é menor ou igual a 50?:"+(n1<=50));
         System.out.println("o numero é menor ou igual a 30?:"+(n1>=30));

        
    
}
}
