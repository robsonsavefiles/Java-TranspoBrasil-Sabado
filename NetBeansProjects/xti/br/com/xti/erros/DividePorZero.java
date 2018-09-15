package br.com.xti.erros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DividePorZero {
	
	
	public static void dividir(Scanner s)
		throws InputMismatchException, ArithmeticException
		
	{
		System.out.print("numero:");
		int a = s.nextInt();
		System.out.print("Divisor:");
		int b = s.nextInt();

		// InputMismatchException XTI
		// ArithmeticExeception 0

		System.out.println(a / b);
		
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		boolean continua = true;
		do {
			try {
				 dividir(s);
			     continua = false;
			}

			catch (InputMismatchException e1) {
				System.err.println("Numeros devem ser inteiros");
				e1.printStackTrace();
				e1.getStackTrace();
				s.nextLine();//descarta e libera novamente
			}
			finally{
				System.err.println("Finally Executado");
			}
			
		} while (continua);

	}
}
