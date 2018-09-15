/*
 Desenvolva uma classe Balde que tem como característica receber pedras de duas Threads, uma para colocar pedras 
 (Produtor) outra para remover pedras (Coletor). Então defina para os métodos de inserir e remover pedras da classe 
 balde as seguintes restrições:

 #Não deverá ser possível remover pedras caso o balde esteja vazio.
 #Não será possível adicionar pedras caso o balde esteja cheio (considere 20000 pedras cheio).
 #Caso o balde esteja cheio, os Produtores deverão parar de inserir pedras no balde até que ele possua 10000 pedras 
 ou menos, quando chegar nesta marca eles deverão inserir pedras até que o balde fique cheio novamente.

 Ou seja, quando o balde chegar a 20 pedras, para-se de colocar pedras até que ele tenha 10 pedras, então está liberado
 que se coloquem mais pedras até que ele fique cheio novamente, quando irá parar e esperar chegar a 10 pedras…

 Para teste, faça cada produtor inserir 100 pedras e cada coletor remover 200. Crie então, no main, 6 produtores e 
 três coletores.

 */
package Exer37;

import parte2.*;

/**
 * @author 89087
 */
public class Balde extends Thread {

    private int qtPedras = 0;
    private final int MAX_PEDRAS = 200;

    public synchronized void colocar() throws InterruptedException {
        System.out.println("Colocando" + qtPedras);
        while (MAX_PEDRAS <= qtPedras) {
            wait();
        }
        qtPedras++;

        notifyAll();
    }

    public synchronized void remover() throws InterruptedException {
        System.out.println("Removendo" + qtPedras);
        while (0 >= qtPedras) {
            wait();
        }
        qtPedras--;
     
            if (qtPedras <= MAX_PEDRAS / 2) {
                notifyAll();
            }
        }
    }

