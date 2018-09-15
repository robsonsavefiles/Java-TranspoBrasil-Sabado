package parte2.exercicio01;

/**
 *
 * @author 78522
 */
public class Balde {

    private final static int MAX_PEDRAS = 100;
    private final static int MIN_PEDRAS_COLOCADOR = 20;

    private int qtdPedras;
    private boolean esvaziando = false;

    public synchronized void colocar(int qtd) throws InterruptedException {
        while (esvaziando) {
            wait();
        }
        qtdPedras += qtd;
        System.out.println("Pedras = " + qtdPedras);

        if (qtdPedras >= MAX_PEDRAS) {
            esvaziando = true;
        }

        notifyAll();
    }

    public synchronized void remover(int qtd) throws InterruptedException {
        while (qtdPedras - qtd < 0) {
            wait();
        }
        qtdPedras--;
        System.out.println("Pedras = " + qtdPedras);

        if (qtdPedras <= MIN_PEDRAS_COLOCADOR) {
            esvaziando = false;
        }

        notifyAll();
    }
}
