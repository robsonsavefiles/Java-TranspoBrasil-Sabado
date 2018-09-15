package br.com.xti.poo;

public class ContaTest {
	
	
	public static void main(String[] args) {
	
	Conta conta = new Conta();
	conta.cliente = "Ricardo";
	conta.saldo = 10000;
	
	conta.exibeSaldo();
	conta.saca(1000);
	conta.exibeSaldo();
	conta.deposita(6000);
	conta.exibeSaldo();
	
	Conta destino = new Conta();
	destino.cliente = "ROBSON";
	destino.saldo = 1000;
	destino.exibeSaldo();
	 
	conta.tranferePara(destino,2000);
	conta.exibeSaldo();
	destino.exibeSaldo();
	
	
	
	
	}

}
