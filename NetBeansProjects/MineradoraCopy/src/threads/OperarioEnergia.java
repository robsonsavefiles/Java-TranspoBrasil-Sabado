package threads;

import interfaces.Operario;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorios.Fonte;

public class OperarioEnergia extends Thread implements Operario {

    public static final int RECARGARREGA = 50;

    private Fonte fonte;

    public OperarioEnergia(Fonte fonte) {
        this.fonte = fonte;
    }

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                sleep(300);
                fonte.adicionarEnergia(RECARGARREGA);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(OperarioEnergia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
