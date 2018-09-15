/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudojava.exemplos.Arrays;

import java.util.ArrayList;

/**
 *
 * @author Robinho
 */
public class PesquisandoUmElemento {
    public static void main(String[] args){
    // cria uma ArrayList que conterá inteiros
    ArrayList<Integer> valores = new ArrayList<Integer>();
    
    // adiciona itens na lista
    valores.add(34);
    valores.add(12);
    valores.add(8);
    valores.add(23);
    	
    // Verifica se um determinado 
    if(valores.contains(12)){
      System.out.println("O valor pesquisado foi encontrado.");
    }
    else{
      System.out.println("O valor pesquisado não foi encontrado.");
    } 

    System.exit(0);
  }
}
