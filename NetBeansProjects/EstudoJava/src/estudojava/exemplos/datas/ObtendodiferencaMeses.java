/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudojava.exemplos.datas;
   import java.util.*;
import java.text.*;
/**
 *
 * @author Robinho
 */
public class ObtendodiferencaMeses {
   
  public static void main(String args[]){ 
    try{
      // constrói a primeira data
      DateFormat fm = new SimpleDateFormat(
        "dd/MM/yyyy");
      Date data1 = (Date)fm.parse("20/10/2008");

      // constrói a segunda data
      fm = new SimpleDateFormat("dd/MM/yyyy");
      Date data2 = (Date)fm.parse("30/12/2008");

      // vamos obter a diferença de meses
      long segundos = (data2.getTime() - 
        data1.getTime()) / 1000;
      int meses = (int)Math.floor(segundos / 2592000);
      segundos -= meses * 2592000;
      int dias = (int)Math.floor(segundos / 86400);
      
      // exibe o resultado
      System.out.println("As duas datas tem " +
        meses + " meses e " + dias + 
        " dias de diferença");
    }
    catch(ParseException e){
      e.printStackTrace();
    }
  } 
}
    

