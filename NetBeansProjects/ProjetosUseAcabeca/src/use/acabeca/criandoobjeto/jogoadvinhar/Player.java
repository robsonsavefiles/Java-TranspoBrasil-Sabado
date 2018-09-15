/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package use.acabeca.criandoobjeto.jogoadvinhar;

/**
 *
 * @author Robinho
 */
public class Player {
    int number =0;//onde entra o palpite
    
    public void guess(){
        number = (int)(Math.random()*10);
        System.out.println("Estou pensando em "+number);
    }
    
    
}
