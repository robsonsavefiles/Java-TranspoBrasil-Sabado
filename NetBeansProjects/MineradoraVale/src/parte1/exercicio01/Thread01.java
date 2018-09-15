package parte1.exercicio01;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class Thread01 extends Thread {

    private final int numero;

    public Thread01(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 1; i < 11; i++) {
                System.out.println("Mult�plo " + i + " = " + i * numero);
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
