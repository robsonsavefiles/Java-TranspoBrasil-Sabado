package parte2.exercicio02.maquina;

import parte2.exercicio02.recurso.Deposito;
import parte2.exercicio02.recurso.Fonte;

/**
 *
 * @author 78522
 */
public class MaquinaGrande extends Maquina {

    public static final double CONSUMO_ENERGIA = 1000;
    public static final double PRODUCAO_MINERIO = 10;

    public MaquinaGrande(Deposito deposito, Fonte fonte) {
        super(deposito, fonte, CONSUMO_ENERGIA, PRODUCAO_MINERIO);
    }

}
