package aula.exercicios.util;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 78522
 */
public class UtilTest {

    @Test
    public void testDataForaIntervalo() {
        LocalDate data = LocalDate.now();
        LocalDate dataDe = LocalDate.now().plusDays(1);
        LocalDate dataAte = LocalDate.now().plusDays(10);
        Assert.assertFalse(Util.estaNoIntervalo(dataDe, dataAte, data));

        dataDe = LocalDate.now().minusDays(10);
        dataAte = LocalDate.now().minusDays(1);
        Assert.assertFalse(Util.estaNoIntervalo(dataDe, dataAte, data));
    }

    @Test
    public void testDataNoIntervalo() {
        LocalDate data = LocalDate.now();
        LocalDate dataDe = LocalDate.now().minusDays(10);
        LocalDate dataAte = LocalDate.now().plusDays(10);
        Assert.assertTrue(Util.estaNoIntervalo(dataDe, dataAte, data));
    }

    @Test
    public void testDataIntervaloInvalido() {
        LocalDate data = LocalDate.now();
        LocalDate dataDe = LocalDate.now().plusDays(10);
        LocalDate dataAte = LocalDate.now().minusDays(10);
        boolean temErro = false;
        try {
            Util.estaNoIntervalo(dataDe, dataAte, data);
        } catch (IllegalStateException e) {
            temErro = true;
        }
        Assert.assertTrue(temErro);
    }

    @Test
    public void dataMenorTest() {
        LocalDate data1 = LocalDate.now().minusDays(1);
        LocalDate data2 = LocalDate.now();
        Assert.assertEquals(data1, Util.getMenor(data1, data2));
    }

    @Test
    public void dataMaiorTest() {
        LocalDate data1 = LocalDate.now().minusDays(1);
        LocalDate data2 = LocalDate.now();
        Assert.assertEquals(data2, Util.getMaior(data1, data2));
    }

    @Test
    public void dataIgualTest() {
        LocalDate data1 = LocalDate.now();
        LocalDate data2 = LocalDate.now();
        Assert.assertEquals(data1, Util.getMaior(data1, data2));
    }

    @Test
    public void testNumeroForaIntervalo() {
        int numero = 5;
        int numeroDe = 20;
        int numeroAte = 50;
        Assert.assertFalse(Util.estaNoIntervalo(numeroDe, numeroAte, numero));

        numero = 100;
        numeroDe = 20;
        numeroAte = 50;
        Assert.assertFalse(Util.estaNoIntervalo(numeroDe, numeroAte, numero));
    }

    @Test
    public void testNumeroNoIntervalo() {
        int numero = 25;
        int numeroDe = 20;
        int numeroAte = 50;
        Assert.assertTrue(Util.estaNoIntervalo(numeroDe, numeroAte, numero));
    }

    @Test
    public void testNumeroIntervaloInvalido() {
        int numero = 25;
        int numeroDe = 50;
        int numeroAte = 0;
        boolean temErro = false;
        try {
            Util.estaNoIntervalo(numeroDe, numeroAte, numero);
        } catch (IllegalStateException e) {
            temErro = true;
        }
        Assert.assertTrue(temErro);
    }

    @Test
    public void testStringIsNumeroInteiro() {
        String string = "5";
        Assert.assertTrue(Util.isStringNumeroInteiro(string));

        string = "1998753";
        Assert.assertTrue(Util.isStringNumeroInteiro(string));
    }

    @Test
    public void testStringIsNotNumeroInteiro() {
        String string = "5.6";
        Assert.assertFalse(Util.isStringNumeroInteiro(string));
        string = "abc";
        Assert.assertFalse(Util.isStringNumeroInteiro(string));

        string = "";
        Assert.assertFalse(Util.isStringNumeroInteiro(string));
    }

    @Test
    public void testNumeroPorExtenso() {
        int numero = 32;
        Assert.assertEquals("trinta e dois", Util.numeroPorExtenso(numero));

        numero = 19;
        Assert.assertEquals("dezenove", Util.numeroPorExtenso(numero));

        numero = 0;
        Assert.assertEquals("zero", Util.numeroPorExtenso(numero));

        numero = 20;
        Assert.assertEquals("vinte", Util.numeroPorExtenso(numero));

        numero = 100;
        Assert.assertEquals("cento", Util.numeroPorExtenso(numero));

        numero = 113;
        Assert.assertEquals("cento e treze", Util.numeroPorExtenso(numero));

        numero = 1000;
        Assert.assertEquals("um mil", Util.numeroPorExtenso(numero));

        numero = 10000;
        Assert.assertEquals("dez mil", Util.numeroPorExtenso(numero));

        numero = 100000;
        Assert.assertEquals("cem mil", Util.numeroPorExtenso(numero));

        numero = 100100;
        Assert.assertEquals("cem mil e cem", Util.numeroPorExtenso(numero));

        numero = 1100100;
        Assert.assertEquals("um milhão e cem mil e cem", Util.numeroPorExtenso(numero));

    }

}
