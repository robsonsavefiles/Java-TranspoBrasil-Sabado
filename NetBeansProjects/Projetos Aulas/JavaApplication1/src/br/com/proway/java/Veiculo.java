package br.com.proway.java;
import java.util.Objects;

public class Veiculo {

    //Caracteristica// atributos
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    private  String marca;
    private  String modelo;
    private int anoFabricacao;
    private int anoModelo; 
    private int anoFabAte;
    private int anoModAte;

    public int getAnoFabAte() {
        return anoFabAte;
    }

    public void setAnoFabAte(int anoFabAte) {
        this.anoFabAte = anoFabAte;
    }

    public int getAnoModAte() {
        return anoModAte;
    }

    public void setAnoModAte(int anoModAte) {
        this.anoModAte = anoModAte;
    }
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String nome) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;

    }
    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;

    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
