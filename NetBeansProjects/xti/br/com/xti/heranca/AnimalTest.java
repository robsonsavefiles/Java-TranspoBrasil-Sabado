package br.com.xti.heranca;

public class AnimalTest {

	/**
	 * @param args
	 */
	public static void barulho(Animal animal){
	
		animal.fazerBarulho();
	}
	public static void barulhoSemPolimorfismo (String animal){
		if(animal.equals("Cachorro")){
			System.out.println("Au Au");
		}else if(animal.equals("Galinha")){
			System.out.println("C� C�");
		}
	}
	
	public static void main(String[] args) {
	
		Animal toto = new Cachorro();
		toto.comida = "carne";
		toto.dormir();
		
		barulho(toto);
		barulhoSemPolimorfismo("Cachorro");
		barulhoSemPolimorfismo("Galinha");
		Animal generico = new Animal(0,null);
		generico.fazerBarulho();
		
		Animal carijo = new Galinha();
		carijo.dormir();
		
		
		System.out.println(toto instanceof Cachorro);
		System.out.println(toto instanceof Animal);
			
		toto.equals(carijo);//comparar dois objetos
		toto.hashCode();//gera um serial para cole��o arraylist
		toto.getClass();//retorna o tipo da classe do objeto
		toto.toString();//retorna a representa�ao do objeto em string
		
		toto.fazerBarulho();
		carijo.fazerBarulho();
		
	}

}
