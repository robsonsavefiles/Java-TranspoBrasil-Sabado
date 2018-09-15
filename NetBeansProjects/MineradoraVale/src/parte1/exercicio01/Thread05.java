package parte1.exercicio01;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class Thread05 extends Thread {

    private final int numero;

    public Thread05(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 1; i < 11; i++) {
                System.out.println("Numero " + numero + " + " + i + " = " + (numero + i));
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
