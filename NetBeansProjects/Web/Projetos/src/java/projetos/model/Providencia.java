package projetos.model;

/**
 *
 * @author 78522
 */
public class Providencia extends Entidade {

    private String descricao;
    private Estagio estagio;
    private Usuario autor;

    public enum Estagio {
        ANALISE,
        DESENVOLVIMENTO,
        TESTE,
        ENTREGUE,
        REJEITADA;
    }

    public Providencia() {
    }

    public Providencia(Long id, String descricao, Estagio estagio, Usuario autor) {
        super(id);
        this.descricao = descricao;
        this.estagio = estagio;
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Estagio getEstagio() {
        return estagio;
    }

    public void setEstagio(Estagio estagio) {
        this.estagio = estagio;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Providencia{" + "descricao=" + descricao + ", estagio=" + estagio + ", autor=" + autor + '}';
    }

}
