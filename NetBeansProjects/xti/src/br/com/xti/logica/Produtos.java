package br.com.xti.logica;
// AULA 28 While do While

import java.util.ArrayList;
import java.util.Scanner;

public class Produtos {
	
   public static void main(String[] args){
   
	/*FLUXO DE REPETIÇAO*/

ArrayList<String> produtos = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		System.out.println("Liste seus Produtos : Para sair digite FIM ");
		
		String produto;
		produto = s.nextLine();
		
		while(! "FIM".equals(produto = s.nextLine())){
			produtos.add(produto);
			
		}	
		
		System.out.println(produtos.toString());
		
		
	  }

	}