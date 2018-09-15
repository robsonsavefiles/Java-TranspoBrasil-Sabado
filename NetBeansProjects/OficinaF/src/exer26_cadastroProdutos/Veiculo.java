/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exer26_cadastroProdutos;
// private Date dataCriacao;
// private Date dataAlteracao;    
//construtor dele ter pelo menos PLACA,ANOFABRICACAO,ANOMODELO E O ID
//anoFabricacao >= 1900 e anoFabricacao <= anoAtual
//anoModelo >= 1900 e anoModelo <= anoAtual+1
//dataCricao => não vazio
//dataAlteracao => não vazio
//id não vazio
//placa => não vazio
//modelo => não vazio

import java.util.Date;

/**
 *
 * @author 88178
 */
public class Veiculo extends Entidade implements Comparable<Veiculo> {

    private Long id;
    private String placa;
    private int anoModelo;
    private int anoFabricacao;
    private String marca;
    private String modelo;
    private String cor;

    public Veiculo(String placa, String marca, String modelo, String cor, int anoModelo, int anoFabricao) {
        this.placa = placa;
        this.anoModelo = anoModelo;
        this.anoFabricacao = anoFabricao;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public Veiculo() {
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

    @Override
    public int compareTo(Veiculo outro) {
        if (outro != null) {
            if (id != null) {
                return id.compareTo(outro.getId());
            } else {
                return 1;
            }
        }
        return -1;
    }

}
