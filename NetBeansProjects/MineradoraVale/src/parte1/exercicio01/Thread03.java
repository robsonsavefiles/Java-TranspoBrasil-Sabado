package parte1.exercicio01;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class Thread03 extends Thread {

    private int atual;
    private int proximo;

    public Thread03(int atual, int proximo) {
        this.atual = atual;
        this.proximo = proximo;
    }

    @Override
    public void run() {
        super.run();
        try {

            for (int i = 0; i < 10; i++) {
                System.out.println("Fibonacci " + i + " = " + atual);
                atual += proximo;
                proximo += atual;
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
