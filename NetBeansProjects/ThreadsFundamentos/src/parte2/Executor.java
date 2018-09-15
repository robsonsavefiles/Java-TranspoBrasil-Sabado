
package parte2;


public class Executor extends Thread  {
    
    public static void main(String[] args) {
        Balde balde = new Balde();
        Removedor r1 = new Removedor(balde);
        Removedor r2 = new Removedor(balde);
        Colocador c1 = new Colocador(balde);
        Colocador c2 = new Colocador(balde);
        
        r1.start();
        r2.start();
       
        c1.start();
        c2.start();
        
    }

}
