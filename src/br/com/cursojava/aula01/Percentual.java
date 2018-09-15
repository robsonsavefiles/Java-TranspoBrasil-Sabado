package br.com.cursojava.aula01;

public class Percentual {
	
	public static void main(String[] args){
	
	double valorOriginal = 870.50;
    double percentual = 13.5 / 100.0; 
    float valorFinal = (float) (percentual * valorOriginal);
    
    System.out.println("O Percentual do valor é " + valorFinal);

	}
}
