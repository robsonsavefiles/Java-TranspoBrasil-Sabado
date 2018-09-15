
package facade;

/**
 *
 * @author 89087
 */
public class ComputadorFacade {
    
    private HD hd;
    private RAM  ram;
    private CPU cpu;
    
  
    public ComputadorFacade(HD hd, RAM ram, CPU cpu) {
        this.hd = hd;
        this.ram = ram;
        this.cpu = cpu;
    }
    
     public void ligarComputador(){
      cpu.start();
      cpu.processa("TESTE HD");
      hd.write("Inicial", "Test");
      hd.read("inicial");
      
      cpu.processa("TESTE RAM");
      ram.write("Inicial", "Test");
      ram.read("Inicial");
        
    }

}
