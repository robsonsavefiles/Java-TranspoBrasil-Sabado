package br.com.xti.logica;
/*AULA 10 Wrapper Classes, Envolucros de tipos Primitivos.
*/
public class Variavel10{
	
	public static void main(String args[]){

	Double preco = new Double("12.45");
	double d = preco.doubleValue();
	int i = preco.intValue();
	byte b = preco.byteValue();
	
	char sexo = 'M';
	//boolean casado = new boolean ("true");
	
	// CONVERSÃO ESTATICA
	double d1 = Double.parseDouble("123.45");
	int i1 = Integer.parseInt("123");
	float f1 = Float.parseFloat("3.14F");
	
	int i2 = Integer.valueOf("101011", 2);
	System.out.println(i2);
	
		
	}


}
