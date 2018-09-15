package dados;

public class Fonte {
	
	private int qtdEnergia = 10000;
	private final int MAX_ENERGIA =100000;
	private final int MIN_ENERGIA = 1;
	
	
	public void setQtdEnergia(int qtdEnergia) {
		this.qtdEnergia = qtdEnergia;
	}
	
	public int getQtdEnergia() {
		return qtdEnergia;
	}
	

	public synchronized void addOperarioEnergia() throws InterruptedException{
		
		while (qtdEnergia >= MAX_ENERGIA) {

		wait();	
		}
		
		qtdEnergia+=50;
		System.out.println("+50 a  fonte - " + qtdEnergia );
		
	
		notifyAll();
		
	}
	
	public synchronized void addMaquinaGrande() throws InterruptedException{
		
		while (qtdEnergia <= MIN_ENERGIA) {

		wait();	
		}
		
		qtdEnergia-=1000;
		System.out.println("-1000 a  fonte - " + qtdEnergia );
		
	
		notifyAll();
	}
	
	public synchronized void addMaquinaPequena() throws InterruptedException{
		
		while (qtdEnergia <= MIN_ENERGIA) {

		wait();	
		}
		
		qtdEnergia-=100;
		System.out.println("-100 a  fonte - " + qtdEnergia );
		
	
		notifyAll();
	}
	
	

}
