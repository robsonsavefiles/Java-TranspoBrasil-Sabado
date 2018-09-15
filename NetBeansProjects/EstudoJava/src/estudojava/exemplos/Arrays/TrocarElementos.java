/*
 Este exemplo mostra como trocar as posições
 de dois elementos de uma ArrayList.
*/
package estudojava.exemplos.Arrays;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Robinho
 */
public class TrocarElementos {
   
  public static void main(String[] args){
    // cria uma ArrayList que conterá strings
    ArrayList<String> nomes = new ArrayList<String>();
    
    // adiciona itens na lista
    nomes.add("Carlos");
    nomes.add("Maria");
    nomes.add("Fernanda");
    nomes.add("Osmar");    
	
    // exibe os elementos da ArrayList
    for(int i = 0; i < nomes.size(); i++)
      System.out.println(nomes.get(i));    
 
    // Vamos trocar as posições dos 1º e 3º elementos
    Collections.swap(nomes, 0, 2); 

    // exibe os elementos da ArrayList
    System.out.println();
    for(int i = 0; i < nomes.size(); i++)
      System.out.println(nomes.get(i));

    System.exit(0);
  }
}


