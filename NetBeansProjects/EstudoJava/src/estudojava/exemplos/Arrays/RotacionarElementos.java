 /*
 Este exemplo mostra como rotacionar os 
 elementos de uma ArrayList. O método usado é:

 void rotate(List<?> list, int distance)
          
 Este método faz com que um elemento na posição i
 seja movido para a posição (distance + i) % list.size().

 Se quiser inverter a ordem da rotação, forneça um valor
 negativo para o argumento distance.
*/

package estudojava.exemplos.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Robinho
 */
public class RotacionarElementos {
 
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
 
    // Vamos rotacionar os elementos uma posição
    Collections.rotate(nomes, 1); 

    // exibe os elementos da ArrayList
    System.out.println();
    for(int i = 0; i < nomes.size(); i++)
      System.out.println(nomes.get(i));

    System.exit(0);
  }
}

