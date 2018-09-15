package veiculo;
 
public class Veiculo {
 
    protected int numeroChassi;
    protected String numeroPlaca;
    protected String fabricante;
    protected String modelo;
    protected int anoFabricacao;
    protected String cor;
 
    public Veiculo() {
    }
 
    public Veiculo(int _numeroChassi, String _numeroPlaca, String _fabricante, String _modelo, int _anoFabricacao, String _cor) {
        numeroChassi = _numeroChassi;
        numeroPlaca = _numeroPlaca;
        fabricante = _fabricante;
        modelo = _modelo;
        anoFabricacao = _anoFabricacao;
        cor = _cor;
    }
 
    public void DefinirNumeroChassi(int _numeroChassi) {
        numeroChassi = _numeroChassi;
    }
 
    public int ObterNumeroChassi() {
        return (numeroChassi);
    }
 
    public void DefinirNumeroPlaca(String _numeroPlaca) {
        numeroPlaca = _numeroPlaca;
    }
 
    public String ObterNumeroPlaca() {
        return (numeroPlaca);
    }
 
    public void DefinirFabricante(String _fabricante) {
        fabricante = _fabricante;
    }
 
    public String ObterFabricante() {
        return (fabricante);
    }
 
    public void DefinirModelo(String _modelo) {
        modelo = _modelo;
    }
 
    public String ObterModelo() {
        return (modelo);
    }
 
    public void DefinirCor(String _cor) {
        cor = _cor;
    }
 
    public String ObterCor() {
        return (cor);
    }
 
    public void DefinirAnoFabricacao(int _anoFabricacao) {
        anoFabricacao = _anoFabricacao;
    }
 
    public int ObterAnoFabricacao() {
        return (anoFabricacao);
    }
}
