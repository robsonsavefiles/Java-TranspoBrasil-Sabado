import java.util.Scanner;

class Exer03_Media{


public static void main(String[] args){

	Scanner teclado = new Scanner(System.in);

	System.out.print("Informe a primeira nota:");	
	String n1= teclado.nextLine();
        double nota1 = Double.parseDouble(n1);

	System.out.print("Informe a segunda nota:");	
	String n2= teclado.nextLine();
	double nota2 = Double.parseDouble(n2);

	System.out.print("Informe a terceira nota:");	
	String n3= teclado.nextLine();
	double nota3 = Double.parseDouble(n3);

	double media = (nota1+nota2+nota3)/3;

	System.out.println("A sua Media foi:" + media);



}
}