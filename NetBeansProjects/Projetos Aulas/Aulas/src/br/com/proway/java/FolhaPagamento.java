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
public class FolhaPagamento {
    
     public void imprimirHolerite(Funcionario funcionario) {
        System.out.println("=======HOLERITE=======");
        System.out.printf("Nome %s\r\n", funcionario.getNome());
        System.out.printf("Codigo %s\r\n", funcionario.getCodigo());
        System.out.printf("Salário %.2f\r\n", funcionario.getSalario());
        System.out.println("======FIM====================");

    }

    
}

