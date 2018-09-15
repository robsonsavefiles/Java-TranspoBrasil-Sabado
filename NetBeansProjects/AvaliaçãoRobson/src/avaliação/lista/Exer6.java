/*
 *
06)Escreva um programa que imprima a data e hora atual no console utilizando o formato 26/11/2015 08:00.
 */

package avaliação.lista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/**
 *
 * @author 89087
 */
public class Exer6 {
    
     public static void main(String[] args) {
        
        Date dataAtual = new Date();
        Locale brasil = new Locale("pt", "BR");

        Calendar calendario = Calendar.getInstance();
      
        DateFormat formatoBrasilCurto2 = DateFormat.getDateInstance(DateFormat.MEDIUM,brasil);
        System.out.print("Data:");
        System.out.println(formatoBrasilCurto2.format(dataAtual));
        
        DateFormat formatoBrasilCurto1 = DateFormat.getTimeInstance(DateFormat.SHORT, brasil);
        System.out.print("Hora:");
        System.out.println(formatoBrasilCurto1.format(dataAtual));
        
        
        //forma Simples 
        
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        System.out.println(sdf.format(new Date()));
        
        
}
}
