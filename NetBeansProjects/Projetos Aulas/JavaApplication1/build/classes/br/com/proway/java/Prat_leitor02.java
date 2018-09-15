import java.util.Scanner;

class Prat_leitor02{


public static void main(String[] args){

	Scanner teclado = new Scanner(System.in);

	System.out.println("DADOS DO MOTORISTA");

	System.out.print("Nome:");	
	String nome = teclado.nextLine();
       

	System.out.print("Numero da Carteira:");	
	String num= teclado.nextLine();

	
	System.out.print("Categoria:");	
	String cat= teclado.nextLine();

	

	System.out.println("Dados do motorista :"+nome +" "+num+ " "+cat);
 
	teclado.close();



}
}