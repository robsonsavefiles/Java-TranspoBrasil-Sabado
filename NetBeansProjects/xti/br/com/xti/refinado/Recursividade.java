/*
 * Metodos Recursivos - chama a si proprio
 * 
 * 
 * */


package br.com.xti.refinado;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Recursividade {
	
	
	/*10+(10-1=9)=(9-1=8)*/
	public static int soma(int x){
		if(x == 0){
			return x;
		}else{
			System.out.println(x);
			return x +soma(x-1);
		}
	}

	public static int potencia(int x, int e){
		if(e == 1){
			System.out.println(x);
			return x;
		}else{
			int y = x * potencia(x,e-1);
			System.out.println(y);
			return y;
		}
	}
	//listar conteudo de um diretorio usando recursividade
	public static void listar(Path path){
		if(Files.isRegularFile(path)){
			System.out.println(path.toAbsolutePath());
		}else{
		String s ="\n" + path.toAbsolutePath();
		System.out.println(s.toUpperCase());
		System.err.println(path.toAbsolutePath());
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
			for (Path p : stream){
				listar(p);
				System.out.println(p.toAbsolutePath());
			}
		}catch(Exception e){
			
		}
		}		
		
		
	}
	
	public static void main(String[] args) {
	System.out.println(soma(10));
	System.out.println(potencia(3,4));
	listar(Paths.get("C:/xti"));
	
	}

}
