import java.util.Scanner;

class Exer02_leitor{


public static void main(String[] args){

	Scanner teclado = new Scanner(System.in);
	System.out.print("Informe sua idade:");	
	String age = teclado.nextLine();
	int idade = Integer.parseInt(age);
	int newage = idade + 20;
	System.out.println("A idade informada foi:" +newage);



}
}