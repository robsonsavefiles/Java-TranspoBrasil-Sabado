
package Exer37;

import parte2.*;


public class Executor extends Thread  {
    
    public static void main(String[] args) {
        
        
        Balde balde = new Balde();
        Removedor r1 = new Removedor(balde);
        Removedor r2 = new Removedor(balde);
        Removedor r3 = new Removedor(balde);
        Colocador1 c1 = new Colocador1(balde);
        Colocador1 c2 = new Colocador1(balde);
        Colocador1 c3 = new Colocador1(balde);
        Colocador1 c4 = new Colocador1(balde);
        Colocador1 c5 = new Colocador1(balde);
        Colocador1 c6 = new Colocador1(balde);
        
        
        r1.start();
        r2.start();
        r3.start();
       
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        
    }

}
