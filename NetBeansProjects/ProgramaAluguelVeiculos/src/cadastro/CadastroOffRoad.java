/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;
import java.util.Scanner;
/**
 *
 * @author Robinho
 */
public class CadastroOffRoad {
    
    VeiculoOffRoad veiculoOffRoad = new VeiculoOffRoad();
 
    public CadastroOffRoad() {
    }

    public void ExecutaCadastro() {
 
        System.out.println("Número do Chassi:");
        veiculoOffRoad.DefinirNumeroChassi(Teclado.LerInteiro());
 
        System.out.println("Número da Placa:");
        veiculoOffRoad.DefinirNumeroPlaca(Teclado.LerString());
 
        System.out.println("Modelo:");
        veiculoOffRoad.DefinirModelo(Teclado.LerString());
 
        System.out.println("Fabricante:");
        veiculoOffRoad.DefinirFabricante(Teclado.LerString());
 
        System.out.println("Ano de Fabricação:");
        veiculoOffRoad.DefinirAnoFabricacao(Teclado.LerInteiro());
 
        System.out.println("Cor:");
        veiculoOffRoad.DefinirCor(Teclado.LerString());
 
        System.out.println("Altura em Relação ao Solo (centímetros):");
        veiculoOffRoad.DefinirAlturaSolo(Teclado.LerFloat());
 
        System.out.println("Tração:");
        veiculoOffRoad.DefinirTracao(Teclado.LerString());
 
        System.out.println("Cadastro de Onibus: ");
        System.out.println("Número do Chassi: "
            + veiculoOffRoad.ObterNumeroChassi());
        System.out.println("Número da Placa: "
            + veiculoOffRoad.ObterNumeroPlaca());
        System.out.println("Modelo: " + veiculoOffRoad.ObterModelo());
        System.out.println("Fabricante: " + veiculoOffRoad.ObterFabricante());
        System.out.println("Ano de Fabricação: "
            + veiculoOffRoad.ObterAnoFabricacao());
        System.out.println("Cor: " + veiculoOffRoad.ObterCor());
        System.out.println("Altura em Relação ao Solo: "
            + veiculoOffRoad.ObterAlturaSolo() + "cm");
        System.out.println("Tração: " + veiculoOffRoad.ObterTracao());
     
    }
 
}

