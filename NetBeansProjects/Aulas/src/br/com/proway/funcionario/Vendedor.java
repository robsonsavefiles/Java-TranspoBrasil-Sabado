package aula.pkg009;

/**
 *
 * @author 78522
 */
public class Vendedor extends Cargo {

    private double totalVendas;
    private double percentualComissao;

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public Vendedor(Long id, String nome, double salarioBase, double totalVendas, double percentualComissao) {
        super(id, nome, salarioBase);
        this.totalVendas = totalVendas;
        this.percentualComissao = percentualComissao;
    }

    @Override
    public double getSalarioTotal() {
        return getSalarioBase() + (totalVendas * percentualComissao);
    }
}
