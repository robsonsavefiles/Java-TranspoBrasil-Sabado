
package estudojava.exemplos.Arrays;
// Como inserir um item em uma determinada posição da ArrayList 
import java.util.ArrayList;

/**
 *
 * @author Robinho
 */
public class InserirIten {
      public static void main(String[] args){
    // cria uma ArrayList que conterá strings
    ArrayList<String> pessoas = new ArrayList<String>();
    
    // adiciona itens na lista
    pessoas.add("Alberto");
    pessoas.add("Victor");
    pessoas.add("João");
    	
    // adiciona um item na posição 2, depois de Victor    
    pessoas.add(2, "Ricardo");
   
    // exibe os itens da lista	
    for(int i = 0; i < pessoas.size(); i++){
      System.out.println(pessoas.get(i));
    }  

    System.exit(0);
  }
}

