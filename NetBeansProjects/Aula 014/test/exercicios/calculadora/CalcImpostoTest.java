package exercicios.calculadora;

import exercicios.calculadora.CalcImposto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Se salario <= 1800, imposto = 0;
 * Se salario > 1800 E salario < 2400, imposto = 7.5% do salario;
 * Se salario >= 2400 E salario < 3500, imposto = 15% do salario;
 * Se salario >= 3500, imposto = 27.5%.
 *
 * @author Tiago Dionesto
 */
public class CalcImpostoTest {

    private static final double PERCENTUAL_NIVEL_0 = 0.000;
    private static final double PERCENTUAL_NIVEL_1 = 0.075;
    private static final double PERCENTUAL_NIVEL_2 = 0.150;
    private static final double PERCENTUAL_NIVEL_3 = 0.275;

    private CalcImposto calculadora;

    @Before
    public void setup() {
        calculadora = new CalcImposto();
    }

    @Test
    public void testSalarioSemImposto() {
        testImposto(PERCENTUAL_NIVEL_0, 0);
        testImposto(PERCENTUAL_NIVEL_0, 1800);
    }

    @Test
    public void testSalarioComImpostoNivel1() {
        testImposto(PERCENTUAL_NIVEL_1, 1800.01);
        testImposto(PERCENTUAL_NIVEL_1, 2399.99);
    }

    @Test
    public void testSalarioComImpostoNivel2() {
        testImposto(PERCENTUAL_NIVEL_2, 2400.01);
        testImposto(PERCENTUAL_NIVEL_2, 3499.99);
    }

    @Test
    public void testSalarioComImpostoNivel3() {
        testImposto(PERCENTUAL_NIVEL_3, 3500);
        testImposto(PERCENTUAL_NIVEL_3, 5000);
    }

    private void testImposto(double porcentagem, double salario) {
        double esperado = salario * porcentagem;
        double resultado = calculadora.calcularImposto(salario);
        Assert.assertEquals(esperado, resultado, 0.0);
    }
}
