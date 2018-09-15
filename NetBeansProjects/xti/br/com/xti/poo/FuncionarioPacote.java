package br.com.xti.poo;
/*Teste dentro do mesmo pacote da classe Funcionario*/

public class FuncionarioPacote {
	
	public static void main(String[] args){
		
		Funcionario f = new Funcionario();
		String n = f.getNome();
		f.setNome("Welington");
		
	}

}
