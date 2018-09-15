
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 89087
 */
public class Paciente {
    
    private String id;
    private String situacao;
    private String nome;
    private String procedimento;
    private Date dataEntrada;
    private Date datasaida;
    private Object txtDataRetirada;

    public Paciente() {
    }

    public Paciente(String id, String situacao, String nome, String procedimento, Date dataEntrada, Date datasaida) {
        this.id = id;
        this.situacao = situacao;
        this.nome = nome;
        this.procedimento = procedimento;
        this.dataEntrada = dataEntrada;
        this.datasaida = datasaida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", situacao=" + situacao + ", nome=" + nome + ", procedimento=" + procedimento + ", dataEntrada=" + dataEntrada + ", datasaida=" + datasaida + '}';
    }
//    String datasaida = new SimpleDateFormat("dd/MM/yyyy").format(txtDataRetirada.getDate());  
//    s.setDataRetirada(data); 

    

}