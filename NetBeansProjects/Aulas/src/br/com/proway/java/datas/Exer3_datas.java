/*
 *Escreva a data e hora atual no formato Short
 Escreva a data e hora atual no formato Medium
 Escreva a data e hora atual no formato Long
 Escreva a data e hora atual no formato Short

 Escreva a data atual no formato Short
 Escreva a data atual no formato Medium
 Escreva a data atual no formato Long
 */
package br.com.proway.java.datas;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Exer3_datas {

    public static void main(String[] args) {

        Date dataAtual = new Date();
        System.out.println(dataAtual);
        Locale brasil = new Locale("pt", "BR");

        Calendar calendario = Calendar.getInstance();
        System.out.println(calendario.getTime());

        Calendar calendarioBrasil = Calendar.getInstance(brasil);
        
        DateFormat formatoBrasilCurto = DateFormat.getDateInstance(DateFormat.SHORT, brasil);
        System.out.println(formatoBrasilCurto.format(dataAtual));
        
        DateFormat formatoBrasilCurto1 = DateFormat.getTimeInstance(DateFormat.SHORT, brasil);
        System.out.println(formatoBrasilCurto1.format(dataAtual));
        
        DateFormat formatoBrasilCurto2 = DateFormat.getDateInstance(DateFormat.MEDIUM,brasil);
        System.out.println(formatoBrasilCurto2.format(dataAtual));
        
        DateFormat formatoBrasilCurto3 = DateFormat.getTimeInstance(DateFormat.MEDIUM, brasil);
        System.out.println(formatoBrasilCurto3.format(dataAtual));
        
        DateFormat formatoBrasilCurto4 = DateFormat.getDateInstance(DateFormat.LONG,brasil);
        System.out.println(formatoBrasilCurto4.format(dataAtual));
        
        DateFormat formatoBrasilCurto5 = DateFormat.getTimeInstance(DateFormat.LONG, brasil);
        System.out.println(formatoBrasilCurto5.format(dataAtual));
        
        
        
    }
}
