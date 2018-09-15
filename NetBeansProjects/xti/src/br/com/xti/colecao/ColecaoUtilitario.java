package br.com.xti.colecao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ColecaoUtilitario {


	public static void main(String[] args) {
		
	List<String> list = new ArrayList<>();	
	list.add("Guaraná");
	list.add("Uva");
	list.add("Manga");
	list.add("Coco");
	list.add("Açai");
	list.add("Banana");
	System.out.println(list);
	
	Collections.sort(list);// coloca em ordem alfabetica
	System.out.println(list);
	Collections.reverse(list);//INVERTIDA
	System.out.println(list);
	Collections.shuffle(list);//embaralhar a lista
	System.out.println(list);
	Collections.addAll(list,"Cupuaçu","laranja","uva");//adiciona na lista existente
	
	System.out.println(Collections.frequency(list,"Laranja"));
	List<String> list2 = Arrays.asList("Acerola", "Graviola");
	boolean d =Collections.disjoint(list,list2);// retorna os elementos da coleçao list
	
	Collections.sort(list);
	int indice = Collections.binarySearch(list, "Guarana");
	System.out.println(indice);
	System.out.println(list);
	
	Collections.fill(list,"Açai");
	System.out.println(list);
	
	//Coleçao nao pode ser modificada
	Collection <String> constante = 
			Collections.unmodifiableCollection(list);
	
	
	

	}

}
