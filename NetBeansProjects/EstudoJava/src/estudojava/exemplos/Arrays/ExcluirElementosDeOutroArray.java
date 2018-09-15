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
public class ExcluirElementosDeOutroArray {
    public static void main(String[] args){
    // cria uma ArrayList que conterá strings
    ArrayList<String> nomes = new ArrayList<String>();

    // cria uma segunda ArrayList que conterá mais strings
    ArrayList<String> nomes2 = new ArrayList<String>();
    
    // adiciona itens na primeira lista
    nomes.add("Carlos");
    nomes.add("Maria");
    nomes.add("Fernanda");
    nomes.add("Osmar");
    nomes.add("Zacarias");    

    // adiciona itens na segunda lista
    nomes2.add("Maria");
    nomes2.add("Zacarias");    
	
    // vamos remover da primeira lista todos os elementos
    // EXCETO aqueles contidos na segunda lista
    nomes.retainAll(nomes2);

    // vamos exibir o resultado
    for(int i = 0; i < nomes.size(); i++){
      System.out.println(nomes.get(i));
    } 

    System.exit(0);
  }
}
    

