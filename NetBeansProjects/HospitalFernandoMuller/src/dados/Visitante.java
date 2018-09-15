/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import estado.Status;

/**
 *
 * @author 88178
 */
public class Visitante {
    
    private Long id;
    private String nome;
    private Paciente paciente;
    private Status estado;

    public Visitante() {
    }

    public Visitante(Long id,String nome, Paciente paciente, Status estado) {
        this.id = id;
        this.nome = nome;
        this.paciente = paciente;
        this.estado = estado;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Status getEstado() {
        return estado;
    }

    public void setEstado(Status estado) {
        this.estado = estado;
    }
    
    
}
