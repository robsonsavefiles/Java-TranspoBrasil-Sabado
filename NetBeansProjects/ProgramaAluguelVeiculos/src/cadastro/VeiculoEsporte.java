package cadastro;
 
import veiculo.Veiculo;

public class VeiculoEsporte extends Veiculo {
 
    private int potencia;
    private float aceleracao;
 
    public VeiculoEsporte() {
    }
 
    public VeiculoEsporte(int _numeroChassi, String _numeroPlaca, String _fabricante, String _modelo, int _anoFabricacao, String _cor, int _potencia, float _aceleracao) {
        numeroChassi = _numeroChassi;
        numeroPlaca = _numeroPlaca;
        fabricante = _fabricante;
        modelo = _modelo;
        anoFabricacao = _anoFabricacao;
        cor = _cor;
        potencia = _potencia;
        aceleracao = _aceleracao;
    }
 
    public void DefinirPotencia(int _potencia) {
        potencia = _potencia;
    }
 
    public int ObterPotencia() {
        return (potencia);
    }
 
    public void DefinirAceleracao(float _aceleracao) {
        aceleracao = _aceleracao;
    }
 
    public float ObterAceleracao() {
        return (aceleracao);
    }
 
}