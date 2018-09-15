/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;

/**
 *
 * @author 78522
 */
public class SimuladorLoteria {

    public static void main(String[] args) {
        int[] jogo = new int[]{13, 44, 8, 12, 36, 20, 50};
        int[] resultado = new int[7];
        Random r = new Random();
        int acertou = 0;

        i:
        for (int i = 0;; i++) {
            j:
            for (int j = 0; j < resultado.length; j++) {
                int numero = r.nextInt((60 - 0) + 1);
                for (int k = 0; k < j; k++) {
                    if (numero == resultado[k]) {
                        j--;
                        continue j;
                    }
                }
                resultado[j] = numero;
            }

            acertou = 0;

            for (int j = 0; j < resultado.length; j++) {
                for (int k = 0; k < jogo.length; k++) {
                    if (jogo[j] == resultado[k]) {
                        acertou++;
                    }
                }
            }

            if (acertou == 7) {
                System.out.println("Você ganhou após " + i + " jogos");
                System.out.println("Jogo: " + jogo[0] + ", " + jogo[1] + ", " + jogo[2] + ", " + jogo[3] + ", " + jogo[4] + ", " + jogo[5] + ", " + jogo[6]);
                System.out.println("Resultado: " + resultado[0] + ", " + resultado[1] + ", " + resultado[2] + ", " + resultado[3] + ", " + resultado[4] + ", " + resultado[5] + ", " + resultado[6]);
                i = 0;
            }
        }
    }
}
