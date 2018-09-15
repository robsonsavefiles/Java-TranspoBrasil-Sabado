package br.com.proway.serializacao;

import java.io.IOException;
import java.io.ObjectInputStream;

public class Telefone {

    private String codigoPais;
    private String codigo;
    private String numero;

    public Telefone(String codigoPais, String codigo, String numero) {
        this.codigoPais = codigoPais;
        this.codigo = codigo;
        this.numero = numero;
    }

    public Telefone() {
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefone{" + "codigoPais=" + codigoPais + ", codigo=" + codigo + ", numero=" + numero + '}';
    }
}