package br.com.proway.arquivos;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class TutorialFile {

    public static void main(String[] args) {
        //java.io.

        File arquivo = new File("dados.txt");
        File diretorio = new File("pastaBackup");
        //verifica se os arquivos existe
        System.out.printf("Nome: %s\r\n", arquivo.getName());
        System.out.printf("Existe: %s\r\n", arquivo.exists());

        System.out.println("========Dados do diretorio=======");
        System.out.printf("Nome: %s\r\n", diretorio.getName());
        System.out.printf("Existe: %s\r\n", diretorio.exists());

        if (arquivo.exists()) {
            //cria um arquivo novo se nao existir 
            try {
                arquivo.createNewFile();
                System.out.println("Arquivo Criado com sucesso");
            } catch (IOException ex) {
                System.out.println("Nao foi possivel criar arquivos!!!");
                Logger.getLogger(TutorialFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println(arquivo.getAbsoluteFile());//mostra o caminho do arquivo
            System.out.println("Arquivo Já Existe!!!");

        }   // trabalhando com diretorio
        if (diretorio.exists()) {
            diretorio.mkdir();// criar um novo diretorio no windows e linux mkdir 
            System.out.println("Pasta criada com sucesso ");

        } else {
            System.out.println(diretorio.getAbsolutePath());
            System.out.println("arquivo ja existe");
        }
        verificarTipoFile(arquivo);
        verificarTipoFile(diretorio);

        File pastaInterna = new File(diretorio, "nivel/nivel/nivel");
        if (!pastaInterna.exists()) {
            boolean ok = pastaInterna.mkdirs();//mkdirs cria varias pastas
            if (ok) {
                System.out.println("Supbasta criada com sucesso!!");
            } else {
                System.out.println("Não foi possivel criar o caminho  espeficificado!!!");
            }
        }
        System.out.println(pastaInterna.getAbsolutePath());
        System.out.println(pastaInterna.getParentFile().getAbsolutePath());

        File parent = pastaInterna.getParentFile();
        while (parent != null) {
            System.out.println(parent.getAbsolutePath());//retorna em string
            parent = parent.getAbsoluteFile().getParentFile();

        }

        System.out.println("informaçoes do diretorio backup");
        String[] nomesSubpastas = diretorio.list();
        if (nomesSubpastas != null) {
            for (String nome : nomesSubpastas) {
                System.out.println(nome);
            }
        }

        File[] subpastas = diretorio.listFiles();
        if (nomesSubpastas != null) {
            for (File file : subpastas) {
                System.out.printf("nome: %s tipo:%s\r\n", file.getName(), file.isDirectory() ? "Pasta" : "Arquivo");
            }

        }
       // impressora(100);
        verificarTipoFile(arquivo);
        verificarTipoFile(diretorio);
    }

    private static void verificarTipoFile(File file) {
        if (file.isFile()) {
            System.out.printf("%s é um arquivo\r\n", file.getName());

        } else if (file.isDirectory()) {
            System.out.printf("%s é uma pasta\r\n", file.getName());

        }

    }

    //metodo recursivo ele chama a si mesmo;  //com uma condiçao de saida 
//    private static void impressora(int numero) {
//        if (numero <= 1) {
//            System.out.println(numero);
//        } else {
//            impressora(numero - 1);
//            System.out.println(numero);
//        }
//
//    }
}
