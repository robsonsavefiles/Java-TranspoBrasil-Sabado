//I/O: Input/Output:Read/Write.
//Input:Read Entrada de Dados no programa, programa lê os dados
//Output:Write Saida de dados do programa programa escreve os dados


package br.com.xti.java;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.*;



public class Arquivo{

	public static void main(String[] args) throws IOException {
	
	//JAVA 7	
	Path path = Paths.get("C:/xti/files/texto.txt");	
	System.out.println(path.toAbsolutePath());//retorna o caminho do diretorio
	System.out.println(path.getParent());
	System.out.println(path.getRoot());
	System.out.println(path.getFileName());
	
	/*CRIAÇAO DE DIRETORIOS*/
	Files.createDirectories(path.getParent());
	
	
	/*ESCREVER e LER ARQUIVOS*/
	byte[] bytes = "Meu texto".getBytes();
	Files.write(path,bytes);//cria,limpa e escreve 
	
	byte[] retorno = Files.readAllBytes(path);
	System.out.println(new String(retorno));
	
	


}
	}