/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.serializacao;

/**
 *
 * @author 89087
 */
public class Animal {
    
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Animal(){
        System.out.println("Criando Animal");
    }
    
}
