package parte1;


import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import parte1.ExemplosThreads;

/**
 *
 * @author 89087
 */
public class Exer2_Thread extends Thread {

    private Scanner teclado;
    private int num2;

    public Exer2_Thread(int num2) {
        this.num2 = num2;
    }
    
    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public void run(){//vai ser chamando dentro do metodo start
        super.run();//define o o que o metodo faz
         if (num2 % 2 == 0){
            for (int i = 0; i <=20;i=i+2){
                System.out.println(num2 + i);
            }
            }else{
             for (int i = 1; i <=20;i= i+2){
                 System.out.println(num2 + i);
             }
         }
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exer2_Thread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    

