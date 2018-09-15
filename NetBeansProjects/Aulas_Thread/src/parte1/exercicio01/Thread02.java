package parte1.exercicio01;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class Thread02 extends Thread {

    private int numero;

    public Thread02(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        super.run();
        try {
            if (numero % 2 != 0) {
                numero++;
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("Número par " + i + " seguinte = " + numero + (2 * i));
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
