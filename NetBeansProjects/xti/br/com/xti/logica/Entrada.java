package br.com.xti.logica;
//*Aula 11 Entrada de dados com Scanner


import java.util.Scanner;

public class Entrada {

	public static void main(String[] args)
	
	{
		//Chamada do programa
		// System.out.println(args[0]);

		 
		//Interagindo com o Usuario
		Scanner s = new Scanner(System.in);
		System.out.println(s.nextLine());
		System.out.println("Qual o Seu Nome");
		String nome = s.nextLine();
		System.out.println("Bem Vindo " + nome);
		
		
	}


}