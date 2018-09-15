/*
 * Este trecho de código mostra como usar o método add() da classe Calendar para
adicionar ou subtrair dias de uma data. Veja que este método requer o campo de calendário
e um número inteiro. Para o nosso propósito, o campo de calendário pode ser DAY_OF_MONTH
ou DATE. Um valor positivo adiciona dias enquanto um valor negativo subtrai:

 */
package estudojava.exemplos.datas;
import java.util.*;
import java.text.*;
/**
 *
 * @author Robinho
 */
public class AdicionandoDias {
     
  public static void main(String args[]){ 
    Calendar agora = Calendar.getInstance();
    
    // formata e exibe a data e hora atual
    Format formato = new SimpleDateFormat(
      "dd/MM/yyyy - HH:mm:ss");
    System.out.println("Hoje é: " + 
      formato.format(agora.getTime()));

    // vamos adicionar 5 dias a esta data
    agora.add(Calendar.DAY_OF_MONTH, 5);
    // o mesmo resultado pode ser obtido com
    // agora.add(Calendar.DATE, 5);

    // formata e exibe o resultado
    formato = new SimpleDateFormat(
      "dd/MM/yyyy - HH:mm:ss");
    System.out.println("Daqui a 5 dias será: " +
      formato.format(agora.getTime()));
  } 
}


