package br.com.proway.java.datas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.Data;

public class TestesDatas {

    public static void main(String[] args) {
//
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//
        Date agora = new Date();// data atual criando um estancia de date
        System.out.println(agora);
//
        Date outra = new Date(0);
        System.out.println(outra);
//        
        System.out.println(agora.getTime());//pegar em segundos

        Date dataAtual = new Date();
        System.out.println(dataAtual);
        Locale brasil = new Locale("pt", "BR");
        Locale usa = Locale.US;
        Locale china = Locale.CHINESE;
        Calendar calendario = Calendar.getInstance();
        System.out.println(calendario.getTime());

        Calendar calendarioBrasil = Calendar.getInstance(brasil);
        Calendar calendarioUS = Calendar.getInstance(usa);
        Calendar calendarioChina = Calendar.getInstance(china);
        System.out.println(calendarioBrasil.getTime());
        System.out.println(calendarioUS.getTime());
        System.out.println(calendarioChina.getTime());
        System.out.println(calendarioBrasil.getTimeZone());
        System.out.println(calendarioUS.getTimeZone());
        System.out.println(calendarioChina.getTimeZone());

        System.out.println(calendario.getDisplayName(Calendar.DAY_OF_WEEK,
                Calendar.LONG, brasil));
        System.out.println(calendarioBrasil.getDisplayName(Calendar.DAY_OF_WEEK,
                Calendar.LONG, usa));
        System.out.println(calendarioBrasil.getDisplayName(Calendar.DAY_OF_WEEK,
                Calendar.LONG, china));

        DateFormat formatoBrasilCurto = DateFormat.getDateInstance(DateFormat.SHORT, brasil);
        DateFormat formatoUSCurto = DateFormat.getDateInstance(DateFormat.SHORT, usa);
        DateFormat formatoChinaCurto = DateFormat.getDateInstance(DateFormat.SHORT, china);

        System.out.println(formatoBrasilCurto.format(dataAtual));
        System.out.println(formatoUSCurto.format(dataAtual));
        System.out.println(formatoChinaCurto.format(dataAtual));

        DateFormat formatoBrasilMedio = DateFormat.getDateInstance(DateFormat.MEDIUM, brasil);
        DateFormat formatoUSMedio = DateFormat.getDateInstance(DateFormat.MEDIUM, usa);
        DateFormat formatoChinaMedio = DateFormat.getDateInstance(DateFormat.MEDIUM, china);

        System.out.println(formatoBrasilMedio.format(dataAtual));
        System.out.println(formatoUSMedio.format(dataAtual));
        System.out.println(formatoChinaMedio.format(dataAtual));

        DateFormat formatoBrasilLong = DateFormat.getDateInstance(DateFormat.LONG, brasil);
        DateFormat formatoUSLong = DateFormat.getDateInstance(DateFormat.LONG, usa);
        DateFormat formatoChinaLong = DateFormat.getDateInstance(DateFormat.LONG, china);

        System.out.println(formatoBrasilLong.format(dataAtual));
        System.out.println(formatoUSLong.format(dataAtual));
        System.out.println(formatoChinaLong.format(dataAtual));

        DateFormat formatoBrasilFull = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        DateFormat formatoUSFull = DateFormat.getDateInstance(DateFormat.FULL, usa);
        DateFormat formatoChinaFull = DateFormat.getDateInstance(DateFormat.FULL, china);

        System.out.println(formatoBrasilFull.format(dataAtual));
        System.out.println(formatoUSFull.format(dataAtual));
        System.out.println(formatoChinaFull.format(dataAtual));
        String[] availableIDs = TimeZone.getAvailableIDs();
        for (String availableID : availableIDs) {
            System.out.println(availableID);
        }
        TimeZone timeZonedefault = TimeZone.getDefault();
        System.out.println(timeZonedefault);
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
        DateFormat formatoBrasilFullDT = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, brasil);
        System.out.println(TimeZone.getTimeZone("Asia/Tokyo"));
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        System.out.println(formatoBrasilFullDT.format(c.getTime()));
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
        c = Calendar.getInstance(timeZonedefault);
        formatoBrasilFullDT = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, brasil);
        System.out.println(formatoBrasilFullDT.format(c.getTime()));

        try {
            System.out.println(formatoBrasilCurto.parse("12/12/2015"));
        } catch (ParseException ex) {
            Logger.getLogger(TestesDatas.class.getName()).log(Level.SEVERE, null, ex);

        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        System.out.println(dataAtual);
        try {
            Data data = (Data) sdf.parse("1990/12/24");
            System.out.println(data);

        } catch (ParseException ex) {
            ex.printStackTrace();
            Logger.getLogger(TestesDatas.class.getName()).log(Level.SEVERE, null, ex);
        }

        Calendar calendar = Calendar.getInstance();//data atual 
        System.out.println(calendar.getTime());// retorna um date getTime
//
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        System.out.println(calendar.getTime());// pega uma data, mais 10 dias
//
        Calendar calendar2 = Calendar.getInstance();
        System.out.println(calendar2.getTime());

        calendar.add(calendar.HOUR_OF_DAY, 10);
        System.out.println(calendar.getTime());

        Date d1 = calendar.getTime();
        calendar.roll(Calendar.DAY_OF_MONTH, 20);
        System.out.println(calendar.getTime());

        Date d2 = calendar.getTime();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d2);
        Calendar cal2 = Calendar.getInstance();
        System.out.println(cal1.after(cal1));
        System.out.println(cal1.before(cal2));
        System.out.println(cal1.get(Calendar.DAY_OF_WEEK));
        System.out.println(cal1.get(Calendar.YEAR));
        System.out.println(cal1.get(Calendar.MONTH));
        System.out.println(cal1.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal1.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal1.get(Calendar.MINUTE));
        System.out.println(cal1.get(Calendar.SECOND));
        System.out.println(cal1.get(Calendar.DAY_OF_YEAR));
    }
}
