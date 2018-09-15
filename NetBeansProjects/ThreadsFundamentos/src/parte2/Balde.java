
package parte2;

/**
 *
 * @author 89087
 */
public class Balde extends Thread  {
    
    private int qtPedras;
    private final int  MAX_PEDRAS = 100;
    

   public synchronized  void colocar() throws InterruptedException {
       while(MAX_PEDRAS <= qtPedras){
           wait();
           //qtPedras++;
          // System.out.println("Colocando"+qtPedras);
       }
       qtPedras ++;
       System.out.println("Colocando"+qtPedras);
       notifyAll();
    }
    public synchronized void remover() throws InterruptedException{
        while( 0>= qtPedras){
            wait();
           // qtPedras--;
           // System.out.println("Removendo"+qtPedras);
        }
        qtPedras --;
        System.out.println("Removendo"+qtPedras);
        notifyAll();
    }
}
