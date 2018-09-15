package operarioThreads;

import interfaces.Operario;
import recurso.DepositoMinerio;

public class OperarioKg extends Thread implements Operario {
	
	private final int LIBERA_DEPOSITO = 5;
	private DepositoMinerio depositoMinerio;
	
	public OperarioKg(DepositoMinerio depositoMinerio) {
		this.depositoMinerio = depositoMinerio;
	}
	
	@Override
	public void run() {
		super.run();
		
		try {
			
			while(true) {
				depositoMinerio.removerRecurso(LIBERA_DEPOSITO);
				sleep(680);
			}
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public int getRecursoReloaded() {
		
		return LIBERA_DEPOSITO;
	}
	
	
}
