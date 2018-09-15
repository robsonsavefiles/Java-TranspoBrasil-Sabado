package br.com.xti.colecao;

import java.util.LinkedList;
import java.util.Queue;

public class ColecaoQueue {

	public static void main(String[] args) {
		
		//FIFO- First in First Out
		Queue<String> fila = new LinkedList<>();
		fila.add("Ricardo");
		fila.add("Sandra");
		fila.offer("Beatriz");//adiciona ao final da fila
		System.out.println(fila);
		
		
		System.out.println(fila.peek());//o proximo da fila
		System.out.println(fila.poll());//remove o elemento do inicio da fila
		System.out.println(fila);
		
		//Outros metodos disponiveis em LinkedList
		
		LinkedList<String> f = (LinkedList<String>) fila;//cast
		f.addFirst("Caio");//Coloca no inicio da fila
		f.addLast("Juliana");//coloco no fim da fila
		System.out.println(f);
		
		System.out.println(f.peekFirst());//pega a primeira pessoa da fila
		System.out.println(f.peekLast());//pega ultima pessoa da fila
		
		f.pollFirst();//remove 
		f.pollLast();//remove

	}

}
