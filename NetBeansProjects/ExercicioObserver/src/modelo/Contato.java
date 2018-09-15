package modelo;

import java.util.Objects;

public class Contato {

    private String nome;
    private String cpf;
    private String telefone;
    private String numero;
    private String bairro;
    private String cidade;

    public Contato() {
    }

    public Contato(String nome, String cpf, String telefone, String numero, String bairro, String cidade) {

        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Contato{nome=" + nome + ", cpf=" + cpf + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + '}';
    }

}
