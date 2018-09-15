
package estudojava.exemplos.Arrays;
import java.util.ArrayList;

public class VerificarUmValor {
   
/*
 Este exemplo mostra como usar o método indexOf para
 verificar a existência de um valor em uma ArrayList.

 Se o ítem não for encontrado, sua posição (começando em 0)
 é retornada, do contrário o valor retornado é -1.
*/
  public static void main(String[] args){
    // cria uma ArrayList que conterá strings
    ArrayList<String> nomes = new ArrayList<>();
    
    // adiciona itens na lista
    nomes.add("Carlos");
    nomes.add("Maria");
    nomes.add("Fernanda");
    nomes.add("Osmar");
    nomes.add("Maria");    
	
    // Verifica se o valor "Osmar" existe na
    // ArrayList
    int indice = nomes.indexOf("Osmar");

    if(indice == -1)
      System.out.println("O valor pesquisado não foi encontrado.");
    else
      System.out.println("O valor foi encontrado no índice: " + indice); 

    System.exit(0);
  }
}