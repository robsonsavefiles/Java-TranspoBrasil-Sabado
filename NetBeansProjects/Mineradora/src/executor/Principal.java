package executor;


import dados.Deposito;
import interfaces.Main;
import dados.Fonte;
import interfaces.Maquinas;
import threads.MaquilaGrande;
import threads.OperarioEnergia;

public class Principal {

	public static void main(String[] args) {

		Fonte fonte = new Fonte();
		Deposito dep = new Deposito();

		MaquilaGrande mg = new MaquilaGrande(dep, fonte);
		
		mg.start();
		
		System.out.println(mg);
		
		
		OperarioEnergia oe1 = new OperarioEnergia(fonte);
		OperarioEnergia oe2 = new OperarioEnergia(fonte);
		OperarioEnergia oe3 = new OperarioEnergia(fonte);
		OperarioEnergia oe4 = new OperarioEnergia(fonte);
		OperarioEnergia oe5 = new OperarioEnergia(fonte);
		OperarioEnergia oe6 = new OperarioEnergia(fonte);
		OperarioEnergia oe7 = new OperarioEnergia(fonte);
		OperarioEnergia oe8 = new OperarioEnergia(fonte);
		OperarioEnergia oe9 = new OperarioEnergia(fonte);
		OperarioEnergia oe10 = new OperarioEnergia(fonte);
		OperarioEnergia oe11 = new OperarioEnergia(fonte);
		OperarioEnergia oe12 = new OperarioEnergia(fonte);
		OperarioEnergia oe13 = new OperarioEnergia(fonte);
		OperarioEnergia oe14 = new OperarioEnergia(fonte);
		OperarioEnergia oe15 = new OperarioEnergia(fonte);
		OperarioEnergia oe16 = new OperarioEnergia(fonte);
		OperarioEnergia oe17 = new OperarioEnergia(fonte);
		OperarioEnergia oe18 = new OperarioEnergia(fonte);
		OperarioEnergia oe19 = new OperarioEnergia(fonte);
		OperarioEnergia oe20 = new OperarioEnergia(fonte);
		OperarioEnergia oe21 = new OperarioEnergia(fonte);
		
		
		oe1.start();
		oe2.start();
		oe3.start();
		oe4.start();
		oe5.start();
		oe6.start();
		oe7.start();
		oe8.start();
		oe9.start();
		oe10.start();
		oe11.start();
		oe12.start();
		oe13.start();
		oe14.start();
		oe15.start();
		oe16.start();
		oe17.start();
		oe18.start();
		oe19.start();
		oe20.start();
	
		
		
		//Para uma maquina grande é preciso 1 20 operarios de energia;
		System.out.println(mg);
		System.out.println();
		
		System.out.println();
		
		

	}

}
