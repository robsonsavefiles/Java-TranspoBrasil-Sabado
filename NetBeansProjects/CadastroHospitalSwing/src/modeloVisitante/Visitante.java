
package modeloVisitante;

import modeloUsuario.*;
import java.util.Objects;
import modelo.Paciente;

public class Visitante  {
    
    private Long id;
    private String id_paciente;
    private String nome;
    private String status;

    public Visitante() {
    }

    public Visitante(Long id, String id_paciente, String nome, String status) {
        this.id = id;
        this.id_paciente = id_paciente;
        this.nome = nome;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Visitante{" + "id=" + id + ", id_paciente=" + id_paciente + ", nome=" + nome + ", status=" + status + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.id_paciente);
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
        final Visitante other = (Visitante) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.id_paciente, other.id_paciente)) {
            return false;
        }
        return true;
    }
    
    

}