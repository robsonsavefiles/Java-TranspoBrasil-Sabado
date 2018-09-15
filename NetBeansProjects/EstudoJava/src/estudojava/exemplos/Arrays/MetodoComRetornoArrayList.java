/*
Como escrever um método Java que retorna um objeto da classe ArrayList
 */

package estudojava.exemplos.Arrays;

import java.util.ArrayList;

/**
 *
 * @author Robinho
 */
public class MetodoComRetornoArrayList {
    
  public static void main(String[] args){
    // vamos obter o ArrayList do método abaixo    
    ArrayList<String> lista = obterLista();

    // vamos exibir os valores dos elementos
    for(int i = 0; i < lista.size(); i++){
      System.out.println(lista.get(i));
    }
    
    System.exit(0);
  }

  // um método que retorna um ArrayList
  public static ArrayList<String> obterLista(){
    // vamos criar um ArrayList, adicionar alguns elementos
    // e devolvê-la ao chamador do método
    ArrayList<String> nomes = new ArrayList<String>();
    nomes.add("Osmar J. Silva");    
    nomes.add("Fernanda de Castro");
    nomes.add("Marcos de Oliveira");

    return nomes;
  }
}
    

