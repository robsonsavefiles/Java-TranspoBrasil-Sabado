package telalogin;

/**
 *
 * @author 89087
 */
public class VisitanteClass extends javax.swing.JFrame {

    private String nome;
    private PacienteUTI paciente;
    private String status;

    public VisitanteClass(String nome, PacienteUTI paciente, String status) {
        this.nome = nome;
        this.paciente = paciente;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PacienteUTI getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteUTI paciente) {
        this.paciente = paciente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

    }

}
