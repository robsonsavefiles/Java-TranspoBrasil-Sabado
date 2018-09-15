/*
2)A partir da data atual imprima o dia da semana que recai a  data de pagamento de um carnê de 24 prestaçoes, sendo 
 o primeiro pagamento 30 dias apos a data atual e os demais pagamentos tambem  com uma diferença de 1 mes
*/
package br.com.proway.java.datas;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class Exer2_datas {
    public static void main(String[] args) {
        
        Date agora = new Date();
        Calendar calendario = Calendar.getInstance();
       
        calendario.setTime(new Date());
        for(int i = 0; i<24;i++){
            calendario.add(Calendar.DAY_OF_MONTH,10);
            
            System.out.printf(calendario.getTime()+"===>"+calendario.getDisplayName(Calendar.DAY_OF_MONTH,Calendar.LONG,Locale.getDefault()));
        }
        
        
        
    }
}
