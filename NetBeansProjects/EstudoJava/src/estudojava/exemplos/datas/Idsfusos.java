/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudojava.exemplos.datas;
import java.util.*;
/**
 *
 * @author Robinho
 */
public class Idsfusos {
    
  public static void main(String args[]){ 
    // obtém todos os IDs de fusos horários 
    // disponíveis na classe TimeZone
    String fusos[] = TimeZone.getAvailableIDs();

    for(int i = 0; i < fusos.length; i++){
      System.out.println(fusos[i]);
    } 
  } 
}