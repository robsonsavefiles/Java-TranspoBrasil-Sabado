package parte2.exercicio03;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class MyThread extends Thread {

    private final String nome;
    private final int max;
    private int current;

    public MyThread(String nome, int max) {
        this.nome = nome;
        this.max = max;
    }

    @Override
    public void run() {
        super.run();
        try {
            while (current <= max) {
                System.out.println(nome + ": " + current++);
                if (current == max / 2) {
                    sleep(new Random().nextInt(6) * 1000);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
