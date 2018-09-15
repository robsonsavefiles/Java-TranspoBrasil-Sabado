package exemplos.datas;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {

//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//        Date agora = new Date();
//        System.out.println(agora);
//
//        Date outra = new Date(0);
//        System.out.println(outra);
//
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_MONTH, 10);
//
//        System.out.println(cal.getTime());
        Locale br = new Locale("pt", "BR");
        Locale us = Locale.US;
        Locale ch = Locale.CHINA;

        Calendar calendarioBR = Calendar.getInstance(br);
        Calendar calendarioUS = Calendar.getInstance(us);
        Calendar calendarioCH = Calendar.getInstance(ch);

        System.out.println(calendarioBR.getTime());
        //System.out.println(calendarioBR.getTimeZone());
        System.out.println(calendarioBR.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, br));
        DateFormat dfBR = DateFormat.getDateInstance(DateFormat.SHORT, br);
        System.out.println(dfBR.format(calendarioBR.getTime()));

        System.out.println(calendarioUS.getTime());
        //System.out.println(calendarioUS.getTimeZone());
        System.out.println(calendarioUS.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, us));
        DateFormat dfUS = DateFormat.getDateInstance(DateFormat.SHORT, us);
        System.out.println(dfUS.format(calendarioUS.getTime()));

        System.out.println(calendarioCH.getTime());
        //System.out.println(calendarioCH.getTimeZone());
        System.out.println(calendarioCH.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, ch));
        DateFormat dfCH = DateFormat.getDateInstance(DateFormat.SHORT, ch);
        System.out.println(dfCH.format(calendarioCH.getTime()));

    }

}
