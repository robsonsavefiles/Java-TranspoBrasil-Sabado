package parte1;

/**
 *
 * @author 78522
 */
public class Executor {

    public static void main(String[] args) {
        ExemploThread e1 = new ExemploThread("Thread 1");
        ExemploThread e2 = new ExemploThread("Thread 2");

        e1.start();
        e2.start();
    }

}
