package Palpite;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            Jogo jogo = new Jogo(5);
            jogo.addJogador(new JogadorComputador("Bot Alfred"));
            jogo.addJogador(new JogadorHumano(teclado, "Tiago"));
            jogo.iniciar();
        }
    }

}
