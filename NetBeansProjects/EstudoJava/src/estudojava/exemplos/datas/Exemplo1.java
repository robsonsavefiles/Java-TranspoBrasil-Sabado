package estudojava.exemplos.datas;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Exemplo1 {

  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);

    String s;

    System.out.printf("Informe o nome da Cidade:\n");
    s = ler.nextLine();

    System.out.printf("\nResultado:\n");
// new java.util.Date = data atual (data do sistema operacional)
    System.out.printf("%s\n", DataPorExtenso(s, Calendar.getInstance()));
  }

// Retorna o nome do mÃªs.
// ParÃ¢metros: "i" = Ã­ndice para o vetor "mes"
//             "tipo" = 0 para retornar o nome completo e
//                      1 para o nome abreviado do mÃªs.
  public static String NomeDoMes(int i, int tipo) {
    String mes[] = {"janeiro", "fevereiro", "marÃ§o", "abril",
      "maio", "junho", "julho", "agosto", "setembro", "outubro",
      "novembro", "dezembro"};
// Java Ã© uma linguagem com vetores zero-based: as posiÃ§Ãµes do vetor
// iniciam a numeraÃ§Ã£o a partir do valor 0 (0-janeiro, 1-fevereiro, ...)
    if (tipo == 0)
       return(mes[i-1]); // extenso
// o mÃ©todo "substring" retorna os 3 primeiros caracteres de "mes[i-1]"
    else return(mes[i-1].substring(0, 3)); // abreviado
  }

// Retorna o dia da semana.
// ParÃ¢metros: "i" = Ã­ndice para o vetor "diasem"
//             "tipo" = 0 para retornar o nome completo e
//                      1 para o nome abreviado do dia da semana.
  public static String DiaDaSemana(int i, int tipo) {
    String diasem[] = {"domingo", "segunda-feira", "terÃ§a-feira",
      "quarta-feira", "quinta-feira", "sexta-feira", "sÃ¡bado"};
    if (tipo == 0)
       return(diasem[i-1]); // extenso
// o mÃ©todo "substring" retorna os 3 primeiros caracteres de "diasem[i]"
    else return(diasem[i-1].substring(0, 3));
  }

// Retorna a data por extenso.
// ParÃ¢metros: "cidade" = nome da cidade; e, "dt" = data.
  public static String DataPorExtenso(String cidade, Calendar dt) {
// retorna os valores dia, mÃªs e ano da variÃ¡vel "dt"
   int d = dt.get(Calendar.DATE);
   int m = dt.get(Calendar.MONTH)+1;
   int a = dt.get(Calendar.YEAR);

// retorna o dia da semana: 1=domingo, 2=segunda-feira, ..., 7=sÃ¡bado
    Calendar data = new GregorianCalendar(a, m-1, d);
    int ds = data.get(Calendar.DAY_OF_WEEK);

    return(cidade + ", " + d + " de " + NomeDoMes(m, 0) + " de " +
      a + " (" + DiaDaSemana(ds, 1) + ").");
  }

}
