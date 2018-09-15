package operarioThreads;

import interfaces.Operario;
import recurso.FonteEnergia;

public class OperarioEnergia extends Thread implements Operario {
	
	private final int RECARREGA_ENERGIA = 50;
	private FonteEnergia fonteEnergia;
	
	public OperarioEnergia(FonteEnergia fonteEnergia) {
		this.fonteEnergia = fonteEnergia;
	}
	
	@Override
	public void run() {
		
		super.run();
		
		try {
			
			while(true) {
				fonteEnergia.adicionarRecurso(RECARREGA_ENERGIA);
				sleep(600);
			}
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public int getRecursoReloaded() {
		// TODO Auto-generated method stub
		return RECARREGA_ENERGIA;
	}
	
}
