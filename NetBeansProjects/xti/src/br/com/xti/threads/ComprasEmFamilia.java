package br.com.xti.threads;

public class ComprasEmFamilia implements Runnable {

	ContaConjunta conta = new ContaConjunta();
	
	public static void main(String[] args){
		
		ComprasEmFamilia isCompras = new ComprasEmFamilia();
		new Thread(isCompras,"Pai").start();
		new Thread(isCompras,"Mae").start();
		new Thread(isCompras,"Filho").start();
		new Thread(isCompras,"Neto").start();
		new Thread(isCompras,"Sobrinho").start();
		new Thread(isCompras,"Baba").start();
	}
	@Override
	public void run() {
	String cliente  = Thread.currentThread().getName();
	for(int i = 0;i<5;i++){
	conta.sacar(20, cliente);
	if(conta.GetSaldo()<0){
		System.out.println("Estorou");
		
	}
	}
	
	
	}

}
