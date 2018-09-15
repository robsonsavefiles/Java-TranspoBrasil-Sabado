
package facade;

import classes.CPU;
import classes.HD;
import classes.RAM;

public class ComputadorFacade {
    
    private HD hd;
    private RAM ram;
    private CPU cpu;

    public ComputadorFacade(HD hd, RAM ram, CPU cpu) {
        this.hd = hd;
        this.ram = ram;
        this.cpu = cpu;
    }
    
    public void ligarComputador() {
        cpu.start();
        
        cpu.process("test HD");
        hd.write("inicial", "TESTE");
        hd.read("inicial");
        
        cpu.process("test RAM");
        ram.write("inicial", "TESTE");
        ram.read("inicial");
        
    }

}
