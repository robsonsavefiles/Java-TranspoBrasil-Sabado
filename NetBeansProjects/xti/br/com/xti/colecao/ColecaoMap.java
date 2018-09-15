/*
 * coleção map - associa chave a valores
 * 
 * 
 * */

package br.com.xti.colecao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ColecaoMap {

	public static void main(String[] args) {
		
		Map<String,String> pais = new HashMap<>();
		pais.put("Br", "Brasil");
		pais.put("Ru","Russia");
		pais.put("In", "India");
		pais.put("Cn", "China");
		System.out.println(pais);
		
		pais.containsKey("Br");//buscandos
		pais.containsKey("Us");
		System.out.println(pais.containsValue("Brasil"));
		System.out.println(pais.get("Cn"));//retorno o conteudo pela chave
		pais.remove("Ru");
		System.out.println(pais);
		
		Set<String> keys = pais.keySet();//retorno um tipo set nao aceita tipo duplicados
		for (String key : keys) {
			System.out.println(key + ":" + pais.get(key));
			
			
		}
		
		
		
		
	}

}
