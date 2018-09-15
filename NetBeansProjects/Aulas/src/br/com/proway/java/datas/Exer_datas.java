/*
 adicionar 10 dias a data atual
 adicionar imprimir a data de hoje
 imprimir a hora atual
 imprimir o ano atual;
 imprimir a data aqui a 10 anos
 imprimir a hora atual com a locale brasil
 imprimir a hora atual com a locale us
 imprimir a data atual com a locale brasil 
 imprimir a data atual com a locale chines
 */
package br.com.proway.java.datas;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javafx.scene.input.DataFormat;
import javax.xml.crypto.Data;

public class Exer_datas {

    public static void main(String[] args) {

        System.out.println("Data daqui 10 dias:");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 10);
        System.out.println(cal.getTime());
        
        System.out.println("\nData de hoje:");
        cal = Calendar.getInstance();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println(df.format(cal.getTime()));
        
        System.out.println("\nHora atual:");
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        
        System.out.println("\nAno atual:");
        System.out.println(cal.get(Calendar.YEAR));
        
        System.out.println("\nData daqui 10 anos:");
        cal.add(Calendar.YEAR, 10);
        System.out.println(df.format(cal.getTime()));
        
        System.out.println("\nHora atual com locale Brasil:");
        cal = Calendar.getInstance();
        Locale locBR = new Locale("pt", "BR");
        df = DateFormat.getTimeInstance(DateFormat.LONG, locBR);
        System.out.println(df.format(cal.getTime()));
        
        System.out.println("\nHora atual com locale US:");
        Locale locUS = Locale.US;
        df = DateFormat.getTimeInstance(DateFormat.LONG, locUS);
        System.out.println(df.format(cal.getTime()));
        
        System.out.println("\nData atual com locale Brasil:");
        df = DateFormat.getDateInstance(DateFormat.LONG, locBR);
        System.out.println(df.format(cal.getTime()));
        
        System.out.println("\nData atual com locale Chines:");
        Locale locCH = Locale.CHINESE;
        df = DateFormat.getDateInstance(DateFormat.LONG, locCH);
        System.out.println(df.format(cal.getTime()));
    }

}
