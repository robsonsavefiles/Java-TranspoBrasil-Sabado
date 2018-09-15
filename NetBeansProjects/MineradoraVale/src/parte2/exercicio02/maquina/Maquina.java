package parte2.exercicio02.maquina;

import java.util.logging.Level;
import java.util.logging.Logger;
import parte2.exercicio02.recurso.Deposito;
import parte2.exercicio02.recurso.Fonte;

/**
 *
 * @author 78522
 */
public abstract class Maquina extends Thread {

    private Deposito deposito;
    private Fonte fonte;
    private double gastoEnergia;
    private double capacidadeMineracao;
    private boolean ativo = true;

    private double lastProducao = 0;
    private double lastConsumo = 0;

    public Maquina(Deposito deposito, Fonte fonte, double gastoEnergia, double capacidadeMineracao) {
        this.deposito = deposito;
        this.fonte = fonte;
        this.gastoEnergia = gastoEnergia;
        this.capacidadeMineracao = capacidadeMineracao;
        start();
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public Fonte getFonte() {
        return fonte;
    }

    public void setFonte(Fonte fonte) {
        this.fonte = fonte;
    }

    public double getGastoEnergia() {
        return gastoEnergia;
    }

    public void setGastoEnergia(double gastoEnergia) {
        this.gastoEnergia = gastoEnergia;
    }

    public double getCapacidadeMineracao() {
        return capacidadeMineracao;
    }

    public void setCapacidadeMineracao(double capacidadeMineracao) {
        this.capacidadeMineracao = capacidadeMineracao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getLastProducao() {
        return lastProducao;
    }

    public double getLastConsumo() {
        return lastConsumo;
    }

    public double getRatioMinerioEnergia() {
        return capacidadeMineracao / gastoEnergia;
    }

    @Override
    public void run() {
        super.run();
        try {
            while (ativo) {
                double energiaUtilizavel = fonte.getQtdRecurso() < getGastoEnergia() ? fonte.getQtdRecurso() : getGastoEnergia();
                double depositoUtilizavel = deposito.getQtdMaxRecurso() - deposito.getQtdRecurso();

                double minerioTeorico = energiaUtilizavel * getCapacidadeMineracao() / getGastoEnergia();

                if (minerioTeorico > depositoUtilizavel) {
                    minerioTeorico = depositoUtilizavel;
                }

                double energiaTeorica = minerioTeorico / getRatioMinerioEnergia();

                fonte.remover(energiaTeorica);
                deposito.adicionar(minerioTeorico);

                lastConsumo = energiaTeorica;
                lastProducao = minerioTeorico;

                sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Maquina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
