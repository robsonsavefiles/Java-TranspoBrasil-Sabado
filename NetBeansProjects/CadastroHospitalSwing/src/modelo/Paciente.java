package modelo;

import hospital.view.controller.TableInfoPaciente;
import java.time.LocalDateTime;

/**
 *
 * @author 78522
 */
public class Paciente extends Pessoa implements TableInfoPaciente {

    public enum Situacao {

        INTERNADO, LIBERADO;
    }

    public enum Procedimento {

        CIRURGIA, TRATAMENTO;
    }

    private Situacao situacao;
    private Procedimento procedimento;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;

    public Paciente(Long id, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, String nome, Situacao situacao, Procedimento procedimento, LocalDateTime dataEntrada, LocalDateTime dataSaida) {
        super(id, dataCriacao, dataAlteracao, nome);
        this.situacao = situacao;
        this.procedimento = procedimento;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Paciente(String nome, Situacao situacao, Procedimento procedimento, LocalDateTime dataEntrada, LocalDateTime dataSaida) {
        this(null, null, null, nome, situacao, procedimento, dataEntrada, dataSaida);
    }

    public Paciente() {
    }

  
    @Override
    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }


    @Override
    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }


    @Override
    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

}
