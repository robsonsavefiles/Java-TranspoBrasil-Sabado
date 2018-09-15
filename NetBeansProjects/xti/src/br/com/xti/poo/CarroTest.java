package br.com.xti.poo;

public class CarroTest {

	
	public static void main(String[] args) {
		
		Carro ferrari = new Carro();
		ferrari.modelo = "Ferrari Enzo";
		ferrari.velocidadeMaxima =349;
		ferrari.segundosZeroACem = 3.2;
		Motor v12 = new Motor();
		v12.tipo = "V12";
		v12.potencia = 660;
		ferrari.motor = v12;//adiciona o motor ao carro
		
		
		// construtor
		Carro bugati = new Carro("bugati CCXR", 349,3.2);
	    Motor v8 = new Motor("V8", 1018);
		bugati.motor = v8;
		
		Carro bugatti = new Carro("Bugatti Veyron", 430,2.2,new Motor("w16",1200));
		
		
		System.out.println(bugati.modelo);
		System.out.println(bugati.motor.potencia);
		System.out.println(bugatti.modelo);
		System.out.println(bugatti.motor.potencia);

		
		
	}

}
