package cadastro;

import veiculo.Veiculo;

public class VeiculoOnibus extends Veiculo {
 
    
    private int quantidadePassageiros;
    private int numeroEixos;
 
    public VeiculoOnibus() {
    }
 
    public VeiculoOnibus(int _numeroChassi, String _numeroPlaca, String _fabricante, String _modelo, int _anoFabricacao, String _cor, int _quantidadePassageiros, int _numeroEixos) {
        numeroChassi = _numeroChassi;
        numeroPlaca = _numeroPlaca;
        fabricante = _fabricante;
        modelo = _modelo;
        anoFabricacao = _anoFabricacao;
        cor = _cor;
        quantidadePassageiros = _quantidadePassageiros;
        numeroEixos = _numeroEixos;
    }
 
    public void DefinirQuantidadePassageiros(int _quantidadePassageiros) {
        quantidadePassageiros = _quantidadePassageiros;
    }
 
    public int ObterQuantidadePassageiros() {
        return (quantidadePassageiros);
    }
 
    public void DefinirNumeroEixos(int _numeroEixos) {
        numeroEixos = _numeroEixos;
    }
 
    public int ObterNumeroEixos() {
        return (numeroEixos);
    }
    
}
 