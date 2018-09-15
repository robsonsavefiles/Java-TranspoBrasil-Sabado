package modelo;

import interfaces.Promocao;

public class Produto {
    
    protected Promocao promocao;
    
    public int desconto() {
        return promocao.desconto();
    }
}