package classes;


import interfaces.Promocao;

public class PromocaoQueimaDeEstoque implements Promocao {
    public int desconto() {
        return 40;
    }
}