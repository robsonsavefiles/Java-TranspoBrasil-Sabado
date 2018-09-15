/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;
import cadastro.VeiculoOnibus;
/**
 *
 * @author Robinho
 */
public class CadastroOnibus {
    
    VeiculoOnibus veiculoOnibus = new VeiculoOnibus();
 
    public CadastroOnibus() {
    }
 
    public void ExecutaCadastro() {
 
        System.out.println("Número do Chassi:");
        veiculoOnibus.DefinirNumeroChassi(Teclado.LerInteiro());
 
        System.out.println("Número da Placa:");
        veiculoOnibus.DefinirNumeroPlaca(Teclado.LerString());
 
        System.out.println("Modelo:");
        veiculoOnibus.DefinirModelo(Teclado.LerString());
 
        System.out.println("Fabricante:");
        veiculoOnibus.DefinirFabricante(Teclado.LerString());
 
        System.out.println("Ano de Fabricação:");
        veiculoOnibus.DefinirAnoFabricacao(Teclado.LerInteiro());
 
        System.out.println("Cor:");
        veiculoOnibus.DefinirCor(Teclado.LerString());
 
        System.out.println("Quantidade de Passageiros:");
        veiculoOnibus.DefinirQuantidadePassageiros(Teclado.LerInteiro());
 
        System.out.println("Número de Eixos:");
        veiculoOnibus.DefinirNumeroEixos(Teclado.LerInteiro());
 
        System.out.println("Cadastro de Onibus: ");
        System.out.println("Número do Chassi: "
            + veiculoOnibus.ObterNumeroChassi());
        System.out.println("Número da Placa: "
            + veiculoOnibus.ObterNumeroPlaca());
        System.out.println("Modelo: " + veiculoOnibus.ObterModelo());
        System.out.println("Fabricante: " + veiculoOnibus.ObterFabricante());
        System.out.println("Ano de Fabricação: "
            + veiculoOnibus.ObterAnoFabricacao());
        System.out.println("Cor: " + veiculoOnibus.ObterCor());
        System.out.println("Número de Passageiros: "
            + veiculoOnibus.ObterQuantidadePassageiros());
        System.out.println("Número de Eixos: " + veiculoOnibus.ObterNumeroEixos());
 
    }
 
}
    

