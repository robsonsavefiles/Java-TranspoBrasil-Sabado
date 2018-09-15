package br.com.cursojava.aula01;

import java.util.Scanner;

/*crie um programa que armazene 3 notas com valores 10,9 e 8 em seguida, calcule e apresente o resultado da media das notas*/
public class Notas {
	
	private static Scanner teclado;

	public static void main(String[] args){
		
	        teclado = new Scanner(System.in);
	        double[] notas = new double[3];
	        for (int i = 0; i < notas.length; i++) {
	            System.out.println("Informe a nota " + (i + 1) + " do aluno:");
	            try {
	                notas[i] = Double.parseDouble(teclado.nextLine());
	                if (notas[i] < 0 || notas[i] > 10) {
	                    throw new Exception();
	                }
	            } catch (Exception e) {
	                System.out.println("Nota invalida.");
	                i--;
	            }
	        }
	        double media = (notas[0] + notas[1] + notas[2]) / 3;
	        if (media >= 6) {
	            System.out.println("Aprovado com média " + media + ".");
	        } else {
	            System.out.println("Reprovado com média " + media + ".");
	        }
	    }
	}



