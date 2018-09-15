package modelo;

import java.time.LocalDateTime;

/**
 *
 * @author 78522
 */
public abstract class Pessoa extends Entidade {
    
    private String nome;
    
    public Pessoa(Long id, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, String nome) {
        super(id, dataCriacao, dataAlteracao);
        this.nome = nome;
    }
    
    public Pessoa(LocalDateTime dataCriacao, LocalDateTime dataAlteracao, String nome) {
        this(null, dataCriacao, dataAlteracao, nome);
    }
    
    public Pessoa() {
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
