package br.com.xti.poo;

public class Conta implements java.io.Serializable{

	String cliente;
	double saldo;

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Conta() {

	}

	public Conta(String cliente, double saldo) {
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public void exibeSaldo() {

		System.out.println(cliente + " Seu Saldo é " + saldo);

	}

	public void saca(double valor) {

		saldo -= valor;

		// ver se tem autorização
		// se tem limite do dia nao foi ultrapassado
		// se tem saldo na conta
		// 1-deduzir do saldo o valor do saque
		// atualizar registros do banco
		// entregar o dinheiro ao cliente;

	}

	public void deposita(double valor) {
		saldo += valor;

	}

	public void tranferePara(Conta destino, double valor) {
		this.saca(valor);
		destino.deposita(valor);

	}

}