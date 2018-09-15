package comparacoeslogicas;

/**
 *
 * @author 78522
 */
public class OperadoresLogicos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("TABELA VERDADE");
        System.out.println("\n------------ E (&) ------------");
        System.out.println("V & V = " + (true & true));
        System.out.println("V & F = " + (true & false));
        System.out.println("F & V = " + (false & true));
        System.out.println("F & F = " + (false & false));
        System.out.println("\n------------ OU (|) ------------");
        System.out.println("V | V = " + (true | true));
        System.out.println("V | F = " + (true | false));
        System.out.println("F | V = " + (false | true));
        System.out.println("F | F = " + (false | false));
        System.out.println("\n------------ OU EXCLUSIVO (^) ------------");
        System.out.println("V ^ V = " + (true ^ true));
        System.out.println("V ^ F = " + (true ^ false));
        System.out.println("F ^ V = " + (false ^ true));
        System.out.println("F ^ F = " + (false ^ false));
        System.out.println("\n------------ NÃO (!) ------------");
        System.out.println("!V = " + (!true));
        System.out.println("!F = " + (!false));
        System.out.println("\n------------ E (&&) ------------");
        System.out.println("V & V = " + (verdadeiro() && verdadeiro()));
        System.out.println("V & F = " + (verdadeiro() && falso()));
        System.out.println("F & V = " + (falso() && verdadeiro()));
        System.out.println("F & F = " + (falso() && falso()));
        System.out.println("\n------------ OU (||) ------------");
        System.out.println("V | V = " + (verdadeiro() || verdadeiro()));
        System.out.println("V | F = " + (verdadeiro() || falso()));
        System.out.println("F | V = " + (falso() || verdadeiro()));
        System.out.println("F | F = " + (falso() || falso()));
    }

    private static boolean verdadeiro() {
        System.out.println("Verdadeiro");
        return true;
    }

    private static boolean falso() {
        System.out.println("Falso");
        return false;
    }
}
