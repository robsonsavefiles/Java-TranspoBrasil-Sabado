package parte2.exercicio02.recurso;

/**
 *
 * @author 78522
 */
public class Deposito extends Recurso {

    private final static double MAX_MINERIO = 10000;
    private final static double UPGRADE = 1000;

    public Deposito() {
        super("Min�rio", MAX_MINERIO, UPGRADE);
    }

}
