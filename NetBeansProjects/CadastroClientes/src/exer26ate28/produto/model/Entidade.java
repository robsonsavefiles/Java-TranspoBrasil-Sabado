package exer26ate28.produto.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author 78522
 */
public abstract class Entidade implements Serializable, Imprimivel {

    public static final InfoCampo CAMPO_ID = new InfoCampo("ID", 20);
    public static final InfoCampo CAMPO_DATA_CRIACAO = new InfoCampo("Data de Cria��o", 20);
    public static final InfoCampo CAMPO_DATA_ALTERACAO = new InfoCampo("Data de Altera��o", 20);

    private Long id;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;

    public Entidade() {
    }

    public Entidade(LocalDateTime dataCriacao, LocalDateTime dataAlteracao) {
        this(null, dataCriacao, dataAlteracao);
    }

    public Entidade(Long id, LocalDateTime dataCriacao, LocalDateTime dataAlteracao) {
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public String infoLinhaString() {
        String retorno = "";
        retorno += String.format("%-" + CAMPO_ID.getTamanhoImpressao() + "d", id);
        return retorno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        return Objects.equals(this.id, other.id);
    }

    public abstract Map<String, InfoCampo> getCampos();

    public List<InfoCampo> getCamposAsList() {
        return new ArrayList(getCampos().values());
    }

}
