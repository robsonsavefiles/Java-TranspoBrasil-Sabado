/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 88178
 */
public class Thread6 extends Thread{
    
    private Scanner teclado;
    private int numero;

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public Thread6(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        super.run();
  
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + i);
        try {
            sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(Threads2.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}
