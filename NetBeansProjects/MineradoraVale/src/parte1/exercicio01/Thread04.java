package parte1.exercicio01;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class Thread04 extends Thread {

    private int num1;
    private int num2;

    public Thread04(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        super.run();
        try {

            for (int i = 0; i < 10; i++) {
                System.out.println("Fibonacci -" + i + " = " + num1);
                int numA = num1;
                num1 = num1 - (num1 - num2);
                num2 = numA - num1;
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
