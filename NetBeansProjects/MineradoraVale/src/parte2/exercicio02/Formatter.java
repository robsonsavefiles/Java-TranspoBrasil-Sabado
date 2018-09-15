package parte2.exercicio02;

import java.text.NumberFormat;

/**
 *
 * @author 78522
 */
public class Formatter {

    public static String formatValor(double valor) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        return String.valueOf(nf.format(valor));
    }
}
