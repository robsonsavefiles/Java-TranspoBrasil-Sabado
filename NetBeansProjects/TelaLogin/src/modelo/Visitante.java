
package modelo;

/**
 *
 * @author 89087
 */
public class Visitante {
    
    private int id;
    private int idpaciente;
    private String nome;
    private String status;

    public Visitante() {
    }

    public Visitante(int id, int idpaciente, String nome, String status) {
        this.id = id;
        this.idpaciente = idpaciente;
        this.nome = nome;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
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
        return "Visitante{" + "id=" + id + ", idpaciente=" + idpaciente + ", nome=" + nome + ", status=" + status + '}';
    }
    
    

}
