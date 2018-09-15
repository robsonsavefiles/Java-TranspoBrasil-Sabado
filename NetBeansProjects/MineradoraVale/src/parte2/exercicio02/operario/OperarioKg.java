package parte2.exercicio02.operario;

import java.util.logging.Level;
import java.util.logging.Logger;
import parte2.exercicio02.recurso.Deposito;

/**
 *
 * @author 78522
 */
public class OperarioKg extends Operario {

    public final static double PRODUTIVIDADE = 5;

    public OperarioKg(Deposito deposito) {
        super(deposito, PRODUTIVIDADE);
    }

    @Override
    public void operar() {
        try {
            double minerioDisponivel = getRecurso().getQtdRecurso();
            double minerio = getRecurso().getQtdRecurso() < PRODUTIVIDADE ? minerioDisponivel : PRODUTIVIDADE;
            getRecurso().remover(minerio);
            setLastOperacao(minerio);
            sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(OperarioEnergia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
