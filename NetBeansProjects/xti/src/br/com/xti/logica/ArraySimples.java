package br.com.xti.logica;
//*Aula 20 Arrays

import java.util.Arrays;

public class ArraySimples {

	public static void main(String[] args){
	
		int[] impares = new int[5];
		impares[0] = 1;
		impares[1] = 3;
		impares[2] = 5;
		impares[3] = 7;
		impares[4] = 9;
		
		
		String[] paises = {"Brasil", "Russia","India","China"};
		System.out.println(paises[0]);
		System.out.println(paises.length);// descobrir quantidade de posiçoes do array
		System.out.println(Arrays.toString(paises));	
		
		int posicao = Arrays.binarySearch(paises,"Russia");// buscar um valor em um array
		System.out.println(posicao);
		
		Arrays.sort(paises,0, paises.length);
		System.out.println(Arrays.toString(paises));
		
		Double[] valores = {12.35,3456.3456};
		System.out.println(valores[0].doubleValue());
		
		
		
	
	}


}