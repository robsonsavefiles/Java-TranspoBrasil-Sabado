package threads;

import dados.Deposito;
import dados.Fonte;
import interfaces.Maquinas;
import interfaces.Main;

public class MaquilaGrande extends Thread implements Maquinas {
	
	private Deposito deposito;
	private Fonte fonte;
	private int consumo;
	private int minera;
	

	
	public MaquilaGrande(Deposito deposito, Fonte fonte) {
		super();
		this.deposito = deposito;
		this.fonte = fonte;
	}

	public int getConsumo() {
		return consumo;
	}
	
	public void setConsumo(int consumo) {
		this.consumo = 1000;
	}
	
	public void setMinera(int minera) {
		this.minera = 10;
	}
	
	public int getMinera() {
		return minera;
	}
	
	public void run() {
		super.run();
		try {
			while (true) {
				
				fonte.addMaquinaGrande();
				deposito.addMaquinaGrande();
				sleep(300);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	

	

}
