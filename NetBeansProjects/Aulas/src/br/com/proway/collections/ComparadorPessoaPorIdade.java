/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.collections;

import java.util.Comparator;

/**
 *
 * @author 89087
 */
public class ComparadorPessoaPorIdade  implements Comparator<Pessoa>{

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        
       return Integer.compare(o1.getIdade(), o2.getIdade());
       
       
   
    }
    
}
