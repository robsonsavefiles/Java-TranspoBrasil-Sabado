package aula.pkg009;

/**
 *
 * @author 78522
 */
public class Gerente extends Cargo {

    private double adicionalGratificacao;

    public double getAdicionalGratificacao() {
        return adicionalGratificacao;
    }

    public void setAdicionalGratificacao(double adicionalGratificacao) {
        this.adicionalGratificacao = adicionalGratificacao;
    }

    public Gerente(Long id, String nome, double salarioBase, double adicionalGratificacao) {
        super(id, nome, salarioBase);
        this.adicionalGratificacao = adicionalGratificacao;
    }

    @Override
    public double getSalarioTotal() {
        return getSalarioBase() + adicionalGratificacao;
    }
}
