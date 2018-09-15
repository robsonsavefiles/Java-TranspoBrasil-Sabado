/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudojava.exemplos.Arrays;

import java.util.ArrayList;

/**
 *
 * @author Robinho
 */
public class VerifcaSeEstaVazio {
    
   
  public static void main(String[] args){
    // cria uma ArrayList que conterá strings
    ArrayList<String> nomes = new ArrayList<String>();
    
    // adiciona itens na lista
    nomes.add("Carlos");
    nomes.add("Maria");
    nomes.add("Fernanda");
    nomes.add("Osmar");
    nomes.add("Maria");    
	
    // Verifica se a ArrayList está vazia
    if(nomes.isEmpty())
      System.out.println("A ArrayList não contém elementos."); 
    else
      System.out.println("A ArrayList não está vazia.");

    System.exit(0);
  }
}

