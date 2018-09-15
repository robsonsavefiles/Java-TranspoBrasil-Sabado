package construtor;

/**
 *
 * @author 78522
 */
public class Filho extends Pai {

    private int valor = 10;
    private static String teste = "testando...";

    static {
        System.out.println("O bloco estático só aparece 1 vez.");
    }

    {
        System.out.println("Este bloco aparece sempre que o construtor for executado.");
    }

    public Filho() {
        System.out.println("Construtor do Filho chamado.");
        System.out.println("valor = " + valor);
        System.out.println(teste);
        System.out.println("==================================");

    }
}
