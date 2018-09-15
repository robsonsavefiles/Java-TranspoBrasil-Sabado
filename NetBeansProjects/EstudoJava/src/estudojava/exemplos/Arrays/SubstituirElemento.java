  /*
 Este exemplo mostra como substituir um elemento
 em uma determinada posição da ArrayList 
*/
package estudojava.exemplos.Arrays;

import java.util.ArrayList;
/**
 *
 * @author Robinho
 */
public class SubstituirElemento {
 
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
 
    // Vamos substituir o 3º elemento
    nomes.set(2, "Marcos"); 

    // exibe os elementos da ArrayList
    System.out.println();
    for(int i = 0; i < nomes.size(); i++)
      System.out.println(nomes.get(i));

    System.exit(0);
  }
}

