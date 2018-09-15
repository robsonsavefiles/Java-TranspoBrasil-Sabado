package br.com.xti.colecao;

import java.util.ArrayList;
import java.util.List;

public class ColecaoList {

	public static void main(String[] args) {
		
	List<String> list = new ArrayList();
	list.add("futebol");
	list.add("Basquete");
	list.add("Tenis");
	list.add("Volei");
	list.add("Natação");
	list.add("Boxe");
	list.add("Hockey");
	list.add("Futebol");
	
	System.out.println(list);
	
	for(int i =0; i<list.size();i++){
		String letra = list.get(i);
		list.set(i,letra.toUpperCase());
		
	}
		System.out.println(list);
		System.out.println(list.indexOf("BOXE"));
		System.out.println(list.subList(2, 4));
		list.subList(2, 4).clear();
		System.out.println(list);
		
		
		
	}
	
}
