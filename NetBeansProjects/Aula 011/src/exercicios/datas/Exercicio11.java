package exercicios.datas;

import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author 78522
 */
public class Exercicio11 {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        for (int i = 0; i < 24; i++) {
            System.out.println("Dia da semana da prestação " + (i + 1) + ":");
            cal.add(Calendar.DAY_OF_MONTH, 30);
            System.out.println(cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));
            System.out.println("");
        }
    }
}
