/*c:\
 ===>Arquivos de programas
 =====>Java
 ======>jdk1.8
 ========>jre1.8
 *
 */
package br.com.proway.arquivos;

import java.io.File;
import java.util.Scanner;

public class Exer5_Arquivos {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe o Nome do arquivo:");
        String rec = teclado.nextLine();

        File file = new File(rec);
        File diretorio = new File("C:\\java"); 
        File[] arquivos = diretorio.listFiles(); 
  
        if(arquivos != null){ 
            int length = arquivos.length; 
  
            for(int i = 0; i < length; ++i){ 
                File f = arquivos[i]; 
            
                if(file.isFile()){ 
                    System.out.println(f.getName()); 
                } 
                else if(f.isDirectory()){ 
                    System.out.println("Diretorio: " + f.getName()); 
                } 
            } 
        }    
    }
}


