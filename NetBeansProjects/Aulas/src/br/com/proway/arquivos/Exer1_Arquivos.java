/*Crie um programa que solicite o caminho de um recurso e escreva se o recurso informado existe ou nao 
 caso o recurso informado exista se é um arquivo ou um diretorio.

 */
package br.com.proway.arquivos;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exer1_Arquivos {
   

     static int indentLevel = -1;
    
    public static void main(String[] args){
       listPath(new File("c:\\java")); 
    }
   
    static void listPath(File path){
        File files[]; 
        indentLevel++; 

        files = path.listFiles();

        Arrays.sort(files);
    
        for(int i = 0, n = files.length; i < n; i++){
            for(int indent = 0; indent < indentLevel; indent++){
                System.out.print("  ");
            }
            System.out.println(files[i].getName());
            if(files[i].isDirectory()){
                listPath(files[i]);
            }
        }
        indentLevel--; 
    }
}
