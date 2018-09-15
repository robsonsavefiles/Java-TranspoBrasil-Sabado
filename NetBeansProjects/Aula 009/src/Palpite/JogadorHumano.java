package Palpite;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class JogadorHumano extends Jogador {

    Scanner teclado;

    @Override
    public Palpite palpitar() {
        System.out.println("Informe um número entre 0 e 100");
        int numero;
        while (true) {
            numero = Integer.parseInt(teclado.nextLine());
            if (numero >= 0 && numero <= 100) {
                return new Palpite(numero);
            } else {
                System.out.println("Número inválido");
            }
        }
    }

    public JogadorHumano(Scanner teclado, String nome) {
        super(nome);
        this.teclado = teclado;
    }
}
