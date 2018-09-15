/*UM Programa  para exibir  calculos simples 0 usuario devera poder escolher entre 7
 opçoes de calculos para o programa resolver e ele devera poder resolver varios calculos
 ao tempo.

 As 7 opçoes serão:
 os 10 primeiros multiplos de um numero
 os 10 primeiros numeros pares apartir de um valor
 os 10 proximos numeros de fibonnaci de um valor
 os 10 numeros anteriores da fibonnaci de um valor
 os 10 proximos numeros de um valor;
 os 10 numeros anteriores
 Qual o fatorial de um valor;
 */
package parte1;


import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exer1_Thread extends Thread {

    private Scanner teclado;
    private int num;
    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public Exer1_Thread(int num) {
        this.num = num;
    }
    public void run() {//vai ser chamando dentro do metodo start
        super.run();
        //public void Mulit10() {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println("Resultado"+num * i);
            try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exer1_Thread.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }

} 
