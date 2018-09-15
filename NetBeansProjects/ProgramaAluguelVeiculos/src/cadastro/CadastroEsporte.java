/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;
import cadastro.VeiculoEsporte;
import java.util.Scanner;
import sistema.Teclado;
 
/**
 *
 * @author Robinho
 */
public class CadastroEsporte {
    
    VeiculoEsporte veiculoEsporte = new VeiculoEsporte();
 
    public CadastroEsporte() {
    }
  
    public void ExecutaCadastro() {
 
        System.out.println("Número do Chassi:");
        veiculoEsporte.DefinirNumeroChassi(Teclado.LerInteiro());
 
        System.out.println("Número da Placa:");
        veiculoEsporte.DefinirNumeroPlaca(Teclado.LerString());
 
        System.out.println("Modelo:");
        veiculoEsporte.DefinirModelo(Teclado.LerString());
 
        System.out.println("Fabricante:");
        veiculoEsporte.DefinirFabricante(Teclado.LerString());
 
        System.out.println("Ano de Fabricação:");
        veiculoEsporte.DefinirAnoFabricacao(Teclado.LerInteiro());
 
        System.out.println("Cor:");
        veiculoEsporte.DefinirCor(Teclado.LerString());
 
        System.out.println("Potência (hp):");
        veiculoEsporte.DefinirPotencia(Teclado.LerInteiro());
 
        System.out.println("Aceleração (0-100/s):");
        veiculoEsporte.DefinirAceleracao(Teclado.LerFloat());
 
        System.out.println("Cadastro de Onibus: ");
        System.out.println("Número do Chassi: "
            + veiculoEsporte.ObterNumeroChassi());
        System.out.println("Número da Placa: "
            + veiculoEsporte.ObterNumeroPlaca());
        System.out.println("Modelo: " + veiculoEsporte.ObterModelo());
        System.out.println("Fabricante: " + veiculoEsporte.ObterFabricante());
        System.out.println("Ano de Fabricação: "
            + veiculoEsporte.ObterAnoFabricacao());
        System.out.println("Cor: " + veiculoEsporte.ObterCor());
        System.out.println("Potência: " + veiculoEsporte.ObterPotencia()
            + " hp");
        System.out.println("Aceleração: " + veiculoEsporte.ObterAceleracao()
            + " 0 - 100km/h em seg.");
 
    }
 
}
    

