package br.com.xti.poo;

@SuppressWarnings("unused")
/*Teste dentro da classe Funcionario
*/

public class Funcionario {
	
	private String nome;
	private boolean ativo;
	
	
	public String getNome(){// metodo
	
		return nome;
		
	}
	
	public void setNome(String n) {// metodo para configurar o valor
	 this.nome = n;
	}
	public boolean isAtivo(){
		return ativo;
		
	}
	public void setAtivo(boolean ativo){
		this.ativo = ativo;
	}
	
	
}
