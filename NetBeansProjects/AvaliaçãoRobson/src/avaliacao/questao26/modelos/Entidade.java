package avaliacao.questao26.modelos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 89087
 */
public abstract class Entidade implements Serializable {

    private Long id;
    private Date dataCriacao;
    private Date dataAlteracao;

    public Entidade() {
    }

    public Entidade(Long id, Date dataCriacao, Date dataAlteracao) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataAlteracao = dataAlteracao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

}
