package br.com.xti.java;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;


public class Arquivo4 {

	public static void main(String[] args) throws IOException {
		
		/*CREATE*/
		Path path = Paths.get("C:/xti/files/texto.txt");
		Files.deleteIfExists(path);
		Files.createFile(path);
		Files.write(path,"Meu texto".getBytes());
		
		/*COPY*/
		Path copia = Paths.get("C:/xti/files/copia.txt");
		Files.copy(path,copia,StandardCopyOption.REPLACE_EXISTING);
		
		/*MOVER*/
		
		Path mover = Paths.get("C:/xti/files/move/fonte.txt");
		Files.createDirectories(mover.getParent());
		Files.move(path, mover, StandardCopyOption.REPLACE_EXISTING);
		
		
//		System.out.println(Files.exists(path));
//		System.out.println(Files.isDirectory(path));
//		System.out.println(Files.isRegularFile(path));
//		System.out.println(Files.isReadable(path));
//		System.out.println(Files.isExecutable(path));
//		System.out.println(Files.size(path));
//		System.out.println(Files.isRegularFile(path));
//		System.out.println(Files.getLastModifiedTime(path));
//		System.out.println(Files.getOwner(path));
//		System.out.println(Files.probeContentType(path));
//		
	/*DELETE*/
		
		//Files.delete(path);
		Files.deleteIfExists(path);
	
		
		
	}

}
