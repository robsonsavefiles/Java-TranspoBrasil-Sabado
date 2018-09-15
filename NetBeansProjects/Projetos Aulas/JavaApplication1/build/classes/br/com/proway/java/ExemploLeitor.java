

import java.util.Scanner;

class ExemploLeitor{

public static void main(String[] args){
		
	Scanner teclado = new Scanner(System.in);// Criando um objeito Teclado
	System.out.print("Digite seu Nome:");
	String nome = teclado.nextLine();//lendo o que foi digitado, nextLine- retorna o que foi digitado
	System.out.println("Nome Informado foi :"+nome);
	System.out.print("Informe sua Idade:");
	String valor = teclado.nextLine();
	int idade = Integer.parseInt(valor);
	int idade = Double.parseDouble(valor);
	System.out.println("idade + 10 = "+(idade+10));


	teclado.close();



	}
}
