package parte1.exercicio01;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class Thread07 extends Thread {

    private final int numero;

    public Thread07(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        super.run();
        try {
            int soma = 1;
            for (int i = soma; i < numero; i++) {
                soma *= i + 1;
                sleep(1000);
            }
            System.out.println(soma);
        } catch (Exception ex) {
            Logger.getLogger(Thread01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
