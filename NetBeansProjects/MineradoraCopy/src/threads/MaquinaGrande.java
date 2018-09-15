
package threads;

import interfaces.Maquina;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorios.Deposito;
import repositorios.Fonte;

public class MaquinaGrande extends Thread implements Maquina {
    
    public static final int PRODUCAO = 10;
    public static final int CONSUMO = 1000;
    
    private Fonte fonte;
    private Deposito deposito;
    
    public MaquinaGrande(Deposito deposito, Fonte fonte) {
        this.deposito = deposito;
        this.fonte = fonte;
    }

    @Override
    public void run() {
        super.run();
        try {
            
            while (true) {
                sleep(300);
                deposito.adicionarKg(PRODUCAO);
                fonte.removerEnergia(CONSUMO);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MaquinaGrande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
