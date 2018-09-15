/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomecanica;


import java.util.ArrayList;


public class VeiculoException extends RuntimeException{

    private ArrayList<Error> erros;
    public VeiculoException() {
    }

    public VeiculoException(String message) {
        super(message);
    }

    public VeiculoException(String message, Throwable cause) {
        super(message, cause);
    }

    public VeiculoException(Throwable cause) {
        super(cause);
    }

    public VeiculoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public VeiculoException(ArrayList<Error> erros) {
        this.erros = erros;
    }

    public ArrayList<Error> getErros() {
        return erros;
    }
    
    
}
