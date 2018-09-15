package br.com.xti.heranca;

public class Cachorro extends Animal{

	public Cachorro(){
		super(30,"Carne");
	}
	
	void fazerBarulho(){//com a mesma assinatura da super classe(sobrescrevendo);
		
		System.out.println("Au, Au!!");
		
		
	}
}
	
	
