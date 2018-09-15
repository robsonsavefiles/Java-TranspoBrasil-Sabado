package br.com.xti.logica;
//*Aula 12 Entrada Grafica com JOptionPane

import javax.swing.JOptionPane;


public class Entrada1 {

	public static void main(String[] args){

		String nome = JOptionPane.showInputDialog("Qual o seu Nome");
		JOptionPane.showMessageDialog(null, nome);
		
		System.out.println(nome);
		
		
		
		
	}


}