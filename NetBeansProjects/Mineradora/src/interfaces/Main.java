package interfaces;

import java.util.ArrayList;


public class Main {
	
	ArrayList<Operarios> operarios = new ArrayList<Operarios>();
	ArrayList<Maquinas> maquinas = new ArrayList<Maquinas>();
	
	public static void main(String[] args) {

	}
	
	public int calcularTotalCon(){
		int consumoTotal = 0;
		
		for (Maquinas m : maquinas) {
			consumoTotal += m.getConsumo();
		}
		System.out.println("Este é consumo total " + consumoTotal);
		
			return consumoTotal;
			
		}
	
	

}
