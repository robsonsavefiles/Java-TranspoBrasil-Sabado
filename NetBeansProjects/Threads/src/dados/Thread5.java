/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 88178
 */
public class Thread5 extends Thread{

    private Scanner teclado;
    private int numero1;
    private int numero2;

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public Thread5(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    @Override
    public void run() {
        super.run();

        for(int i = 1; i < 10 && numero1 > 1; i++){
            System.out.println(numero1);
            int numA = numero1;
            numero1 = numero1 - (numero1 - numero2);
            numero2 = numA - (numero1);
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread5.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
