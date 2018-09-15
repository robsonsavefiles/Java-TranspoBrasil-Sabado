package maquinaThreads;

import interfaces.Maquina;
import recurso.DepositoMinerio;
import recurso.FonteEnergia;

public class MaquinaPequena extends Thread implements Maquina {
	
	private final int MAX_CAPACIDADE_MINERACAO = 2;
	private final int GASTO_ENERGIA = 100;
	private DepositoMinerio depositoMinerio;
	private FonteEnergia fonteEnergia;
	
	public MaquinaPequena(DepositoMinerio depositoMinerio, FonteEnergia fonteEnergia) {
		this.depositoMinerio = depositoMinerio;
		this.fonteEnergia = fonteEnergia;
	}
	
	@Override
	public void run() {
		
		super.run();
		
		try {
			
			while(true) {
				fonteEnergia.removerRecurso(GASTO_ENERGIA);
				depositoMinerio.adicionarRecurso(MAX_CAPACIDADE_MINERACAO);
				sleep(850);
			}
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int getQtdMinerio() {
		
		return MAX_CAPACIDADE_MINERACAO;
	}
	
	@Override
	public int getQtdEnergia() {
		
		return GASTO_ENERGIA;
	}
	
}
