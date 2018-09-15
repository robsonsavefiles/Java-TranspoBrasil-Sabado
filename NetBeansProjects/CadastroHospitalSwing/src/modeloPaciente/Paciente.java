
package modeloPaciente;

import java.util.Date;
import modeloUsuario.*;
import java.util.Objects;

public class Paciente {
    
    private Long id;
    private String situacao;
    private String nome;
    private String procedimento;
    private Date data_entrada;
    private Date data_saida;

    public Paciente() {
    }

    public Paciente(Long id, String situacao, String nome, String procedimento, Date data_entrada, Date data_saida) {
        this.id = id;
        this.situacao = situacao;
        this.nome = nome;
        this.procedimento = procedimento;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", situacao=" + situacao + ", nome=" + nome + ", procedimento=" + procedimento + ", data_entrada=" + data_entrada + ", data_saida=" + data_saida + '}';
    }

}