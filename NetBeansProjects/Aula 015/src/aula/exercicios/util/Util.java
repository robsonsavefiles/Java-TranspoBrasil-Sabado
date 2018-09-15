package aula.exercicios.util;

import java.time.LocalDate;

/**
 *
 * @author 78522
 */
public class Util {

    public static <T extends Number> boolean estaNoIntervalo(T valorDe, T valorAte, T valorComparativo) {
        double de = valorDe.doubleValue();
        double ate = valorAte.doubleValue();
        double valor = valorComparativo.doubleValue();
        if (de > ate || de == ate) {
            throw new IllegalStateException("O número inicial não pode ser maior do que o número final");
        }
        return valor >= de && valor <= ate;
    }

    public static boolean estaNoIntervalo(LocalDate dataDe, LocalDate dataAte, LocalDate data) {
        if (dataDe.isAfter(dataAte) || dataDe.equals(dataAte)) {
            throw new IllegalStateException("A data inicial não pode ser maior do que a data final");
        }
        return ((data.isEqual(dataDe) || data.isAfter(dataDe)) && (data.isEqual(dataAte) || data.isBefore(dataAte)));
    }

    public static LocalDate getMenor(LocalDate data1, LocalDate data2) {
        if (data2.isBefore(data1)) {
            return data2;
        } else {
            return data1;
        }
    }

    public static LocalDate getMaior(LocalDate data1, LocalDate data2) {
        if (data2.isAfter(data1)) {
            return data2;
        } else {
            return data1;
        }
    }

    public static boolean isStringNumeroInteiro(String string) {
        return string.matches("^[0-9]+$");
    }

    public static String numeroPorExtenso(int numero) {
        return NumerosUtil.numeroPorExtenso(numero);
    }

}
