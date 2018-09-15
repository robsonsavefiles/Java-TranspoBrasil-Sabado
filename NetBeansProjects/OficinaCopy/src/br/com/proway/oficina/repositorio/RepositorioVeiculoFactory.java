/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.oficina.repositorio;

public class RepositorioVeiculoFactory {
    
    
    
    public static RepositorioVeiculo getRepositorioVeiculo(){
        return new RepositorioVeiculoImplArq();
    }
    
}
