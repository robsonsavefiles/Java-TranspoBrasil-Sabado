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
public class Gerente extends Funcionario{
   

   private double adicionalGratificacao;

    @Override
    public String toString() {
        return "Gerente{" + "codigo=" + getCodigo() + ", nome=" + getNome() + ", salarioBase=" + getSalarioBase() + ", adicionalGratificacao=" + adicionalGratificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.getCodigo());
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
        final Gerente other = (Gerente) obj;
        if (!Objects.equals(this.getCodigo(), other.getCodigo())) {
            return false;
        }
        return true;
    }
    
    public double getSalario(){
        return getSalarioBase() + adicionalGratificacao;
    }

    public double getAdicionalGratificacao() {
        return adicionalGratificacao;
    }

    public void setAdicionalGratificacao(double adicionalGratificacao) {
        this.adicionalGratificacao = adicionalGratificacao;
    }

    public Gerente() {
    }

    public Gerente(String codigo, String nome, double salarioBase, double adicionalGratificacao) {
        super(codigo, nome, salarioBase);
        this.adicionalGratificacao = adicionalGratificacao;
    }
}