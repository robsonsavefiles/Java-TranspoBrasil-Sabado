package br.com.xti.java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datas2 {

	public static void main(String[] args) throws ParseException {
		
	Calendar c = Calendar.getInstance();
	c.set(1980,Calendar.FEBRUARY,12);
    Date date = c.getTime();
    System.out.println(date);
	
    /*Formataçao de Datas*/
	DateFormat f = DateFormat.getDateInstance();//formata data completa
	System.out.println(f.format(date));
	 
	/*Formataçao de Horas */
     f = DateFormat.getTimeInstance();
     System.out.println(f.format(date));
     
     /*Formataçao de data e Horas */
     f = DateFormat.getDateTimeInstance();
     System.out.println(f.format(date));
     
     /*Estilos*/
     f = DateFormat.getDateInstance(DateFormat.FULL);//formato completo
     System.out.println(f.format(date));
     f = DateFormat.getDateInstance(DateFormat.LONG);
     System.out.println(f.format(date));
     f = DateFormat.getDateInstance(DateFormat.MEDIUM);
     System.out.println(f.format(date));
     f = DateFormat.getDateInstance(DateFormat.SHORT);
     System.out.println(f.format(date));
     
     /*Converter uma String em uma data*/
     
     Date data2 = f.parse("12/02/1980");
     System.out.println(data2);
     
     /*SimpleDateFormat*/
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
     System.out.println(sdf.format(date));
     System.out.println(sdf.parse("10/10/2010"));
     
		
	}

}
