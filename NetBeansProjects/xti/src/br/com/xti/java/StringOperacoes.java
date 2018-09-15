package br.com.xti.java;

public class StringOperacoes {

	public static void main(String[] args) {
	
	String s1 = "Write Once";
	String S2 = s1 + "Run Anywhere";
	String s3 = new String("Java Virtual Machine");
	char[] array = {'J','a','v','a'};
	String s4 = new String(array);
	
	//OPERAÇOES
	int tamanho = s1.length();
	char letra = s1.charAt(0);// 0 a length()-1
	String texto = s1.toString();//retorna a propria string
	
	//LOCALIZAÇÃO
	
	int posicao = s3.indexOf("Virtual");//encontra a primeir o ocorrencia
	int ultima = s3.lastIndexOf('a');
	boolean vazia = s3.isEmpty();// retorna true e false
	System.out.println(posicao);
	
	//COMPARAÇAO
	String xti = "XTI";
	xti.equals("xti");
	boolean x = xti.equalsIgnoreCase("xti");
	boolean x1 = xti.startsWith("XT");
	boolean x2 = xti.endsWith("TI");
	
	System.out.println(x);
	System.out.println(x1);
	System.out.println(x2);
	
	//int c = "amor".compareTo("bola");//-1
	int c = "amor".compareTo("amor");//
	int d = "123".compareTo("234");
	System.out.println(c);
	System.out.println(d);
	
	String so = "Olhe, Olhe";
	so.regionMatches(true,6, "olhe", 0, 4);//compara uma string dentro da outra
	
	//extraçao de dados da string
	
	String l = "O brasil é lindo ";
	String sl = l.substring(11);//pega da posicao 11
	System.out.println(sl);
	
	String ll = "O brasil é lindo ";
	String sll = ll.substring(11);
	sll = ll.substring(2,8);// pega da posicao 2 ate 8
	System.out.println(sll);
	
	//Concatenar
	
	s1 = l.concat("que maravilha");
	System.out.println(s1);
	
	sl = l.replace('s','z');//troca de caracter
	sl = l.replaceFirst(" ","X");//Troca a primeira letra
	sl = l.toUpperCase();//maiuscula
	sl = l.toLowerCase();//minusculo
	
	//Limpar os caracteres em branco antes e depois
	System.out.println("     espaços   ".trim());
	
	 
	
	}

}
