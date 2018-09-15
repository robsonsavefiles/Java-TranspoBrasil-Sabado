/*
 *Obtendo a diferença em dias entre dois objetos Date
 */
package estudojava.exemplos.datas;
import java.util.*;
import java.text.*;

/**
 *
 * @author Robinho
 */
public class ObtendoDiferenca {
   
  public static void main(String args[]){ 
    try{
      // constrói a primeira data
      DateFormat fm = new 
        SimpleDateFormat("dd/MM/yyyy");
      Date data1 = (Date)fm.parse("20/12/2008");

      // constrói a segunda data
      fm = new SimpleDateFormat("dd/MM/yyyy");
      Date data2 = (Date)fm.parse("25/01/2009");

      // vamos obter a diferença em dias
      long diff = data2.getTime() - 
        data1.getTime();

      // exibe o resultado
      System.out.println("Diferença em dias = "
        + diff / (1000 * 60 * 60 * 24));
    }
    catch(ParseException e){
      e.printStackTrace();
    }
  } 
}
    

