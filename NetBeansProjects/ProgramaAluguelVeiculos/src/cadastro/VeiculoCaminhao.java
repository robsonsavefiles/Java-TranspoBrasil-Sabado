package cadastro;
 
import veiculo.Veiculo;

public class VeiculoCaminhao extends Veiculo{
 
    private float capacidadeCarga;
    private int numeroEixos;
 
 
    public VeiculoCaminhao() {
    }
 
    public VeiculoCaminhao(int _numeroChassi, String _numeroPlaca, String _fabricante,
String _modelo, int _anoFabricacao, String _cor, float _capacidadeCarga, int _numeroEixos) {
        numeroChassi = _numeroChassi;
        numeroPlaca = _numeroPlaca;
        fabricante = _fabricante;
        modelo = _modelo;
        anoFabricacao = _anoFabricacao;
        cor = _cor;
        capacidadeCarga = _capacidadeCarga;
        numeroEixos = _numeroEixos;
    }
 
    public void DefinirCapacidadeCarga(float _capacidadeCarga){
        capacidadeCarga = _capacidadeCarga;
    }
 
    public float ObterCapacidadeCarga(){
        return(capacidadeCarga);
    }
 
    public void DefinirNumeroEixos(int _numeroEixos){
        numeroEixos = _numeroEixos;
    }
 
    public int ObterNumeroEixos(){
        return(numeroEixos);
    }
}
