/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.oficina.modelo;

import java.util.Date;

/**
 *
 * @author felipe.oliveira
 */
public class Veiculo extends Entidade{
    
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int anoFabricacao;
    private int anoModelo;

    public Veiculo(String placa,String marca, String modelo, String cor, int anoFabricacao, int anoModelo, Long id, Date dataCriacao, Date dataAlteracao) {
        super(id, dataCriacao, dataAlteracao);
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "id=" + getId() +  ", dataCriacao=" + getDataCriacao() + ", dataAlteração=" + getDataAlteracao() +", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", anoFabricacao=" + anoFabricacao + ", anoModelo=" + anoModelo + '}';
    }
    
    
    
}
