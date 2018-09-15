package br.com.xti.java;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arquivo5 {

	public static void main(String[] args) throws IOException {
		
	Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();//diretorio raiz do sistema
	for(Path path : dirs){
		System.out.println(path);
	}
	/*Listar o Conteudo de um Diretorio*/
	
	Path dir = Paths.get("C:/xti");
    try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
	
    for(Path path : stream){
    	System.out.println(path.getFileName());
    }
    
    }catch(IOException | DirectoryIteratorException e){
		e.printStackTrace();

	//PARTIÇÕES	
		
	
    }
	}
}
		
	
	
	
	
	


