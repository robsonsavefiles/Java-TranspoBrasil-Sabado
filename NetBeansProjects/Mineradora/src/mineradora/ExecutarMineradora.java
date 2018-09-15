package mineradora;

import maquinaThreads.MaquinaGrande;
import maquinaThreads.MaquinaPequena;
import operarioThreads.OperarioEnergia;
import operarioThreads.OperarioKg;
import recurso.DepositoMinerio;
import recurso.FonteEnergia;

public class ExecutarMineradora {

	public static void main(String[] args) {
		
		DepositoMinerio depositoMinerio = new DepositoMinerio();
		FonteEnergia fonteEnergia = new FonteEnergia();
		
		MaquinaGrande maquinaGrande = new MaquinaGrande(depositoMinerio, fonteEnergia);
		MaquinaGrande maquinaGrande2 = new MaquinaGrande(depositoMinerio, fonteEnergia);
		MaquinaPequena maquinaPequena = new MaquinaPequena(depositoMinerio, fonteEnergia);
		
		OperarioEnergia operarioEnergia = new OperarioEnergia(fonteEnergia);
		OperarioKg operarioKg = new OperarioKg(depositoMinerio);
		
		
		maquinaGrande.start();
		maquinaPequena.start();
		maquinaGrande2.start();
		
		operarioEnergia.start();
		operarioKg.start();

	}

}
