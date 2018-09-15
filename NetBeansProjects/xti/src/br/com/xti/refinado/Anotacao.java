package br.com.xti.refinado;

import java.io.Serializable;

@Cabecalho(
		instituicao = "Philips",
		projeto= "Formaçao Java",
		dataCriacao = "04/11/2015",
		criador ="Philips",
		revisao = 2
		)

@ErrosCorrigidos(erros ={"0001","0002"}, value = "")
@SuppressWarnings({"serial","unused"})
public class Anotacao implements Serializable{
	
	@SuppressWarnings("unused")
	
	private int x;
	
	@Deprecated//indica que esse metodo ira aparecer
	private void anotar(){}

	@Override//sobrescreveu um metodo de uma classe pai 
	public String toString(){
		return null;
	}

}


