/*
 * Crie um programa que solicite o nome de um arquivo e em seguida solicite o nome de um diretorio. O programa deve fazer
   a copia do arquivo informado para o diretorio tambem informado.F
 */
package br.com.proway.arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exer7_ArquivosCopiarGravar {
    
    public static void main(String[] args) {
        
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome do arquivo:");
        String nome = teclado.nextLine();
  
        File dados = new File(nome + ".txt");
        
        System.out.println("Informe o Diretorio:");
        String dir = teclado.nextLine();
        
        File diretorio = new File(dir);
        
        System.out.printf("Nome: %s\r\n", diretorio.getName());
        System.out.printf("Existe: %s\r\n", diretorio.exists());
        
        if (diretorio.exists()) {
            diretorio.mkdir();// criar um novo diretorio no windows e linux mkdir 
            System.out.println("Pasta criada com sucesso ");

        } else {
            System.out.println(diretorio.getAbsolutePath());
            System.out.println("arquivo ja existe");
        }
        
        leitorModoEasy(nome);
        teclado.close();

    
    }
    public static void leitorModoEasy(String nomeArquivo) {

        try (Scanner leitor = new Scanner(new File(nomeArquivo))) {
            while (leitor.hasNextLine()) {//verifica se tem uma linha
                System.out.println(leitor.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado");
        }

    }  
  
           
//    copiar(arquivo1, arquivo2);
//    System.out.println("O arquivo1 foi copiado para o arquivo2");
//        
//        catch(IOException e){
//            // pode ocorrer erros
//        }
//    static void copiar(File fonte, File destino) throws IOException{
//        InputStream in = new FileInputStream(fonte);
//        OutputStream out = new FileOutputStream(destino);
//    
//        byte[] buf = new byte[1024];
//        int len;
//        while((len = in.read(buf)) > 0){
//            out.write(buf, 0, len);
//        }
//        in.close();
//        out.close();
    }


        
    
    

