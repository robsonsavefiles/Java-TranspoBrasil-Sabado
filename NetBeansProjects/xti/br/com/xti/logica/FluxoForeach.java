package br.com.xti.logica;
// AULA 27 - FOREACH

import java.util.ArrayList;

public class FluxoForeach {

	public static void main(String[] args) {
	
	/*foreach*/
	int[] pares ={2,4,6,8};
	for(int i=0; i<pares.length; i++){
		
	int par = pares[i];
	System.out.println(par);
		
	}
	// for aprimorado
	
	for(int par: pares){
		
	System.out.println(par);
		
		}
		
		
	//foreach*/

	ArrayList<Integer> list = new ArrayList<Integer>();// criando um ArrayList
	for (int i=0; i<10;i++){
		list.add(i);// Adicionando no array 
	}
	
	//For Aprimorado
	
		for(Integer numero : list){
			System.out.println(numero);
			
		}

	}

}