package avaliacao.questao26.model;

import java.util.Date;

/**
 *
 * @author 78522
 */
public class Produto extends Entidade {

    private String codigo;
    private String nome;
    private String descricao;
    private double valor;

    public Produto() {
    }

    public Produto(Date dataCriacao, Date dataAlteracao, String codigo, String nome, String descricao, double valor) {
        this(null, dataCriacao, dataAlteracao, codigo, nome, descricao, valor);
    }

    public Produto(Long id, Date dataCriacao, Date dataAlteracao, String codigo, String nome, String descricao, double valor) {
        super(id, dataCriacao, dataAlteracao);
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + '}';
    }

}
