package exemplos.interfaces.carros;

/**
 *
 * @author 78522
 */
public class Turbo implements Turbinavel {

    private String nome;
    private String mensagem;

    public Turbo(String nome, String mensagem) {
        this.nome = nome;
        this.mensagem = mensagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public void turbo() {
        System.out.println(mensagem);
    }

}
