/*
 * Garbage Collector - coletor de lixos
 * 
 * Runtime
 * Gc()- recicla
 * runFinalization()- executa a finalizaçao dos objetos
 * FreeMemory()- retorno uma estimativa de bytes livres
 * totalMemory()- retorno o total de bytes na memoria do sistema
 * maxMemory()- retorno a qtd maxima em bytes que a maquina virtual tentar utilizar
 * 
 * 
 * 
 * */

package br.com.xti.refinado;

import java.util.ArrayList;
import java.util.List;

public class Garbage {

	public static long carregarMemoria() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100_000; i++) {
			list.add(i);

		}
		return Runtime.getRuntime().freeMemory();

	}

	public static void main(String[] args) {

		Runtime rt = Runtime.getRuntime();
		int MB = 1_048_576;// Total de bytes em 1MB
		double total = rt.maxMemory() / MB;// retorno a qtd total de memoria

		double inicio = total - (carregarMemoria() / MB);

		System.out.println(total);
		System.out.println(inicio);
		
		rt.runFinalization();
		rt.gc();//força a execuçao do garbage
		
		double fim = total -(rt.freeMemory()/MB);
		System.out.println("Inicio:"+inicio+ "Fim:"+fim);

	}

}
