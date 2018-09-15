package parte2.exercicio02.operario;

import java.util.logging.Level;
import java.util.logging.Logger;
import parte2.exercicio02.recurso.Fonte;

/**
 *
 * @author 78522
 */
public class OperarioEnergia extends Operario {
    
    public final static double PRODUTIVIDADE = 50;
    
    public OperarioEnergia(Fonte fonte) {
        super(fonte, PRODUTIVIDADE);
    }
    
    @Override
    public void operar() {
        try {
            double energiaFaltante = getRecurso().getQtdMaxRecurso() - getRecurso().getQtdRecurso();
            double energia = energiaFaltante < PRODUTIVIDADE ? energiaFaltante : PRODUTIVIDADE;
            getRecurso().adicionar(energia);
            setLastOperacao(energia);
            sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(OperarioEnergia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
