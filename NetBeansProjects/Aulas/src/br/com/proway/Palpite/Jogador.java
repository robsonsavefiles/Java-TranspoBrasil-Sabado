package Palpite;

/**
 *
 * @author 78522
 */
public abstract class Jogador {

    private String nome;

    public abstract Palpite palpitar();

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
