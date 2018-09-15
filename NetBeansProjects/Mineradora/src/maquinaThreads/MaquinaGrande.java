package maquinaThreads;

import javax.swing.JOptionPane;

import interfaces.Maquina;
import recurso.DepositoMinerio;
import recurso.FonteEnergia;

public class MaquinaGrande extends Thread implements Maquina {
	
	private final int MAX_CAPACIDADE_MINERACAO = 10;
	private final int GASTO_ENERGIA = 1000;
	private DepositoMinerio depositoMinerio;
	private FonteEnergia fonteEnergia;
	
	public MaquinaGrande(DepositoMinerio depositoMinerio, FonteEnergia fonteEnergia) {
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
				
				sleep(900);
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
