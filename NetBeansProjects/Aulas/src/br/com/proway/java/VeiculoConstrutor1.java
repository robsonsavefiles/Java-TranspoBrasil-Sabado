package br.com.proway.java;

public class VeiculoConstrutor1 {

    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int anomodelo;

    public VeiculoConstrutor1(String paramMarca) {
        this(paramMarca, null);
    }

    public VeiculoConstrutor1(String paramMarca, String paramModelo) {//construtor
        super();// chama o construtro de Object
        System.out.println("construtor de veiculo chamado");
        marca = paramMarca;
    }

    public VeiculoConstrutor1(String paramMarca, String paramModelo, int paramAnoFab, int paraAnoFab, int paramAnoMod, int anoModelo) {
        super();
        marca = paramMarca;
        modelo = paramModelo;
        anoFabricacao = paramAnoFab;
        anoModelo = paramAnoMod;

    }

    public int getAnofabricacao() {
        return anoFabricacao;
    }

    public void setAnofabricacao(int anofabricacao) {
        this.anoFabricacao = anofabricacao;
    }

    public int getAnomodelo() {
        return anomodelo;
    }

    public void setAnomodelo(int anomodelo) {
        this.anomodelo = anomodelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
