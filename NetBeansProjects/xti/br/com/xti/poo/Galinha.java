package br.com.xti.poo;

public class Galinha {
	
	public static int ovosDaGranja;//variavel global
	
	
	public int ovos;//total de ovos do objeto galinha
	
	public Galinha botar(){//metodo
		this.ovos++;
		Galinha.ovosDaGranja++;
		return this;//referencia do objeto
		
		
	}
	public static double mediaDeOvos(int galinhas){
		
		return Galinha.ovosDaGranja / galinhas;
	}

}
