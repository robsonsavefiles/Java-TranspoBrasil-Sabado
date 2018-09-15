package parte2.exercicio02.recurso;

/**
 *
 * @author 78522
 */
public abstract class Recurso {

    private final String nomeRecurso;
    private double qtdMax;
    private final double qtdUpgrade;
    private double qtdRecurso;
    private double qtdRemovida;

    public Recurso(String nomeRecurso, double qtdMaxRecurso, double qtdUpgrade) {
        this.nomeRecurso = nomeRecurso;
        this.qtdMax = qtdMaxRecurso;
        this.qtdUpgrade = qtdUpgrade;
    }

    public synchronized void adicionar(double qtd) throws InterruptedException {
        while (qtdRecurso + qtd > qtdMax) {
            wait();
        }

        qtdRecurso += qtd;
        notifyAll();
    }

    public synchronized void remover(double qtd) throws InterruptedException {
        while (qtdRecurso - qtd < 0) {
            wait();
        }

        qtdRecurso -= qtd;
        qtdRemovida += qtd;
        notifyAll();
    }

    public String getNomeRecurso() {
        return nomeRecurso;
    }

    public double getQtdMaxRecurso() {
        return qtdMax;
    }

    public double getQtdRecurso() {
        return qtdRecurso;
    }

    public void setQtdRecurso(double qtdRecurso) {
        this.qtdRecurso = qtdRecurso;
    }

    public double getQtdRemovida() {
        return qtdRemovida;
    }

    public void setQtdRemovida(double qtdRemovida) {
        this.qtdRemovida = qtdRemovida;
    }

    public String getSituacao() {
        return nomeRecurso + " (" + qtdRecurso + "/" + qtdMax + ")";
    }

    public void upgrade() {
        qtdMax += qtdUpgrade;
    }

    public boolean downgrade() {
        if (qtdMax - qtdUpgrade >= 0) {
            qtdMax -= qtdUpgrade;
            return true;
        }
        return false;
    }
}
