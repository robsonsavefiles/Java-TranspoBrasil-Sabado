package dados;

public class Deposito {

    private int qtdEstoque = 0;
    private final int MAX_ESTOQUE = 1000;
    private final int MIN_ESTOQUE = 0;

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public synchronized void addMaquinaGrande() throws InterruptedException {

        while (qtdEstoque >= MAX_ESTOQUE) {

            wait();
        }

        qtdEstoque += 10;
        System.out.println("+10 ao estoque - " + qtdEstoque);

        notifyAll();

    }

    public synchronized void addMaquinaPequena() throws InterruptedException {

        while (qtdEstoque <= MAX_ESTOQUE) {

            wait();
        }

        qtdEstoque += 2;
        System.out.println("+2 ao estoque - " + qtdEstoque);

        notifyAll();

    }

    public synchronized void addOperarioKG() throws InterruptedException {

        while (qtdEstoque >= MIN_ESTOQUE) {

            wait();
        }

        qtdEstoque -= 5;
        System.out.println("-5 ao estoque - " + qtdEstoque);

        notifyAll();

    }

}
