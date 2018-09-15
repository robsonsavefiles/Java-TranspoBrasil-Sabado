/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excecoes;


public class MinhaExcecaoChecada  extends Exception{

    public MinhaExcecaoChecada() {
    }

    public MinhaExcecaoChecada(String message) {
        super(message);
    }

    public MinhaExcecaoChecada(String message, Throwable cause) {
        super(message, cause);
    }

    public MinhaExcecaoChecada(Throwable cause) {
        super(cause);
    }

    public MinhaExcecaoChecada(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
