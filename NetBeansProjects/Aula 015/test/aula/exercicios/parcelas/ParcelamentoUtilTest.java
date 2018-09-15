package aula.exercicios.parcelas;

import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author 78522
 */
public class ParcelamentoUtilTest {

    @Test
    public void testParcelamento() {
        testParcelamento(50, 3);
        testParcelamento(100.58, 7);
        testParcelamento(300, 4);
        testParcelamento(199, 2);
    }

    public void testParcelamento(double valorCompra, int qtdParcelas) {
        List<Parcela> parcelas = ParcelamentoUtil.parcelar(valorCompra, qtdParcelas);

        testValorParcelas(parcelas, valorCompra / qtdParcelas);
        testQuantidadeParcelas(parcelas, qtdParcelas);
        testValorTotalParcelas(parcelas, valorCompra);
    }

    public void testValorParcelas(List<Parcela> parcelas, double resultadoEsperado) {
        for (int i = 0; i < parcelas.size(); i++) {
            if (i != parcelas.size() - 1) {
                Assert.assertEquals(resultadoEsperado, parcelas.get(i).getValor(), 0.01);
            } else {
                Assert.assertEquals(resultadoEsperado, parcelas.get(i).getValor(), parcelas.size() / 100.0);
            }
        }
    }

    public void testQuantidadeParcelas(List<Parcela> parcelas, int resultadoEsperado) {
        Assert.assertEquals(resultadoEsperado, parcelas.size());
    }

    public void testValorTotalParcelas(List<Parcela> parcelas, double resultadoEsperado) {
        double soma = 0;
        for (Parcela parcela : parcelas) {
            soma += parcela.getValor();
        }
        Assert.assertEquals(resultadoEsperado, soma);
    }
}
