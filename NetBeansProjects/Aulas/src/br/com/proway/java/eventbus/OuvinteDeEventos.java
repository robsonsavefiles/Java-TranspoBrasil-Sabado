/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java.eventbus;

/**
 *
 * @author 89087
 */
public interface OuvinteDeEventos <T>{
    
    public void onEventoDisparado(T item);
    
    public String getTipo();
    
    
}
