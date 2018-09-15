package parte2.exercicio02.maquina;

import parte2.exercicio02.recurso.Deposito;
import parte2.exercicio02.recurso.Fonte;

/**
 *
 * @author 78522
 */
public class MaquinaPequena extends Maquina {

    public static final double CONSUMO_ENERGIA = 100;
    public static final double PRODUCAO_MINERIO = 2;

    public MaquinaPequena(Deposito deposito, Fonte fonte) {
        super(deposito, fonte, CONSUMO_ENERGIA, PRODUCAO_MINERIO);
    }

}
