
package parte1;

/**
 *
 * @author 89087
 */
public class Executor extends Thread{

    
    public static void main(String[] args) {
        ExemplosThreads e1 = new ExemplosThreads("Thread 1");
        ExemplosThreads e2 = new ExemplosThreads("Thread 2");
        
        e1.start();//run.start();exceuta as primeiras thread 1 depois Thread 2
        e2.start();

    }
    
}
