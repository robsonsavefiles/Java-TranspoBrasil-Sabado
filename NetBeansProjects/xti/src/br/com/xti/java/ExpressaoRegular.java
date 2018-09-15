/*Regular Expression(Expressao Regular)
 *Metodos java
 *Modificadores 
 *Metacaracteres
 *Quantificadores
 *Agrupadores
 *
*/
package br.com.xti.java;
import java.util.regex.PatternSyntaxException;
import java.util.regex.Matcher;



import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

public class ExpressaoRegular {

	public static void main(String[] args) {
		
//	String padrao = "Java";
//	String texto = "Java";
	boolean b = "Java".matches("Java");	
	
	
	//Modificadores
	//(?i), Ignora maiuscula e minuscula
	//(?x), Comentarios
	//(?x),Multilinhas
	//(?s),Dottal
	
	
	/*METACARACTERES
	 * .qualquer caracter      
	 * \d digitos 			[0-9]
	 * \D nao é digitos		[^0-9]
	 * \s espaços			[\t\n\x0B\f\r]
	 * \S não é espaços		[^\s]
	 * \w letra				[a-zA-Z_0-9]
	 * \nao é letra
	*/
	
	b= "Java".matches("(?i)java");
	
	b= "".matches(".");
	b= "2".matches("\\d");
	b= "a".matches("\\w");
	b= "#".matches("\\w");
	b= " ".matches("\\s");
	System.out.println(b);
	
	b= "Pi".matches("..");
	b= "Pie".matches("...");
	b= "21".matches("\\d\\d");
	b= "222".matches("\\d\\d\\d");
	
	//Validaçao de CEP
	String cep = "\\d\\d\\d\\d\\d-\\d\\d\\d";
	b = "11435-060".matches(cep);
	System.out.println(b);
	/*Quantificadores
	 *	X{n}	X,exatamente n vezes
	 *	X{n,} 	X,pelo menos n vezes
	 *	X{n,m}	X,pelo menos n mas nao sai do que m vezes
	 *	X?		X,0 ou 1 vez
	 *	X*		X,0 ou +vezes
	 *	X+		X,1 ou +vezes
	*/	
	
	b = "21".matches("\\d{2}");
	b = "123".matches("\\d{2,}");
	b = "123456".matches("\\d{2,5}");
	
	b = "".matches(".?");//0 ou 1
	b = "ab".matches(".*");//0 ou +
	b = "123".matches(".+");//1 ou +
	
	b = "11435060".matches("\\d{5}-\\{3}");
	System.out.println(b);
	b ="03/03/1987".matches("\\d{2}/\\d{2}/\\d{4}");
	System.out.println(b);
	
	//METACARACTER DE FRONTEIRA
    //^ Inicia
	//$ finaliza
	//| ou */
	
	b = "Pier21".matches("^Pier.*");
	b = "Pier21".matches(".*21$");
	b = "tem java aqui".matches(".*java.*");
	b = "tem java aqui".matches("^tem.*aqui$");
	b = "sim".matches("sim|não");
	System.out.println(b);
	
	//AGRUPADORES(conjunto de caracteres)
	//	[...] Agrupamento(abc)
	//	[a-z] Alcance
	// 	[a-e][i-u]Uniao 
	//	[a-z&&[aeiou]] Interseção
	//	[^abc] Exceção
	//  [a-z&&[^m-p]] Subtraçao
	//  \x	Fuga literal
	
	b = "x".matches("[a-z]");
	b = "3".matches("[0-9]");
	b = "true".matches("[tT]true");//true True
	b = "True".matches("[tT]true|[yY]es");
	b ="Robson".matches("[A-Z][a-z]*");
	b = "olho".matches("[^abc]lho");
	b = "crau".matches("cr[ae]u");
	System.out.println(b);
	
	//Validaçao de email 
	
	b = "rh@xti.com".matches("\\w+@\\w+\\.\\w{2,3}");;
	System.out.println(b);
	
	String doce = "Qual é o Doce mais doCE que O doce?";
//	Matcher matcher = Pattern.compile("(?i)doce").matcher(doce);
//	while(matcher.find()){
//		System.out.println(matcher.group());
//		
//	}
	
	//Substituição
	String r = doce.replaceAll("(?i)doce","DOCINHO");
	System.out.println(r);
	
	String rato = "O Rato roeu a roupa do rei de roma";
	r = rato.replaceAll("r[aeiou]", "XX");
	System.out.println(r);
	
	r = "Tabular este texto".replaceAll("\\s", "\t");
	System.out.println(r);
	
	String url ="www.xti.com.br/clientes-2011.html";
				//http://www.xti.com.br/2011/clientes.jsp//Objetivo
	String re = "www.xti.com.br/\\w{2,}-\\d{4}.html";
	b = url.matches(re);
	System.out.println(b);
	
	re = "(www.xti.com.br)/(\\w{2,})-(\\d{4}).html";
	
	r= url.replaceAll(re,"http://$1/$3/$2.jsp");
	System.out.println(r);
	System.out.println(url);
	
	}
}
