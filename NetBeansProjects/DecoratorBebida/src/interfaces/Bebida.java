package interfaces;


public abstract class Bebida {

    private String descricao = "Bebida desconhecida";

    public Bebida() {
    }

    public Bebida(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
