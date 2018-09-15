import java.util.Scanner;

class Prat_leitor03{


public static void main(String[] args){

	Scanner teclado = new Scanner(System.in);

	
	System.out.print("Numero 1:");	
	String num1 = teclado.nextLine();
	int n1 = Integer.parseInt(num1);

	System.out.print("Numero 2:");	
	String num2 = teclado.nextLine();
	int n2 = Integer.parseInt(num2);

	System.out.print("Numero 3:");	
	String num3 = teclado.nextLine();
	int n3 = Integer.parseInt(num3);

	System.out.print("Numero 4:");
	String num4 = teclado.nextLine();
	int n4 = Integer.parseInt(num4);
	
	System.out.print("Numero 5:");	
	String num5 = teclado.nextLine();
	int n5 = Integer.parseInt(num5);
       
	
	System.out.println("O soma de todos os numeros:"+(n1+n2+n3+n4+n5));

	System.out.println("A multiplicacao de todos:"+(n1*n2*n3*n4*n5));
	
	System.out.println("O primeiro Numero:"+(n1 * 5));
	System.out.println("O primeiro Numero:"+(n2 * 3));
	System.out.println("O primeiro Numero:"+(n3 * 9));
	System.out.println("O primeiro Numero:"+(n4 * 7));
	System.out.println("O primeiro Numero:"+(n5 * 11));
	
	

	teclado.close();



}
}