package estudojava.exemplos.datas;

import java.util.*;
import java.text.*;

/**
 *
 * @author Robinho
 */
public class MetodosDatas {

    public static void main(String args[]) {
        Calendar agora = Calendar.getInstance();

        // formata e exibe a data e hora atual
        Format formato = new SimpleDateFormat(
                "dd/MM/yyyy - HH:mm:ss");
        System.out.println("Hoje é: "
                + formato.format(agora.getTime()));

        // vamos adicionar 3 anos a esta data
        agora.add(Calendar.YEAR, 3);

        // formata e exibe o resultado
        formato = new SimpleDateFormat(
                "dd/MM/yyyy - HH:mm:ss");
        System.out.println("Daqui a 3 anos será: "
                + formato.format(agora.getTime()));

        //Construir uma data
        Calendar agoraa = Calendar.getInstance();

	   // ano, mês, dia, hora, minuto, segundo
        // mês começa a partir de 0
        agoraa.set(2005, 10, 23, 5, 29, 53);

        System.out.println(agora.toString());

        //Como converter um objeto Calendar em um objeto Date
        Calendar cal = Calendar.getInstance();
        Date data = cal.getTime();

        // formata e exibe a data e hora
        Format formato1 = new SimpleDateFormat(
                "dd/MM/yyyy - HH:mm:ss");
        System.out.println(formato.format(data));

    //Como converter um objeto Date em um objeto Calendar
        Date dataa = new Date();
        Calendar cale = Calendar.getInstance();
        cal.setTime(dataa);

        // formata e exibe a data e hora
        Format formatoo = new SimpleDateFormat(
                "dd/MM/yyyy - HH:mm:ss");
        System.out.println(formatoo.format(cal.getTime()));

    //Obter o nome do mês para a data atual 
        String meses[] = {"Janeiro", "Fevereiro",
            "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro",
            "Novembro", "Dezembro"};

        Calendar agora2 = Calendar.getInstance();
        System.out.println("O mes e: "
                + meses[agora2.get(Calendar.MONTH)]);

           // obter a hora atual
        Calendar atual = Calendar.getInstance();

        // horas, minutos e segundos
        int horas = atual.get(Calendar.HOUR);
        int minutos = atual.get(Calendar.MINUTE);
        int segundos = atual.get(Calendar.SECOND);

        System.out.println("Hora Atual: " + horas
                + ":" + minutos + ":" + segundos);

        //Obter data completa formatada
        String dias[] = {"Domingo",
            "Segunda-feira", "Terça-feira",
            "Quarta-feira", "Quinta-feira",
            "Sexta-feira", "Sábado"};
        String Meses[] = {"Janeiro", "Fevereiro",
            "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro",
            "Novembro", "Dezembro"};

        Calendar now = Calendar.getInstance();
        System.out.println("A date e: "
                + dias[now.get(Calendar.DAY_OF_WEEK) - 1] + ", " + now.get(Calendar.DAY_OF_MONTH) + " de " + meses[agora.get(Calendar.MONTH)] + " de " + now.get(Calendar.YEAR));

           //Obtendo o dia do mês para a data atual 
        Calendar agora3 = Calendar.getInstance();
        System.out.println("Hoje e: "
                + agora3.get(Calendar.DAY_OF_MONTH));

           //Obtendo o dia do mês usando as constantes DATE e DAY_OF_MONTH da classe Calendar
        // vamos obter a data e hora atual
        Calendar agora4 = Calendar.getInstance();

        // vamos obter o dia do mês
        System.out.println("O dia do mês é: "
                + agora4.get(Calendar.DAY_OF_MONTH));

           //Exemplo de formatação de data usando a classe SimpleDateFormat   
        Date data2 = new Date();    
        Format formato2 = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy");
        System.out.println(formato2.format(data));

        //FUSO HORARIO
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone.getDisplayName());
        System.out.println(timeZone.getID());
        
        // classe GregorianCalendar
        Calendar agora5 = new GregorianCalendar();
        System.out.println(agora5.toString());
  } 
}
    

