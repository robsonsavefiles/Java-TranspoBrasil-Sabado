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
public class Exemplo1 {
  public static void main(String[] args){
    // cria uma ArrayList que conterá strings
    ArrayList<String> nomes = new ArrayList<String>();

    // cria uma segunda ArrayList que conterá mais strings
    ArrayList<String> nomes2 = new ArrayList<String>();
    
    // adiciona itens na primeira lista
    nomes.add("Carlos");
    nomes.add("Maria");
    nomes.add("Fernanda");
    
    // adiciona itens na segunda lista
    nomes2.add("Osmar");
    nomes2.add("Zacarias");    
	
    // vamos adicionar os elementos da segunda lista
    // no final da primeira lista
    nomes.addAll(nomes2);

    // vamos exibir o resultado
    for(int i = 0; i < nomes.size(); i++){
      System.out.println(nomes.get(i));
    } 

    System.exit(0);
  }
}

   

