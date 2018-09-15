package parte2.exercicio02.operario;

import java.util.logging.Level;
import java.util.logging.Logger;
import parte2.exercicio02.recurso.Recurso;

/**
 *
 * @author 78522
 */
public abstract class Operario extends Thread {

    private Recurso recurso;
    private double produtividade;
    private boolean ativo = true;

    private double lastOperacao = 0;

    public Operario(Recurso recurso, double produtividade) {
        this.recurso = recurso;
        this.produtividade = produtividade;
        start();
    }

    public abstract void operar();

    @Override
    public void run() {
        super.run();
        while (ativo) {
            operar();
        }
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public double getProdutividade() {
        return produtividade;
    }

    public void setProdutividade(double produtividade) {
        this.produtividade = produtividade;
    }

    public double getLastOperacao() {
        return lastOperacao;
    }

    public void setLastOperacao(double lastOperacao) {
        this.lastOperacao = lastOperacao;
    }

}
