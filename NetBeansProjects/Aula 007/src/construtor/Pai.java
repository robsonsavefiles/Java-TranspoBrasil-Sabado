package construtor;

/**
 *
 * @author 78522
 */
public class Pai {

    static {
        System.out.println("O bloco est�tico pai s� aparece 1 vez.");
    }

    public Pai() {
        System.out.println("Construtor do Pai chamado.");
    }

    public Pai(String st) {

    }

}
