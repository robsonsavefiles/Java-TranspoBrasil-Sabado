/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import estado.Situacao;
import java.util.Date;

/**
 *
 * @author 88178
 */
public class Paciente {
    
    private Long id;
    private String nome;
    private Situacao situacao;
    private String procedimento;
    private Date dataEntrada;
    private Date dataSaida;

    public Paciente(Long id,String nome, Situacao situacao, String procedimento, Date dataEntrada, Date dataSaida) {
        this.id = id;
        this.nome = nome;
        this.situacao = situacao;
        this.procedimento = procedimento;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
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
    
}
