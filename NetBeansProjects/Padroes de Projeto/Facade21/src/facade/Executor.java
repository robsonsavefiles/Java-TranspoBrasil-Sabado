
package facade;

import classes.CPU;
import classes.HD;
import classes.RAM;

public class Executor {
    public static void main(String[] args) {
        ComputadorFacade computador = new ComputadorFacade(
                new HD(), 
                new RAM(), 
                new CPU());
        
        computador.ligarComputador();
    }

}
