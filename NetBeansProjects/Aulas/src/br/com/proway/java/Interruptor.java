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
public class Interruptor {

    private Dispositivos dispositivo;

    public Interruptor(Dispositivos dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setDispositivo(Dispositivos dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void ligar() {
        dispositivo.ligar();
    }

    public void desligar() {
        dispositivo.desligar();
    }

}
