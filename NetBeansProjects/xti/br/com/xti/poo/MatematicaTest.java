package br.com.xti.poo;

public class MatematicaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Matematica  m = new Matematica();
		
		System.out.print(m.media(5,3));
		System.out.print(m.media(5,3,34,54,43));// pode receber varior argumentos
		
		System.out.print(m.media("50","30"));
		
		
		//int maior = m.maior(10,20);		
		//System.out.println(maior);
		//double so = m.soma(10,20);
		//System.out.println(so);
		
		//int par = m.maior(2,4);
		//int impar = m.maior(3,5);
		//double so = m.soma(par,impar);
	
		//double so = m.soma(m.maior(2,4),m.maior(3,5));
		
		//System.out.println(so);
		
		
		
		int raiz = m.raiz(27);
		System.out.println(raiz);
		
		System.out.println(Math.sqrt(276));
	}

}
