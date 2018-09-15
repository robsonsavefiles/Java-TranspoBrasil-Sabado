package br.com.xti.threads;

public class PonteSincronizada implements Ponte {

	private int valor = -1;
	private boolean ocupada = false;

	@Override
	public synchronized void set(int valor) throws InterruptedException {
		while (ocupada) {
			System.out.println("Ponte cheia. Produtor Aguarde");
			wait();//
		}

		System.out.print("Produziu" + valor);
		this.valor = valor;

		ocupada = true;
		notifyAll();// libera todas as threads
	}

	@Override
	public synchronized int get() throws InterruptedException {
		while (!ocupada) {
			System.out.println("Ponte vazia. Consumidor Aguarde");
			wait();

		}

		System.out.print("Consumiu" + valor);

		ocupada = false;
		notifyAll();
		return valor;

	}

}
