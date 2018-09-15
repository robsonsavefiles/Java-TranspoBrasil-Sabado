package construtor;

/**
 *
 * @author 78522
 */
public class Pai {

    static {
        System.out.println("O bloco estático pai só aparece 1 vez.");
    }

    public Pai() {
        System.out.println("Construtor do Pai chamado.");
    }

    public Pai(String st) {

    }

}
