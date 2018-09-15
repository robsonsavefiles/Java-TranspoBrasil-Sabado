package avaliacao;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Escreva um programa que imprima a data e hora atual no console utilizando o formato 26/11/2015 08:00.
 *
 * @author 78522
 */
public class Questao06 {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println(sdf.format(new Date()));
    }
}
