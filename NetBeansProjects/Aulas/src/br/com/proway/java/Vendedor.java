/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

import java.util.Objects;

/**
 *
 * @author 89087
 */
public class Vendedor extends Funcionario {
    
      private double totalVendas;
    private double percentualComissao;

    @Override
    public String toString() {
        return "Vendedor{" + "codigo=" + getCodigo() + ", nome=" + getNome() + ", salarioBase=" + getSalarioBase() + ", totalVendas=" + getTotalVendas() + ", percentualComissao=" + getPercentualComissao() + '}';
    }



    public Vendedor() {
    }

    public Vendedor(String codigo, String nome, double totalVendas, double salarioBase, double percentualComissao) {
        super(codigo, nome, salarioBase);
        this.totalVendas = totalVendas;
        this.percentualComissao = percentualComissao;
    }


    
    public double getSalario(){
        return getSalarioBase() + (totalVendas + percentualComissao);
    }

    public double getPercentualComissao() {
        return percentualComissao;
        
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }
    
    
   
}