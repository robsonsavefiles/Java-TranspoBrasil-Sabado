/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.oficina.validador;

/**
 *
 * @author felipe.oliveira
 */
public class Erro {
    
    private final String campo;
    private final String descricao;

    public Erro(String campo, String descricao) {
        this.campo = campo;
        this.descricao = descricao;
    }

    public String getCampo() {
        return campo;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
    
}
