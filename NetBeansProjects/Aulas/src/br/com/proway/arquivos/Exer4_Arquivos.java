/*
4)crie um programa que solicite o nome de um recurso e em seguida apague o recurso informado, caso o recurso seja 
um diretorio que contenha arquivos o programa deve apagar todos os arquivos do diretorio. valide a informçao de entrada.
 */
package br.com.proway.arquivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exer4_Arquivos {
    public static void main(String[] args) {
        
    
     Scanner teclado = new Scanner(System.in);

        File arquivo = new File("pasta");

        System.out.println("Informe o nome do recurso:");
        String rec = teclado.nextLine();

        File file = new File(rec);
        
        if(arquivo.delete()){
            try{
          System.out.println("Arquivo excluido com sucesso.");
            }catch (NullPointerException ex){
               System.out.println("Nao foi possivel Excluir o arquivo!!!");
               Logger.getLogger(TutorialFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
          System.out.println("Não foi possivel excluir o arquivo");
    }
}
}


 
