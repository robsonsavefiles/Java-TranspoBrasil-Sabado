package Palpite;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 78522
 */
public class Jogo {

    private final Palpite secreto = new Palpite(new Random().nextInt(100));
    private final int maxRodadas;
    private final ArrayList<Jogador> jogadores;

    public Jogo(ArrayList<Jogador> jogadores, int maxRodadas) {
        this.jogadores = jogadores;
        this.maxRodadas = maxRodadas;
    }

    public Jogo(int maxRodadas) {
        jogadores = new ArrayList<>();
        this.maxRodadas = maxRodadas;
    }

    public void addJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void iniciar() {
        for (int i = 1; i < maxRodadas; i++) {
            for (Jogador jogador : jogadores) {
                Palpite palpite = jogador.palpitar();
                System.out.println(jogador.getNome() + " chutou " + palpite.getValor());
                if (secreto.equals(palpite)) {
                    System.out.println("Parabéns " + jogador.getNome() + ", você acertou!");
                    return;
                } else {
                    System.out.println("Eeeerroooou!");
                }
            }
        }

        System.out.println("O jogo acabou e ninguém acertou! O número secreto era: " + secreto.getValor());
    }
}
