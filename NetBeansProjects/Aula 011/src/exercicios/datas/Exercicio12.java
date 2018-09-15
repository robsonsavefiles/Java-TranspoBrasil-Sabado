package exercicios.datas;

import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author 78522
 */
public class Exercicio12 {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        for (int i = 0; i < 24; i++) {
            System.out.println("Dia da semana da prestação " + (i + 1) + ":");
            cal.add(Calendar.MONTH, 1);
            System.out.println(cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_FORMAT, Locale.getDefault()));
            System.out.println("");
        }
    }
}
