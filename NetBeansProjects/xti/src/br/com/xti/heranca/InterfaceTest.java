package br.com.xti.heranca;

public class InterfaceTest {
	
	public void area(AreaCalculavel o){
	System.out.println(o.calculaArea());
	}	

	public void area(VolumeCalculavel o){
	System.out.println(o.calculaVolume());
	}
	
	public void main(String[] args){

	area(new Quadrado(2));
	area(new Quadrado(2));
	
}
}