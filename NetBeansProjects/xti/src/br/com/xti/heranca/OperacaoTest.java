package br.com.xti.heranca;

public class OperacaoTest {

	
	public static void calcule(OperacaoMatematica o, double x, double y){
		System.out.println(o.calcular(x, y));
	}
	
	public static void calculeSemPolimorfimo(String o, double x , double y){
		if(o.equals("Soma")){
		
		System.out.println(x + y);
        }else if(o.equals("Multiplicacao")){
			System.out.println(x * y);
		}
	}
	
	public static void main(String[] args) {
		
	calcule(new Soma(),5,5);
	calcule(new Multiplicacao(),4,6);
	
	
	}

}
