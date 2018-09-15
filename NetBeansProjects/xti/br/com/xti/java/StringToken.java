//tokens - sao os pedaços dos dados;
//delimitadores - sao as expressoes que separam os tokens 

package br.com.xti.java;

public class StringToken {

	public static void main(String[] args) {
		
	String s = "XHTML;CSS;JavaScript;JQuery;Java";//Tokens
	s = "Venha trabalhar  na XTI";
	String[] tokens = s.split("a");//delimitador
	for (String token: tokens){
		System.out.println(" ");
		System.out.println(token);
	}
	}

}
