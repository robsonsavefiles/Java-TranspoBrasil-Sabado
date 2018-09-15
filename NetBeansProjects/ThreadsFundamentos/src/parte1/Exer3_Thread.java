package parte1;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class Exer3_Thread extends Thread {

    private Scanner teclado;
    private int num1;
    private int num2;

    public Exer3_Thread(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public void run() {
        super.run();
        //public void FibPro() {
        for (int i = 1; i < 10; i++) {
            num1 = num1 + num2;
            num2 = num1 - num2;
            System.out.println(num1);

            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Exer3_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
