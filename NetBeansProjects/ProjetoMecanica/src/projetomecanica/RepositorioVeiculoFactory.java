/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomecanica;

public class RepositorioVeiculoFactory {
    
    
    
    public static RepositorioVeiculo getRepositorioVeiculo(){
        return (RepositorioVeiculo) new RepositorioVeiculoImplArq();
    }
    
}
