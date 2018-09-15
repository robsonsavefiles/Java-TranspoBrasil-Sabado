/*
 * Como excluir todos os elementos de uma ArrayList exceto aqueles contidos em 
   outra ArrayList ou coleção
 */
package estudojava.exemplos.Arrays;

import java.util.ArrayList;

/**
 *
 * @author Robinho
 */
public class RemovendoElementos2 {
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

