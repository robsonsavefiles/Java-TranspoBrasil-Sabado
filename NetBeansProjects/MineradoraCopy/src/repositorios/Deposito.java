
package repositorios;

public class Deposito {
    
    private int qtdKg;
    private final int MAX_CAPACIDADE = 1000;

    public int getQtdKg() {
        return qtdKg;
    }
    
    public synchronized void adicionarKg(int quantidade) throws InterruptedException {
        while (MAX_CAPACIDADE < qtdKg + quantidade) {
            wait();
        }
        qtdKg += quantidade;
        System.out.println("Adicionado " + quantidade+ " Kg ao Depósito: " + qtdKg);
        notifyAll();
    }
    
    public synchronized void removerKg(int quantidade) throws InterruptedException {
        while (0 > qtdKg - quantidade) {
            wait();
        }
        qtdKg -= quantidade;
        System.out.println("Removido " + quantidade+ " Kg do Depósito: " + qtdKg);
        notifyAll();
    }


}
