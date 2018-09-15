package exercicios.datas;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author 78522
 */
public class Exercicio13 {

    public static void main(String[] args) {
        Date date = new Date();

        System.out.println("Date Time Short:");
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        System.out.println(df.format(date));

        System.out.println("\nDate Time Medium:");
        df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        System.out.println(df.format(date));

        System.out.println("\nDate Time Long:");
        df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        System.out.println(df.format(date));

        System.out.println("\nDate Short:");
        df = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println(df.format(date));

        System.out.println("\nDate Medium:");
        df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println(df.format(date));

        System.out.println("\nDate Long:");
        df = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(df.format(date));

    }
}
