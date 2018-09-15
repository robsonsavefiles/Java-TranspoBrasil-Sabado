package br.cursojava.model;


/**
 *
 * @author 89087
 */
public class Projeto extends Entidade {

    private String nome;
    private String descricao;

    public Projeto() {
    }

    public Projeto(Long id, String nome, String descricao) {
        super(id);
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Projeto{" + "nome=" + nome + ", descricao=" + descricao + '}';
    }

}
