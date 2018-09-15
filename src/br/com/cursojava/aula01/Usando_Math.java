package br.com.cursojava.aula01;

public class Usando_Math {
	public static void main(String[] args) {
		int a = 3;
		int b = 7 ;
		int c = 25;
		int d = 10;
		
		int min = Math.min(a, b);
		    min= Math.min(min,c);
		    min= Math.min(min,d);
		System.out.println("O menor numero é :"+ min); 
		
		int max = Math.max(a,b);
			max = Math.max(max,c);
			max = Math.max(max, d);
		System.out.println("O maior numero é :"+ max); 
		}

}
