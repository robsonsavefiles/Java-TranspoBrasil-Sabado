/*
Escreva um programa que recebe a data do seu aniversario em formato texto, em seguida converta para o tipo Date e em seguida
converta para  o tipo Date e em segunda imprima qual sera o dia da semana dos seus proximos 10 aniversarios.
*/
package br.com.proway.java.datas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Exer4_datas {
    
       public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        System.out.println("Forneça seu aniversário no formato dd/MM");
        String sData = teclado.nextLine();

        Date data1;
        try {
            data1 = sdf.parse(sData);

            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(data1);
            cal1.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

            Calendar cal2 = Calendar.getInstance();

            if (cal1.before(cal2)) {
                cal1.add(Calendar.YEAR, 1);
            }

            System.out.println("Dias dos próximos 10 aniversários: ");

            for (int i = 0; i < 10; i++) {
                System.out.println(cal1.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_FORMAT, Locale.getDefault()));
                cal1.add(Calendar.YEAR, 1);
            }
        } catch (ParseException ex) {
            Logger.getLogger(Exer4_datas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


