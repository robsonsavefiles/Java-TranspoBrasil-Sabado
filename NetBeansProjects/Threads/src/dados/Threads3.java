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
public class Threads3 extends Thread {

    private Scanner teclado;
    private int numero;

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public Threads3(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        super.run();

        if (numero % 2 == 0) {
            for (int i = 0; i <= 20; i = i +2) {              
                System.out.println(numero + i);
            }
        }else{
             for (int i = 1; i <= 20; i = i +2) { 
                 
                System.out.println(numero + i);
        try {
            sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Threads3.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        }
    }

}
