package parte1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
// criamos uma classe que servirá como thread
class MinhaThread extends Thread {

    private String nome;

    public MinhaThread(String nome) {
        this.nome = nome;
    }
    @Override
    public void run() {
        super.run();
        for (int i = 1; i <= 20; i++) {
            System.out.println(nome + ": " + i);
        }
        try {
            sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(MinhaThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
