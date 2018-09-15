package br.com.xti.logica;
// Aula 25 - FLUXO CONDICIONAL 

// JOGO DE DADOS

//		- QUAL O PALPITE?
//		- QUAL O VALOR DO DADO?
//		- PALPITE ESTA CORRETO?

import java.util.Random;
import java.util.Scanner;

public class Dado1 {

public static void main(String[] args){
	
	Scanner s = new Scanner(System.in);
	System.out.println("QUAL O SEU PALPITE");
	int palpite = s.nextInt();
	
	Random n = new Random();
	int dado = n.nextInt(6)+1;// 0-5
	
	//System.out.println("Palpite = "palpite);
	//System.out println("Dado = "+ dado);

	if(palpite == dado){
		System.out.println("ACERTOU MISERAVI, QUEM TE ENSINOU");
	}else{
		System.out.println("Voce Errou");
		
		
	}	
	
		
		
		
   }

}
