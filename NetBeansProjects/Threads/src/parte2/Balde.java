/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte2;

/**
 *
 * @author 88178
 */
public class Balde {

    private int qtdPedras = 20000;
    private final int MAX_PEDRAS = 20000;
    public final int PRO_ReSTART = 10000;
    private final int MIN_PEDRAS = 0;

    public int getQtdPedras() {
        return qtdPedras;
    }

    public void setQtdPedras(int qtdPedras) {
        this.qtdPedras = qtdPedras;
    }

    public synchronized void colocar() throws InterruptedException {

        while (qtdPedras >= MAX_PEDRAS) {

            wait();
        }

        qtdPedras += 100;
        System.out.println("+100 - " + qtdPedras);

        notifyAll();

    }

    public synchronized void remover() throws InterruptedException {
        while (qtdPedras <= MIN_PEDRAS) {

            wait();
        }

        qtdPedras -= 200;
        System.out.println("-100 - " + qtdPedras);
        if (qtdPedras <= PRO_ReSTART) {

            notifyAll();

        }

    }

}
