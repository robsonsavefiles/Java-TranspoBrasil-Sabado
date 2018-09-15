package parte2.exercicio02.recurso;

/**
 *
 * @author 78522
 */
public class Fonte extends Recurso {

    private final static double MAX_ENERGIA = 100000;
    private final static double UPGRADE = 10000;

    public Fonte() {
        super("Energia", MAX_ENERGIA, UPGRADE);
    }
}
