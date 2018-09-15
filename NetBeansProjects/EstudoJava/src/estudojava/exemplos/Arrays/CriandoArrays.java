package estudojava.exemplos.Arrays;

import java.util.ArrayList;

public class CriandoArrays{
  public static void main(String[] args){
    // cria uma ArrayList que conterá inteiros
    ArrayList<Integer> valores = new ArrayList<Integer>();
    
    // adiciona itens na lista
    valores.add(34);
    valores.add(12);
    valores.add(8);
    valores.add(23);
    	
    // exibe os valores da lista
    for(int i = 0; i < valores.size(); i++)
      System.out.println(valores.get(i));

    System.exit(0);
  }
}