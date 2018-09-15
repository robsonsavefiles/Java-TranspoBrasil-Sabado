/*
 2)crie um programa que solicite o caminho de um diretorio e em seguida liste o nome completo(absolutePath) de 
 todos os arquivos e diretorios contidos nos diretorio informado(apenas 1° nivel). caso o usuario informe um nome
 invalido(nao existente ou o nome de um arquivo) o programa deve imprimir a mensagem  "nome invalido o caminho 
 especificado nao pertence a um diretorio!!".
 */
package br.com.proway.arquivos;

import java.io.File;
import java.util.Scanner;

public class Exer2_Arquivos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

      
        File diretorio = new File("");
        System.out.println("Informe o Caminho do diretorio:");
        String dir = teclado.nextLine();
        File arquivo = new File(dir);
        File file = new File(dir);
        
        String[] caminho = diretorio.list();
        if (caminho != null) {
            for (String nome : caminho) {
                System.out.println(nome);
            }
        }

        File[] subpastas = diretorio.listFiles();
        if (caminho != null) {
            for (String dire : caminho) {
                System.out.printf("nome: %s tipo:%s\r\n", file.getName(), file.isDirectory() ? "Pasta" : "Arquivo");
            }
            }else{
                    System.out.println("Nome invalido");
                    }

        }
        
    }


