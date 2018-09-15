//StringBuffer
//*String : nao munda;
//*StringBuffer  sim;
//String x = "a";
	  // x = "b";
	  // x = "c";

package br.com.xti.java;

public class StringMutavel {

	private static StringBuilder append;

	public static void main(String[] args) {
		StringBuffer s0= new StringBuffer();
		StringBuilder s1 = new StringBuilder("JAVA");
		
		s1.toString();
		s1.length();
	    System.out.println(s1.length());
		s1.capacity();//capacidade de armazenamento sem alocar mais memoria 
     	System.out.println(s1.capacity());
    	System.out.println(s1);
		s1.reverse();//string aocontrario 
	
		s1.append(s1);
		char[] c = {'c','o','m'};
		s1.append(c).append("Textos.");
		System.out.println(s1);
		
		String s = "Oi"+"como"+"vai você";
		String sb = new StringBuilder("oi")
		.append("como").append("vai você?").toString();
		
		//metodo para remover conteudo
		String url = new StringBuilder("www.xti.com.br").delete(0, 4).toString();
		System.out.println(url);
	
	}

	
}
