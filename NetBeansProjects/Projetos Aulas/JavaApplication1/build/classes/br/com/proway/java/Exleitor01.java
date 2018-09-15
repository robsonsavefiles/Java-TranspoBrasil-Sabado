import java.util.Scanner;

class Exleitor01{

public static void main(String[] args){
	Scanner teclado = new Scanner(System.in);
	System.out.print("Informe sua idade:");	
	String age = teclado.nextLine();
	int idade = Integer.parseInt(age);
	System.out.println("A idade informada foi:" +age);


	}
}