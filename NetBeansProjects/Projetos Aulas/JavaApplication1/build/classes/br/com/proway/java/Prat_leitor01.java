import java.util.Scanner;

class Prat_leitor01{


public static void main(String[] args){

	Scanner teclado = new Scanner(System.in);

	System.out.println("DADOS CADASTRAIS");

	System.out.print("Rua:");	
	String r = teclado.nextLine();
       

	
	System.out.print("Numero:");	
	String n= teclado.nextLine();
	

	System.out.print("Complemento:");	
	String c= teclado.nextLine();
	
	System.out.print("Bairro:");
	String b = teclado.nextLine();
	
	
	System.out.print("Cidade:");
	String city = teclado.nextLine();
	

	System.out.print("Estado:");
	String es = teclado.nextLine();
	
	
	System.out.print("CEP:");
	String ce = teclado.nextLine();
	


	System.out.println("OS DADOS INFORMADOS FORMA:"+r+" "+n+" "+c+" "+b+" "+city+" "+es+" "+ce);
 
	teclado.close();



}
}