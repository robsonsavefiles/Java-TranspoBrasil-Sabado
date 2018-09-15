package cadastro;
 
import veiculo.Veiculo;

public class VeiculoOffRoad extends Veiculo {
 
    private float alturaSolo;
    private String tracao;
 
    public VeiculoOffRoad() {
    }
 
    public VeiculoOffRoad(int _numeroChassi, String _numeroPlaca, String _fabricante, String _modelo, int _anoFabricacao, String _cor, float _alturaSolo, String _tracao) {
        numeroChassi = _numeroChassi;
        numeroPlaca = _numeroPlaca;
        fabricante = _fabricante;
        modelo = _modelo;
        anoFabricacao = _anoFabricacao;
        cor = _cor;
        alturaSolo = _alturaSolo;
        tracao = _tracao;
    }
 
    public void DefinirAlturaSolo(float _alturaSolo) {
        alturaSolo = _alturaSolo;
    }
 
    public float ObterAlturaSolo() {
        return (alturaSolo);
    }
 
    public void DefinirTracao(String _tracao) {
        tracao = _tracao;
    }
 
    public String ObterTracao() {
        return (tracao);
    }
}
