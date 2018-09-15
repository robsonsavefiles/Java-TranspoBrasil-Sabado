package cadastro_hospital;


import java.util.Date;
import java.util.Objects;

public class Pacientes {

    private Long id;
    private String nome;
    private String situacao;
    private String procedimento;
    private Date dataEntrada;
    private Date dataSaida;

    public Pacientes() {
    }

    public Pacientes(String nome, String situacao, String procedimento) {
        this.nome = nome;
        this.situacao = situacao;
        this.procedimento = procedimento;
    }

    public Pacientes(Long id, String nome,String situacao, String procedimento, Date dataEntrada, Date dataSaida) {
        this.id = id;
        this.nome = nome;
        this.situacao = situacao;
        this.procedimento = procedimento;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
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

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Pacientes other = (Pacientes) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
   