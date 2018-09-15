/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.oficina;

import br.com.proway.oficina.modelo.Veiculo;
import br.com.proway.oficina.repositorio.RepositorioVeiculo;
import br.com.proway.oficina.repositorio.RepositorioVeiculoImplArq;
import br.com.proway.oficina.view.CadastroVeiculo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author felipe.oliveira
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CadastroVeiculo cadastro = new CadastroVeiculo();
        cadastro.setTeclado(teclado);
        cadastro.menu();
        
        teclado.close();
    }
    
}
