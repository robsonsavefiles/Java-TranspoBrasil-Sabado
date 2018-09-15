package br.com.xti.logica;
//*Aula 19 -Desafio do calculo do IMC

//Calculo Do IMC - Indice de massa Corporal

// IMC = PESO / (ALTURA)2
// <20   : Abaixo do peso
// 20-25 : Peso Ideal
// 30-35 : Obesidade Moderada
// 35-40 : Obesidade  Severa
// 40-50 : Obesidade Morbida
//  >50  : Super-Obesidade

import javax.swing.JOptionPane;


public class IMC {

	public static void main(String[] args){
		
		String peso = JOptionPane.showInputDialog("Qual seu Peso");
		String altura = JOptionPane.showInputDialog("Qual a sua Altura"); 
		
		double pesoEmQuilogramas = Double.parseDouble(peso);// converter string em double
		double alturaEmMetros = Double.parseDouble(altura);
		double imc = pesoEmQuilogramas / (alturaEmMetros * alturaEmMetros);
		
		String msg = (imc >= 20 && imc<=25) ? "Peso Ideal" : "Fora do Peso Ideal";
		msg = "IMC = " + imc + "\n" + msg;
		
		
		
	JOptionPane.showMessageDialog(null,msg);
	System.out.println("IMC = " + imc );
	System.out.println(msg);

	}


}