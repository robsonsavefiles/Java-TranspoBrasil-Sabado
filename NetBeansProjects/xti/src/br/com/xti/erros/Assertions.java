package br.com.xti.erros;

import java.util.Scanner;

public class Assertions {

	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Entre um numero de 0 a 10");
		int numero = s.nextInt();
		
		assert(numero >= 0 && numero <=10):"Numero invalido "+ numero ;
		System.out.println("Voce entrou " + numero );
		
	}

}
