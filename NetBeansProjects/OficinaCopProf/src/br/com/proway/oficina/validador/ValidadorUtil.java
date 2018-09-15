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
public class ValidadorUtil {
    
    
    public static boolean isVazio(String valor){
        return  valor == null || "".equals(valor.trim());
    }
    
    public static boolean isDentroDoIntervado(int valor, int inicio, int fim){
        return valor >= inicio && valor <= fim;
    }
    
    public static boolean isNull(Object valor){
            return valor == null;
    }
    
     public static String getValor(String valor){
        return valor != null ? valor : "";
    }
    
}
