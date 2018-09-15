package Palpite;

import java.util.Random;

/**
 *
 * @author 78522
 */
public class JogadorComputador extends Jogador {

    private final static Random random = new Random();

    public JogadorComputador(String nome) {
        super(nome);
    }

    public Palpite palpitar() {
        return new Palpite(random.nextInt(100));
    }
}
