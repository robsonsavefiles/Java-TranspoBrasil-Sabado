package br.com.xti.poo;

public class Matematica {
	
/**@return a raiz quadrada de Pell´s
 * 	
 */
	int raiz(int numero){
	int raiz = 0, impar = 1;
	while(numero >= impar){
		numero -= impar;//1,3,5,7,9;
		impar += 2;// proximo numero impar
		++ raiz;
		
	
	
	
	}
		
		return raiz;
		
		
	}


	int maior(int um, int dois){
		if (um > dois){
			return um;
		}else{
			return dois;
		}
	
	}
	double soma(double um, double dois){
		double s = um + dois;
		return s;

	}
	double media(int x, int y){
		System.out.print("media(int x,int y)");// assinatura
		return (x + y) /2;
	}
	double media(String x, String y){
		System.out.println("media(String x, String y)");
		int ix = Integer.parseInt(x);
		int iy = Integer.parseInt(y);
		return (ix + iy)/2;
	}
	double media(double... numeros){
		System.out.println("media(double... numeros)");
		return this.soma(numeros)/numeros.length;
		
		
	}


	private int soma(double[] numeros) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
