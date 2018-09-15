/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficinav2.base;

/**
 * Representa um evento de navegação entre telas do sistema
 *
 * @author felipe.oliveira
 */
public class EventoNavegacao implements Evento {

    private final Telas tela;

     public EventoNavegacao(Telas tela) {
        this.tela = tela;
    }

    /**
     * Representa a tela que deve ser disponibilizada
     * @return enum com código da tela a ser mostrada
     */
    public Telas getDestino() {
        return this.tela;
    }
    

    public String getTipo() {
        return EventoNavegacao.class.getName();
    }

   

}
