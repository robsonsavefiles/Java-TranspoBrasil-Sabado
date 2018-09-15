package exercicio_veiculo.model;

import java.util.Objects;

/**
 *
 * @author 78522
 */
public class Modelo {
    
    private Long id;
    private Marca marca;
    private String nome;
    private int ano;
    
    public Modelo() {
    }
    
    public Modelo(Marca marca, String nome, int ano) {
        this(null, marca, nome, ano);
    }
    
    public Modelo(Long id, Marca marca, String nome, int ano) {
        this.id = id;
        this.marca = marca;
        this.nome = nome;
        this.ano = ano;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getAno() {
        return ano;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public Marca getMarca() {
        return marca;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Modelo other = (Modelo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
