package desafio_thread;

import java.util.Random;

public class Processo extends Thread {
	
	private int valorMaximo;
	private String nome;
	
	@Override
	public void run() {
		try {
			
			super.run();
			
			for (int i = 1; i <= valorMaximo; i++) {
				System.out.println(nome + ": " + i);
				
				if (i == valorMaximo/2) {
					System.out.println(nome + ": Parou para delay");
					sleep(new Random().nextInt(5001));
				}
			}
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getValorMaximo() {
		return valorMaximo;
	}
	
	public void setValorMaximo(int valorMaximo) {
		this.valorMaximo = valorMaximo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
}