package parte2;

import java.util.logging.Level;
import java.util.logging.Logger;
import parte1.ExemplosThreads;

/**
 *
 * @author 89087
 */
public class Colocador extends Thread {

    private Balde balde;

    public Colocador(Balde balde) {
        this.balde = balde;
    }

    @Override
    public void run() {
        super.run();

        while (true) {
            try {
                balde.colocar();

                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Colocador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
