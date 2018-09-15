package br.com.xti.logica;
// aula 23 - IF ELSE - FLUXO CONDICIONAL


public class Fluxo {
	
	public static void main(String[] args){
	
	int idade = 90;
	
	if(idade <= 11){
		System.out.println("Crianca");	
		
	}else if (idade > 11 && idade <=18){
		System.out.println("Adolescente");	
	}	else if (idade > 18 && idade <=60){
		System.out.println("Adolescente");

	}else {
		System.out.println("Melhor Idade");
		if(idade >=60){
			System.out.println("Voce nao vai morrer?");
			
		}
		
	}

	}

}
