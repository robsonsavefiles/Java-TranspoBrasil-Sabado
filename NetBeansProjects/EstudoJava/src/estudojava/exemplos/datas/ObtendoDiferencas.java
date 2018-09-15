/*
 * Como obter a diferença de semanas, dias, horas, minutos e segundos entre dois objetos
Date.
O trecho de código abaixo mostra como obter a diferença de semanas, dias, horas,
minutos e segundos entre dois objetos Date. Estude-o atentamente. Esta é uma técnica 
muito útil para programadores que lidam com cálculos de datas em suas aplicações:

 */
package estudojava.exemplos.datas;
import java.util.*;
import java.text.*;
/**
 *
 * @author Robinho
 */
public class ObtendoDiferencas {
   
  public static void main(String args[]){ 
    try{
      // constrói a primeira data
      DateFormat fm = new SimpleDateFormat(
        "dd/MM/yyyy HH:mm:ss");
      Date data1 = (Date)fm.parse("20/12/2008 16:20:12");

      // constrói a segunda data
      fm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      Date data2 = (Date)fm.parse("30/12/2008 21:30:15");

      // vamos obter a diferença em semanas, dias, horas,
      // minutos e segundos
      long segundos = (data2.getTime() - 
        data1.getTime()) / 1000;
      int semanas = (int)Math.floor(segundos / 604800);
      segundos -= semanas * 604800;
      int dias = (int)Math.floor(segundos / 86400);
      segundos -= dias * 86400;
      int horas = (int)Math.floor(segundos / 3600);
      segundos -= horas * 3600;
      int minutos = (int)Math.floor(segundos / 60);
      segundos -= minutos * 60;

      // exibe o resultado
      System.out.println("As duas datas tem " +
        semanas + " semanas, " + dias + " dias, " + 
        horas + " horas, " + minutos + " minutos e " +
        segundos + " segundos de diferença");
    }
    catch(ParseException e){
      e.printStackTrace();
    }
  } 
}


