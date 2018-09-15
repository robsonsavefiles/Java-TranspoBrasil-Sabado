package aula.exercicios.parcelas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 78522
 */
public class ParcelamentoUtil {

    static List<Parcela> parcelar(double valorCompra, int qtdParcelas) {
        List<Parcela> retorno = new ArrayList();
        double valorParcela = arredondarDuasCasas(valorCompra / qtdParcelas);
        double total = 0;

        for (int i = 0; i < qtdParcelas; i++) {
            if (i == qtdParcelas - 1) {
                valorParcela = arredondarDuasCasas(valorCompra - total);
            }
            retorno.add(new Parcela(i, valorParcela));
            total += valorParcela;
        }

        return retorno;
    }

    private static double arredondarDuasCasas(double valor) {
        return (int) (valor * 100) / 100.0;
    }

}
