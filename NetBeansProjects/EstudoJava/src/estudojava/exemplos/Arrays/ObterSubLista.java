/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudojava.exemplos.Arrays;
import java.util.*;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Robinho
 */
public class ObterSubLista {
    
    public static void main(String[] args){
    // cria uma ArrayList que conterá strings
    ArrayList<String> nomes = new ArrayList<String>();

    // adiciona itens na primeira lista
    nomes.add("Carlos");
    nomes.add("Maria");
    nomes.add("Fernanda");
    nomes.add("Osmar");
    nomes.add("Zacarias");    

    // vamos obter um sub-lista da primeira lista
    // o resultado será: Maria, Fernanda e Osmar
   // List<String> nomes2 = nomes.subList(1, 4);

    // vamos exibir o resultado
//    for(int i = 0; i < nomes2.size(); i++){
//      System.out.println(nomes2.get(i));
//    } 

    System.exit(0);
  }
}
    

