/*  *
 Este exemplo mostra usar o método lastIndexOf para obter
 o índice da última ocorrência de um item na ArrayList.
 Se o ítem não for encontrado, o valor retornado é -1.
*/
 
package estudojava.exemplos.Arrays;
import java.util.ArrayList;
/*
 *
 * @author Robinho
 */
public class OcorrenciaDeElemento {
  
  public static void main(String[] args){
    // cria uma ArrayList que conterá strings
    ArrayList<String> nomes = new ArrayList<String>();
    
    // adiciona itens na lista
    nomes.add("Carlos");
    nomes.add("Maria");
    nomes.add("Fernanda");
    nomes.add("Osmar");
    nomes.add("Maria");    
	
    // obtém o índice da última ocorrência do
    // nome "Maria"
    int indice = nomes.lastIndexOf("Maria");
    // obtém o índice da primeira ocorrência do
    // nome "Maria"
    int indice2 = nomes.indexOf("Maria");

    System.out.println("O índice do nome pesquisado  é: " + indice); 

    System.out.println("O índice do nome pesquisado é: " + indice2); 

    System.exit(0);
  }
}


