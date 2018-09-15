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
public class ExcluirTodosElementos {
    public static void main(String[] args){
    // cria uma ArrayList que conterá inteiros
    ArrayList<Integer> valores = new ArrayList<Integer>();
    
    // adiciona itens na lista
    valores.add(34);
    valores.add(12);
    valores.add(8);
    valores.add(23);
    	
    // obtém a quantidade de itens na lista
    int quant = valores.size();
    System.out.println("A lista contém " 
      + quant + " itens");

    // limpa a lista
    valores.clear();

    // obtém a nova quantidade
    quant = valores.size();
    System.out.println("Agora a lista contém " 
      + quant + " itens");

    System.exit(0);
  }
}

