/*
 1)solicite duas datas para o usuario e informe se a primeira data é maior ou igual a segunda.
 */
package br.com.proway.java.datas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class Exer1_datas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Locale brasil = new Locale("pt", "BR");
        DateFormat formatoBrasilCurto = DateFormat.getDateInstance(DateFormat.SHORT, brasil);

        
        System.out.println("Informe a Primeira Data:");
        String d1 = teclado.nextLine();
        System.out.println("Informe a Segunda Data:");
        String data2 = teclado.nextLine();
       
        try {
            Date dnew = formatoBrasilCurto.parse(d1);
            Date d2 = formatoBrasilCurto.parse(data2);
            switch (dnew.compareTo(d2)) {
                case 1:
                    System.out.println(" a primeira data é maior");
                    break;
                case 0:
                    System.out.println(" a datas sao iguais");
                    break;

                case -1:
                    System.out.println(" a segunda data é Maior");
                    break;
                default:
            }
        } catch (ParseException ex) {
            Logger.getLogger(Exer1_datas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
