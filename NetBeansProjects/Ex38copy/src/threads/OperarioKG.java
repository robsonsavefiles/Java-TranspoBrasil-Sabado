package threads;

import dados.Deposito;
import interfaces.Operarios;

public class OperarioKG extends Thread implements Operarios {
	
	private int libera;
	private Deposito deposito;
	
	public void setLibera(int libera) {
		this.libera = 5;
	}
	
	public int getLibera() {
		return libera;
	}
	
	public void run() {
		super.run();
		try {
			while (true) {
				
				deposito.addOperarioKG();		
				sleep(300);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
