
package threads;

import interfaces.Operario;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorios.Deposito;

public class OperarioKg extends Thread implements Operario {

    public static final int LIBERA = 5;
    
    private Deposito deposito;
    
    public OperarioKg(Deposito deposito) {
        this.deposito = deposito;
    }

    @Override
    public void run() {
        super.run(); 
        try {
            while (true) {
                sleep(300);
                deposito.removerKg(LIBERA);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(OperarioEnergia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
