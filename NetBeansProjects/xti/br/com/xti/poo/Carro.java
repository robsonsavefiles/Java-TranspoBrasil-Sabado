package br.com.xti.poo;

public class Carro {
	String modelo;
	int velocidadeMaxima;
	double segundosZeroACem;
	Motor motor;
	
	
	public Carro(){// construtor 
		
		

	}
	//construtor 2
	
	public Carro(String modelo,int velocidadeMaxima,double segundosZeroACem){
	 
		this(modelo,velocidadeMaxima,segundosZeroACem, null);// chamando outro construtor
	
	}
	// construtor 3
	public Carro(String modelo,int velocidadeMaxima,double segundosZeroACem,Motor motor){
		 
		this.modelo = modelo;
		this.velocidadeMaxima = velocidadeMaxima;
		this.segundosZeroACem = segundosZeroACem;
		this.motor = motor;

	}
}