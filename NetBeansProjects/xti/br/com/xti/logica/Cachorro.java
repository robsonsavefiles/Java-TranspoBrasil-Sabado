package br.com.xti.logica;

import br.com.xti.heranca.Animal;



public class Cachorro extends Animal {
	
	public Cachorro(){
	super(30,"Carne");
	
	}
	void fazerBarulho(){
	System.out.println("AU, AU");	
	}
	
	int tamanho;
	String raca;
	
	void latir(){
		System.out.println("Au, au, au ");
	}

}
