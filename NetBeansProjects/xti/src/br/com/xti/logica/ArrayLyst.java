package br.com.xti.logica;
/*Aula 22 - ArrayList
	
	Collection Framework ArrayList
	
	1- Adicionar
	2- Remover
	3- Pesquisar
	4- Recupear


*/

import java.util.ArrayList;

public class ArrayLyst {
	
	public static void main(String[] args){
		
		
		ArrayList<String> cores = new ArrayList<String>();
		cores.add("Branco");
		cores.add(0,"Vermelho");
		cores.add("Amarelo");
		cores.add("Azul");
		
		System.out.println(cores.toString());
		System.out.println(cores.size());// pegar o tamanho do ArrayList
		System.out.println("Tamanho = " + cores.size());
		System.out.println("Elemento2 = " + cores.get(2));
		System.out.println("Indice Branco= " + cores.indexOf("Branco"));
		
		
		cores.remove("Branco");
		
		
		System.out.println("Tem Amarelo ? " + cores.contains("Amarelo"));// Verificar se tem o elemtento no arrayList
		
		
		
		
		
	
		
	}
	
	
	
	
	
}


