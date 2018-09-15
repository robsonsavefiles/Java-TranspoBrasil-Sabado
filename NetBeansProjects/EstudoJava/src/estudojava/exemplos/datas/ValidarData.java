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
public class ValidarData {
  
  public static void main(String args[]){ 
    // vamos validar a data "35/10/2008"
    String dataString = "35/10/2008";     
    
    try{
      Calendar data = Calendar.getInstance();
      SimpleDateFormat formato = new 
        SimpleDateFormat("dd/MM/yyyy");
      formato.setLenient(false);
      data.setTime(formato.parse(dataString));
      System.out.println(formato.format(data.getTime()));
    } 
    catch(ParseException e){
      System.out.println("Data Inválida.");
    }
  } 
}
    

