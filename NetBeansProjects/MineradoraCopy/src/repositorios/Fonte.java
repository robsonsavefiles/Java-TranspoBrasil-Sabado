
package repositorios;

public class Fonte {
    
    private int qtdEnergia = 10000;
    private final int MAX_CAPACIDADE = 10000;

    public int getQtdEnergia() {
        return qtdEnergia;
    }
    
    public synchronized void adicionarEnergia(int quantidade) throws InterruptedException {
        while (MAX_CAPACIDADE < qtdEnergia + quantidade) {
            wait();
        }
        qtdEnergia += quantidade;
        System.out.println("Adicionado " + quantidade+ " de enregia a Fonte: " + qtdEnergia);
        notifyAll();
    }
    
    public synchronized void removerEnergia(int quantidade) throws InterruptedException {
        while (0 > qtdEnergia - quantidade) {
            wait();
        }
        qtdEnergia -= quantidade;
        System.out.println("Removido " + quantidade+ " de energia da Fonte: " + qtdEnergia);
        notifyAll();
    }

}
