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
public class AddSegundos {
    

  public static void main(String args[]){ 
    Calendar agora = Calendar.getInstance();
    
    // formata e exibe a data e hora atual
    Format formato = new SimpleDateFormat(
      "dd/MM/yyyy - HH:mm:ss");
    System.out.println("Hoje é: " + 
      formato.format(agora.getTime()));

    // vamos adicionar 40 segundos a esta data
    agora.add(Calendar.SECOND, 40);

    // formata e exibe o resultado
    formato = new SimpleDateFormat(
      "dd/MM/yyyy - HH:mm:ss");
    System.out.println("Daqui a 40 segundos será: " +
      formato.format(agora.getTime()));
  } 
}
    

