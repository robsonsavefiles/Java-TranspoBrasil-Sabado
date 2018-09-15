package br.com.xti.logica;
//*Aula 18 - Operadores Especiais

import java.util.Scanner;

public class Operador18 {

	public static void main(String[] args){
		/*
		int idade = 26;
		String x = (idade>=18) ?"Maior de Idade" : "Menor de Idade";
		String sexo = "M",pais = "Brasil";
		*/
		Scanner s = new Scanner(System.in);
		System.out.println("Informe o Raio");
		double raio = s.nextDouble();
		
		//Diâmtro : 2r
		//double raio = 10;
		double diamentro = 2*raio;
		System.out.println("Diamentro="+diamentro);
		
		//Circunferência : 2 PI raio
		double pi = Math.PI;
		double circunferencia = 2 * pi * raio;
		System.out.println("Cirucunferencia"+circunferencia);
		 
		//Area PI r2
		double area = pi * (raio * raio);
		System.out.println("area"+area);
		 
		 
		
		
		
		
		
		
		
	}


}