/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.serializacao;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class AppTransferidor {
    
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("====TRANSFERIDOR DE ARQUIVOS=====");
        System.out.println("Informe o caminho de origem:");
        String origem = leitor.nextLine();
        System.out.println("Informe o a pasta de destino");
        String destino = leitor.nextLine();
        
        File arquivoOrigem = new File (origem);
        File pastaDestino = new File(destino);
        
        TransferidorArquivos transferidor = new TransferidorArquivos();
        transferidor.transferir2(arquivoOrigem, pastaDestino, false);//true >recorta o arquivo
        
      
        
       
		}

	}

        
    
    

