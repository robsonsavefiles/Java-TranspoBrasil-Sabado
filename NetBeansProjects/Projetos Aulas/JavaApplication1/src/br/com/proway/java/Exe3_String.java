//3)crie um programa que solicite ao usuario um palavra e e seguida  informe se  palavra digitada  é uma palindroma;

package br.com.proway.java;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exe3_String {
    
  
     public static void main (String args[]){
         String nome;
         int i, j, tam;
         
          Scanner teclado = new Scanner(System.in);
          System.out.println("Digite uma palavra:");
          nome = teclado.nextLine();

                 tam = nome.length()-1;
                 System.out.println ("\nA palavra tem " + tam + " caracteres.");
                 
                 i=0;
                 j=tam;
                 do{
                     if (nome.charAt(i) == nome.charAt(j)){
                         i++;
                         j--;
                         System.out.println ("Caracter igual.");
                         System.out.println ("Palavra é Palindrome.");
                     }
                         
                 else
                             {
                                     System.out.println ("Palavra nao é Palindrome.");
                                     break;
                             }
                                     
                         
                 } while ((i<=tam) && (j>=0));
               // System.out.println ("Palavra Palindrome.");
                 
     }
 }