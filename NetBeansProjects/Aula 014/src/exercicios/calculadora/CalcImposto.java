package exercicios.calculadora;

/**
 *
 * @author 78522
 */
public class CalcImposto {

    public <T extends Number> double calcularImposto(T salario) {
        double salarioValue = salario.doubleValue();
        double percentual = 0;
        if (salarioValue >= 3500) {
            percentual = 0.275;
        } else if (salarioValue >= 2400) {
            percentual = 0.15;
        } else if (salarioValue > 1800) {
            percentual = 0.075;
        }
        return salarioValue * percentual;
    }
}
