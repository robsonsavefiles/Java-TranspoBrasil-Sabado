/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

/**
 *
 * @author 89087
 */
public class Atendente extends Funcionario {

    public Atendente() {
    }

    public Atendente(String codigo, String nome, double salarioBase) {
        super(codigo, nome, salarioBase);
    }

    @Override
    public double getSalario() {
        return getSalarioBase();
    }

    @Override
    public String toString() {
        return "Atendente{" + "codigo=" + getCodigo() + ", nome=" + getNome() + ", salarioBase=" + getSalarioBase() + '}';

    }

}
