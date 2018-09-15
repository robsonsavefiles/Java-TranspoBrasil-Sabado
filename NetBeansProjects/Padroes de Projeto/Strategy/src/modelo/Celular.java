package modelo;


import classes.PromocaoDeNatal;


public class Celular extends Produto {
    public Celular() {
        this.promocao = new PromocaoDeNatal();
    }
}