package br.com.xti.java;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.File;


public class Arquivo2 {
	
	public static void main (String[] args){
		
		Path path = Paths.get("C:/xti/files/texto.txt");
		Charset utf8 = StandardCharsets.UTF_8;//codificação do arquivo
		/*ESCRITA*/
		try(BufferedWriter w = Files.newBufferedWriter(path,utf8)){
		w.write("texto");
		w.write("texto");
		//w.flush();//pega o conteudo da memoria e grava no disco rigido
		//buffer => deposito de dados na memoria 
		}catch(IOException e){
			e.printStackTrace();
		}
		/*LEITURA*/
		try(BufferedReader reader = Files.newBufferedReader(path,utf8)){
			String line = null;
			while((line = reader.readLine())!=null){
				System.out.println(line);
			}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}



