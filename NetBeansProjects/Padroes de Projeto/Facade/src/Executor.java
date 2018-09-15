
public class Executor {
    public static void main(String[] args) {
        ComputadorFacade computador = new ComputadorFacade(new Cpu(), 
                new Memoria(), 
                new HardDrive());
        
        computador.ligarComputador();
    }
}
