package parte2.exercicio01;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class Removedor extends Thread {

    private Balde balde;
    private final static int PRODUTIVIDADE = 1;

    public Removedor(Balde balde) {
        this.balde = balde;
    }

    @Override
    public void run() {
        super.run();

        try {
            while (true) {
                balde.remover(PRODUTIVIDADE);
                sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Colocador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
