package parte2.exercicio01;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        Balde balde = new Balde();
        Colocador c1 = new Colocador(balde);
        Colocador c2 = new Colocador(balde);
        Removedor r1 = new Removedor(balde);

        c1.start();
        c2.start();
        r1.start();
    }
}
