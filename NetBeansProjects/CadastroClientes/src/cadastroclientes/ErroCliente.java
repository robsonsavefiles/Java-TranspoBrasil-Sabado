/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroclientes;

/**
 *
 * @author 89087
 */
public class ErroCliente {

    private String nome;
    private String descricao;
    private int cpf;
    private String telefone;

    public ErroCliente() {

    }

    public ErroCliente(String nome, String descricao, int cpf, String telefone) {
        this.nome = nome;
        this.descricao = descricao;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(int cpf) {
        this.cpf = cpf;
    }

    public int getCpf() {
        return cpf;
    }

    public String telefone() {
        return telefone;
    }

    public void setNome(String telefone) {
        this.telefone = telefone;
    }

    public void setCPF(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}


