package threads;


import dados.Deposito;
import interfaces.Main;
import dados.Fonte;
import interfaces.Maquinas;

public class MaquinaPequena extends Thread implements Maquinas {

	private Deposito deposito;
	private Fonte fonte;
	private int consumo;
	private int minera;
	
	public MaquinaPequena(Deposito deposito, Fonte fonte) {
		super();
		this.deposito = deposito;
		this.fonte = fonte;
	}
		
	

	public void setConsumo(int consumo) {
		this.consumo = 100;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setMinera(int minera) {
		this.minera = 2;
	}

	public int getMinera() {
		return minera;
	}
	
	public void removerMaquinaPequena() {
		for (Maquinas  m : maquinas) {
			m.stop();
			maquinas.remover(m)
			break;
		
			
		}

	public void run() {
		super.run();
		try {
			while (true) {
				
				fonte.addMaquinaPequena();
				deposito.addMaquinaPequena();
				sleep(300);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}



	}



}


