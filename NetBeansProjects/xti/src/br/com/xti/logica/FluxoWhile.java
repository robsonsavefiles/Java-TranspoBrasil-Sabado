package br.com.xti.logica;
///AULA 28 - While do While

import java.util.ArrayList;
import java.util.Scanner;


public class FluxoWhile {

	public static void main(String[] args) {
		
		/*Fluxo de Repeticao*/
		
		int i =0;
		while(i < 2){
			
			System.out.println(i);
			i++;
			
		// Mesma estrutura while;
		
		//	for(int i=0; i < 2; i++){
		//	System.out.println(i);
		//}
			
		}
		do {// 1-N 
			System.out.println(i);
			i++;
		}while(i < 2);
			
	
		ArrayList<String> produtos = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		System.out.println("Liste seus Produtos : Para sair digite FIM");
		
		String produto;
		produto = s.nextLine();
		
		while(! "FIM".equals(produto = s.nextLine())){
			produtos.add(produto);
			
		}	
		
		System.out.println(produtos.toString());
}
}		
	  

	