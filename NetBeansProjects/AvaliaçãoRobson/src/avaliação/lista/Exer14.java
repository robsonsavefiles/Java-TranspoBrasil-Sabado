/*
 14) Escreva um programa que escreva os números primos entre 1 e 1000.
 Um número primo é aquele que é divisivel apenas por 1 e por ele mesmo com resto Zero)

 */
package avaliação.lista;

import javax.swing.JOptionPane;

/**
 *
 * @author 89087
 */
public class Exer14 {

   
 public static void main(String[] args) {
        System.out.println("São primos:");
        i:
        for (int i = 2; i < 1000; i++) {
            j:
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    continue i;
                }
            }
            System.out.println(i);
        }
    }

}
