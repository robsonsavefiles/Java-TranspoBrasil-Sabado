/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficinaV2.base;

import br.com.oficinav2.base.EventoNavegacao;
import br.com.OficinaV2.base.Telas;

/**
 *
 * @author 89087
 */
public class App {
    
    public static void main(String[] args) {
       AppController controller = new AppController();
       NotificadorDeEventos instance = NotificadorDeEventos.getInstance();
       instance.registrarOuvinte(controller);
       instance.dispararEvento(new EventosNavegacao(Telas.PRINCIPAL));
        
    }
    
}
