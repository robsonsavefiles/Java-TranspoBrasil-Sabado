package br.com.cursojava.aula01;

public class OperadoresMatematicos {
	
	public static void main(String[] args){

		int numero1 = 10;
		int numero2 = 2;
		int numero3 = 3;
		double numero4 = 3;
		
		System.out.printf("%d + %d = %d \n",numero1, numero2,numero1+numero2);
		System.out.printf("%d - %d = %d \n",numero1, numero2,numero1-numero2);
		System.out.printf("%d * %d = %d \n",numero1, numero3,numero1*numero3);
		System.out.printf("%d / %d = %d \n",numero1, numero3,numero1 / numero3);
		System.out.printf("%d / %f = %f \n",numero1, numero3,numero1 / numero4);
		System.out.printf(" --  %d = %d \n",numero1,--numero1);

	}

}
