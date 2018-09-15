/*
 Este exemplo mostra como remover uma faixa
 de elementos de uma ArrayList.

 A técnica usada substitui o método removeRange. 
*/
package estudojava.exemplos.Arrays;

import java.util.ArrayList;
/**
 *
 * @author Robinho
 */
public class RemovendoUmaFaixaDeElementos {
    
  public static void main(String[] args){
    // cria uma ArrayList que conterá strings
    ArrayList<String> nomes = new ArrayList<String>();
    
    // adiciona itens na lista
    nomes.add("Carlos");
    nomes.add("Maria");
    nomes.add("Fernanda");
    nomes.add("Osmar");
    nomes.add("Maria");    
	
    // exibe os elementos da ArrayList
    for(int i = 0; i < nomes.size(); i++)
      System.out.println(nomes.get(i));    
 
    // Vamos remover os elementos 2, 3 e 4
    for(int i = 1; i < 4; i++)
      nomes.remove(1);

    // exibe os elementos da ArrayList
    System.out.println();
    for(int i = 0; i < nomes.size(); i++)
      System.out.println(nomes.get(i));

    System.exit(0);
  }
}



