
package facade;

/**
 *
 * @author 89087
 */
public class Executor {
    
    public static void main(String[] args) {
        ComputadorFacade computador = new ComputadorFacade(new HD(),new RAM(),new CPU());
        
        computador.ligarComputador();
    }

}
