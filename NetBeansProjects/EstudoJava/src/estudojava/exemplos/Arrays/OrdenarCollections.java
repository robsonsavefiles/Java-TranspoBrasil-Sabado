 /*
 Este exemplo mostra como ordenar os elementos
 de uma ArrayList.

 A ordenação é aplicada a elementos do tipo
 String. Lembre-se que os elementos a serem ordenados
 precisam implementar a interface Comparable.

 O exemplo usa também Collections.reverseOrder() para
 ordenar os elementos em ordem descendente.
*/
package estudojava.exemplos.Arrays;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Robinho
 */
public class OrdenarCollections {
   
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
 
    // Vamos ordenar os elementos
    Collections.sort(nomes, Collections.reverseOrder()); 

    // exibe os elementos da ArrayList
    System.out.println();
    for(int i = 0; i < nomes.size(); i++)
      System.out.println(nomes.get(i));

    System.exit(0);
  }
}

    

