package parte2.exercicio02;

import parte2.exercicio02.recurso.Fonte;
import parte2.exercicio02.recurso.Deposito;
import parte2.exercicio02.operario.OperarioKg;
import parte2.exercicio02.operario.Operario;
import parte2.exercicio02.operario.OperarioEnergia;
import parte2.exercicio02.maquina.MaquinaGrande;
import parte2.exercicio02.maquina.Maquina;
import parte2.exercicio02.maquina.MaquinaPequena;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 78522
 */
public class Mineradora {

    private Fonte fonte = new Fonte();
    private Deposito deposito = new Deposito();
    private final List<Operario> operarios = new ArrayList();
    private final List<Maquina> maquinas = new ArrayList();

    public Fonte getFonte() {
        return fonte;
    }

    public void setFonte(Fonte fonte) {
        this.fonte = fonte;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public List<Operario> getOperarios() {
        return operarios;
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public void addMaquina(Maquina maquina) {
        maquinas.add(maquina);
    }

    public void addOperario(Operario operario) {
        operarios.add(operario);
    }

    public boolean removeMaquinaGrande() {
        for (Maquina maquina : maquinas) {
            if (maquina instanceof MaquinaGrande) {
                maquina.setAtivo(false);
                maquinas.remove(maquina);
                return true;
            }
        }
        return false;
    }

    public boolean removeMaquinaPequena() {
        for (Maquina maquina : maquinas) {
            if (maquina instanceof MaquinaPequena) {
                maquina.setAtivo(false);
                maquinas.remove(maquina);
                return true;
            }
        }
        return false;
    }

    public boolean removeOperarioEnergia() {
        for (Operario operario : operarios) {
            if (operario instanceof OperarioEnergia) {
                operario.setAtivo(false);
                operarios.remove(operario);
                return true;
            }
        }
        return false;
    }

    public boolean removeOperarioKg() {
        for (Operario operario : operarios) {
            if (operario instanceof OperarioKg) {
                operario.setAtivo(false);
                operarios.remove(operario);
                return true;
            }
        }
        return false;
    }

    public String getSituacao() {
        String retorno = "Situa��o da Mineradora:";
        retorno += "\n" + fonte.getSituacao();
        retorno += "\n" + deposito.getSituacao();
        return retorno;
    }

    public String getAtivos() {
        String retorno = "Oper�rios e M�quinas ativas:";
        retorno += "\nOper�rios: " + operarios.size();
        retorno += "\nM�quinas: " + maquinas.size();
        return retorno;
    }

    public String getProdutividadeMaquinas() {
        String retorno = "Consumo e Produtividade das M�quinas:";
        retorno += "\nConsumo Energia: " + getConsumoMaquinaEnergia() + "kw/s";
        retorno += "\nProdu��o Min�rio: " + getProdutividadeMaquinaMinerio() + "kg";
        return retorno;
    }

    public double getConsumoMaquinaEnergiaMax() {
        double somaEnergia = 0;
        for (Maquina maquina : maquinas) {
            somaEnergia += maquina.getGastoEnergia();
        }
        return somaEnergia;
    }

    public double getProdutividadeMaquinaMinerioMax() {
        double somaProducao = 0;
        for (Maquina maquina : maquinas) {
            somaProducao += maquina.getCapacidadeMineracao();
        }
        return somaProducao;
    }

    public double getConsumoMaquinaEnergia() {
        double somaEnergia = 0;
        for (Maquina maquina : maquinas) {
            somaEnergia += maquina.getLastConsumo();
        }
        return somaEnergia;
    }

    public double getProdutividadeMaquinaMinerio() {
        double somaProducao = 0;
        for (Maquina maquina : maquinas) {
            somaProducao += maquina.getLastProducao();
        }
        return somaProducao;
    }

    public String getProdutividadeOperarios() {
        String retorno = "Produtividade dos Oper�rios:";
        retorno += "\nProdu��o Energia: " + getProdutividadeOperarioEnergia() + " kw/s";
        retorno += "\nRemo��o Min�rio: " + getProdutividadeOperarioMinerio() + " kg";
        return retorno;
    }

    public double getProdutividadeOperarioEnergiaMax() {
        double somaEnergia = 0;
        for (Operario operario : operarios) {
            if (operario instanceof OperarioEnergia) {
                somaEnergia += operario.getProdutividade();
            }
        }
        return somaEnergia;
    }

    public double getProdutividadeOperarioMinerioMax() {
        double somaProducao = 0;
        for (Operario operario : operarios) {
            if (operario instanceof OperarioKg) {
                somaProducao += operario.getProdutividade();
            }
        }
        return somaProducao;
    }

    public double getProdutividadeOperarioEnergia() {
        double somaEnergia = 0;
        for (Operario operario : operarios) {
            if (operario instanceof OperarioEnergia) {
                somaEnergia += operario.getLastOperacao();
            }
        }
        return somaEnergia;
    }

    public double getProdutividadeOperarioMinerio() {
        double somaProducao = 0;
        for (Operario operario : operarios) {
            if (operario instanceof OperarioKg) {
                somaProducao += operario.getLastOperacao();
            }
        }
        return somaProducao;
    }
}
