package br.com.tiagodws.hospital.model;

import br.com.tiagodws.hospital.view.controller.TableInfoVisitante;
import java.time.LocalDateTime;

/**
 *
 * @author 78522
 */
public class Visitante extends Pessoa implements TableInfoVisitante {

    public enum Status {

        ESPERA, ENTRADA, SAIDA;
    }

    private Paciente pacienteUti;
    private Status status;

    public Visitante(Long id, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, String nome, Paciente paciente, Status status) {
        super(id, dataCriacao, dataAlteracao, nome);
        this.pacienteUti = paciente;
        this.status = status;
    }

    public Visitante(String nome, Paciente paciente, Status status) {
        super(null, null, null, nome);
        this.pacienteUti = paciente;
        this.status = status;
    }

    public Visitante() {
    }

    @Override
    public Paciente getPaciente() {
        return pacienteUti;
    }

    public void setPaciente(Paciente paciente) {
        this.pacienteUti = paciente;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
