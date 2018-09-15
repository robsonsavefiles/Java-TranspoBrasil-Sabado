package br.com.xti.threads;

public class ContaConjunta {

	public int saldo = 100;

	public int GetSaldo() {
		return saldo;
	}

	public synchronized void sacar(int valor, String cliente) {
		if (saldo >= valor) {
			int saldoOriginal = saldo;
			System.out.println(cliente + "Vai Sacar");
			try {
				System.out.println(cliente + "Esperando");
				Thread.sleep(1000);//Aguardando o processamento 
			} catch (InterruptedException e) {}
				saldo -= valor;
				String msg = cliente + "SACOU" + valor
						+ "[Saldo Original=" + saldoOriginal 
						+",Saldo Final= "+saldo +"]";
				System.out.print(msg);
		
		}else {
			System.out.println("Saldo Insuficiente para " + cliente);

		}
	}
}
