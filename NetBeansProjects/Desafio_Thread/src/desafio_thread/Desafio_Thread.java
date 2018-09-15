/*
Crie um aplicativo onde o usuário possa escolher a quantidade de processos a serem criados para execução 
em concorrência.Estes devem ser nomeados e funcionarão incrementando valores de 0 até 1 valor máximo passado
para cada um deles (ou seja, cada um desdes processos é um contador em uma Thread, cada Thread vai ter um nome 
e um valor máximo para atingir no contador).Quando o processo atingir o número correspondente a metade do valor
máximo para incremento (arredondar para baixo), deve entrar em espera de um tempo calculado de maneira randômica entre 0 e 5 segundos e posteriormente ser liberado. 

(Comandos e Classes: Scanner, sysout, for, Threads, vetores, Random)

  #Exemplo de uso de um Random:
  #Random gerador = new random();
  #int numero = gerador.nextInt(10);
  #Neste caso, gerador retornará um número entre 0 e 9.

 */
package desafio_thread;

import java.util.Scanner;

/*
 * @author 89087
 */
public class Desafio_Thread {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		
		System.out.println("Informe a Quantidade de Processos:");
		int tamanho = s.nextInt();

		Processo[] meusProcessos = new Processo[tamanho];
		
		for (int i = 0; i < meusProcessos.length; i++) {
			Processo p = new Processo();
			
			System.out.println("Informe a Quantidade máxima de processos: " + (i + 1));
			p.setValorMaximo(s.nextInt());
			
			System.out.println("Informe o nome do processo: " + (i + 1));
			p.setNome(s.next());
			
			meusProcessos[i] = p;
		}
		
		for (int i = 0; i < meusProcessos.length; i++) {
			meusProcessos[i].start();
		}
	}

}

    
    

