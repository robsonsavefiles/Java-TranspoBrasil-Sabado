package threads;

import dados.Deposito;
import dados.Fonte;
import interfaces.Operarios;

public class OperarioEnergia extends Thread implements Operarios  {
	
	private Fonte fonte;
	private int recarga;
	
	public OperarioEnergia(Fonte fonte){
		
		this.fonte = fonte;
		
	}
	
	public void setRecarga(int recarga) {
		this.recarga = recarga;
	}
	
	public int getRecarga() {
		return recarga;
	}
	
	public void run() {
		super.run();
		try {
			while (true) {
				
				fonte.addOperarioEnergia();			
				sleep(300);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
