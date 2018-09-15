/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudojava.exemplos.Arrays;

import java.util.ArrayList;


public class ArrayDeStrings {
    

  public static void main(String[] args){
    // Este exemplo usa Generics
    // cria uma ArrayList que conterá strings
    ArrayList<String> pessoas = new ArrayList<String>();
    
    // adiciona itens na lista
    pessoas.add("Alberto");
    pessoas.add("Victor");
    pessoas.add("João");
    	
    // exibe os itens da lista	
    for(int i = 0; i < pessoas.size(); i++){
      System.out.println(pessoas.get(i));
    }  

    System.exit(0);
  }



}