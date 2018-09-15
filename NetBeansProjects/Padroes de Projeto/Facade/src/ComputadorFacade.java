

public class ComputadorFacade {

    private Cpu cpu = null;
    private Memoria memoria = null;
    private HardDrive hardDrive = null;

    public ComputadorFacade(Cpu cpu, Memoria memoria, HardDrive hardDrive) {
        this.cpu = cpu;
        this.memoria = memoria;
        this.hardDrive = hardDrive;
    }

    public void ligarComputador() {
        cpu.start();
        hardDrive.read(123, 321);
        memoria.load(3, "123.221.321.111");
        cpu.execute();
        memoria.free(1, "123.221.321.111");
    }
}


class Cpu {

    public void start() {
        System.out.println("inicialização inicial");
    }

    public void execute() {
        System.out.println("executa algo no processador");
    }

    public void load() {
        System.out.println("carrega registrador");
    }

    public void free() {
        System.out.println("libera registradores");
    }
}

class Memoria {

    public void load(int position, String info) {
        System.out.println("carrega dados na memória");
    }

    public void free(int position, String info) {
        System.out.println("libera dados da memória");
    }
}

class HardDrive {

    public void read(int startPosition, int size) {
        System.out.println("lê dados do HD");
    }

    public void write(int position, String info) {
        System.out.println("escreve dados no HD");
    }
}

