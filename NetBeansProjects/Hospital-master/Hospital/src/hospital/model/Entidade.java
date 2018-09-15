package hospital.model;

import java.time.LocalDateTime;

/**
 *
 * @author 78522
 */
public abstract class Entidade {

    private Long id;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;

    public Entidade(Long id, LocalDateTime dataCriacao, LocalDateTime dataAlteracao) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataAlteracao = dataAlteracao;
    }

    public Entidade() {
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

}
