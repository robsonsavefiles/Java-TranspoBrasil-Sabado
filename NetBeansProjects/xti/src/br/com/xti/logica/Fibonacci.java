package br.com.xti.logica;
/*Desafio: Fibonacci Aula 29

	Começa-se a serie como 0 (zero) e 1(um);
	Obtem-se o proximo numero de Fibonacci
	Somando-se dos dois anteriores e, assim, sucessiva e infinitamente;
	
	Ex: 1+2[3]  2+3[5] 3+5[8] 5+8[13]...
	
	0,1,1,2,3,5,8,13,21,34,55,89,144,233,,377,610,
	987,1597,2584

*/

import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {
	
   public static void main(String[] args){
	   
	   int anterior = 0;
	   int proximo = 1;
	   
	   while(proximo <50){
	 
	   System.out.println(proximo);  
	   proximo = proximo + anterior;// proximo numero fibonacci
	   anterior = proximo - anterior;// atualizando o numero anterior(soma - numero anterior);
	   
	   }
	  
		
	  }

	}