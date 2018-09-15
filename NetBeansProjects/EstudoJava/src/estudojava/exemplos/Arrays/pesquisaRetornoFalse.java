  /*
 Este exemplo mostra como remover a primeira
 ocorrência de um elemento na ArrayList. Se o
 elemento não for encontrado, o retorno será false.
*/
package estudojava.exemplos.Arrays;
import java.util.ArrayList;
/**
 *
 * @author Robinho
 */
public class pesquisaRetornoFalse {
  
  public static void main(String[] args){
    // cria uma ArrayList que conterá strings
    ArrayList<String> nomes = new ArrayList<String>();
    
    // adiciona itens na lista
    nomes.add("Carlos");
    nomes.add("Maria");
    nomes.add("Fernanda");
    nomes.add("Osmar");
    nomes.add("Maria");    
	
    // Vamos remover o elemento "Osmar"
    if(nomes.remove("Osmar"))
      System.out.println("O elemento foi removido com sucesso!"); 
    else
      System.out.println("O elemento não foi encontrado!"); 

    System.exit(0);
  }
}

