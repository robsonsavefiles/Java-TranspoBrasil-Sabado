package br.com.xti.poo;

public class CachorroTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cachorro pitbull = new Cachorro();
		pitbull.raca = "Pit Bull";
		pitbull.tamanho = 40;
		pitbull.latir();
		
		Cachorro viralata = new Cachorro();
		viralata.raca = "Vira-lata";
		viralata.tamanho = 30;
		viralata.latir();
	}

}
