package exercicios.datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class Exercicio10 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Forne�a a primeira data no formato dd/MM/yyyy");
        String sData1 = teclado.nextLine();
        System.out.println("Forne�a a segunda data no formato dd/MM/yyyy");
        String sData2 = teclado.nextLine();

        Date data1;
        Date data2;
        try {
            data1 = sdf.parse(sData1);
            data2 = sdf.parse(sData2);

            switch (data1.compareTo(data2)) {
                case -1:
                    System.out.println("A primeira data � menor do que a segunda data.");
                    break;
                case 1:
                    System.out.println("A primeira data � maior do que a segunda data.");
                    break;
                default:
                    System.out.println("A primeira data � igual a segunda data.");
                    break;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Exercicio10.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
