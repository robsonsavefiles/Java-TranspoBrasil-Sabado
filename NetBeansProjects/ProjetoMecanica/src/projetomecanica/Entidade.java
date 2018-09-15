/*
===============================================================================
Classe Base : Entidade
Id
dataCricao
dataAlteraçao
 */
package projetomecanica;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 89087
 */
public class Entidade {
    
    private Long id;
    private Date dataCriacao;
    private Date dataAlteracao;

    public Entidade(long id, Date dataCriacao, Date dataAlteracao) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.dataCriacao);
        hash = 67 * hash + Objects.hashCode(this.dataAlteracao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entidade other = (Entidade) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        if (!Objects.equals(this.dataAlteracao, other.dataAlteracao)) {
            return false;
        }
        return true;
    }

    public Entidade() {
    }

    @Override
    public String toString() {
        return "Entidade{" + "id=" + id + ", dataCriacao=" + dataCriacao + ", dataAlteracao=" + dataAlteracao + '}';
    }
    
    
    
}
