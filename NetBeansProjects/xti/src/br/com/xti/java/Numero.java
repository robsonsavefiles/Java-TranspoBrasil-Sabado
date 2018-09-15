package br.com.xti.java;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Numero {

	public static void main(String[] args) throws ParseException {
		
	double saldo = 123_456.789;
	NumberFormat f = NumberFormat.getInstance();
	System.out.println(f.format(saldo));//Genericos
	
    f = NumberFormat.getInstance();
	System.out.println(f.format(saldo));//Inteiros
	
	f= NumberFormat.getPercentInstance();//percentual
	System.out.println(f.format(0.25));
	
	f= NumberFormat.getCurrencyInstance();//moeda
	System.out.println(f.format(saldo));
	
	f.setMaximumFractionDigits(3);//casa decimais(definir)
	System.out.println(f.format(saldo));
	
	/*Internacionalização*/
	
	f = NumberFormat.getCurrencyInstance(Locale.US);
	System.out.println(f.format(saldo));
	
	f = NumberFormat.getCurrencyInstance(Locale.FRANCE);
	System.out.println(f.format(saldo));
	
	/*Conversão de Valores*/
	
	f = NumberFormat.getCurrencyInstance();
	//System.out.println(f.parse("R$ 1.100,25"));
	//System.out.println(f.parse("R$ 1.100,25"));
	}

}
