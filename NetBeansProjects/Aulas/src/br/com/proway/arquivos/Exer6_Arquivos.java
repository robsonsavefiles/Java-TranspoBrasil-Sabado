/*c:\
 ===>Arquivos de programas
 =====>Java
 ======>jdk1.8
 ========>jre1.8
 *
 */
package br.com.proway.arquivos;
import java.io.*;
import java.util.*;

public class Exer6_Arquivos {
    
    static int indentLevel = -1;
    private static Object[] files;
    private static int i;
    
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe o diretorio:");
        String dir = teclado.nextLine();
        File file = new File(dir);
        excluir(file);

        
       listPath(new File("c:\\java")); 
    
    }
    private static void listPath(File path){
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

    private static void excluir(File rec) {
     
    }
    }



