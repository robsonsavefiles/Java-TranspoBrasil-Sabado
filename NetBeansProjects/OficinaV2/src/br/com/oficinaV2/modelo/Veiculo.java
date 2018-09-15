/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficinaV2.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 88178
 */
public class Veiculo extends Entidade implements Serializable {

   
    private String placa;
    private int anoModelo;
    private int anoFabricacao;
    private String marca;
    private String modelo;
    private String cor;

    public Veiculo(Long id, Date dataCriacao, Date dataAlteracao) {
        super(id, dataCriacao, dataAlteracao);
    }

    public Veiculo() {
    }

   

    public Veiculo(String placa,String marca,String modelo,String cor,int anoFabricacao,int anoModelo,Long id, Date dataCriacao,Date dataAlteracao) {
        super(id, dataCriacao, dataAlteracao);
        this.placa = placa;
        this.anoModelo = anoModelo;
        this.anoFabricacao = anoFabricacao;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
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

  

}
