package parte1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class ExemploThread extends Thread {

    private String mensagem;

    public ExemploThread(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("Olá - " + mensagem);
                sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ExemploThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
