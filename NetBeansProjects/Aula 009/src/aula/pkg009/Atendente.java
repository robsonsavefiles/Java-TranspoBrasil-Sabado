package aula.pkg009;

/**
 *
 * @author 78522
 */
public class Atendente extends Cargo {

    public Atendente(Long id, String nome, double salarioBase) {
        super(id, nome, salarioBase);
    }

    @Override
    public double getSalarioTotal() {
        return getSalarioBase();
    }
}
