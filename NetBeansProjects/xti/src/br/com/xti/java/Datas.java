package br.com.xti.java;

import java.util.Calendar;
import java.util.Date;

public class Datas {

	public static void main(String[] args) {
		/* 01 DE JAN 1970 */
		System.out.println(System.currentTimeMillis());

		Date agora = new Date();
		System.out.println(agora);

		Date data = new Date(1_000_000_000_000L);
		System.out.println(data);

		/* Metodos */
		data.getTime();// retorna em milisegundos
		data.setTime(1_000_000_000_000L);
		System.out.println(data.compareTo(agora));// -1,0,1

		/* GregorianCalendar */
		Calendar c = Calendar.getInstance();
		c.set(1980, Calendar.FEBRUARY, 12);
		System.out.println(c.getTime());

		System.out.println(c.get(Calendar.YEAR));// ANO
		System.out.println(c.get(Calendar.MONTH));// 0-11
		System.out.println(c.get(Calendar.DAY_OF_MONTH));

		c.set(Calendar.YEAR, 1972);// altera o ano
		c.set(Calendar.MONTH, Calendar.MARCH);// altera o mes
		c.set(Calendar.DAY_OF_MONTH, 25);// altera o ano
		System.out.println(c.getTime());

		c.clear(Calendar.MINUTE);// limpar
		c.clear(Calendar.SECOND);
		System.out.println(c.getTime());

		c.add(Calendar.DAY_OF_MONTH, -1);
		c.add(Calendar.YEAR, -1);
		System.out.println(c.getTime());

		c.roll(Calendar.DAY_OF_MONTH, 20);// add dias mais modifica o mes
		System.out.println(c.getTime());

		/*Saudaçao com Bom Dia, Boa tarde, Boa noite */

		Calendar c1 = Calendar.getInstance();
		int hora = c1.get(Calendar.HOUR_OF_DAY);
		if (hora <= 12) {
			System.out.println("Bom dia!!!");
		} else if (hora > 12 && hora < 18) {
			System.out.println("Boa tarde");
		} else {
			System.out.println("Boa Noite!!!");
		}
	}

}
