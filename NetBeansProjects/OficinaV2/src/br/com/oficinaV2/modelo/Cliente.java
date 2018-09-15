
package br.com.oficinaV2.modelo;

/**
 *
 * @author 89087
 */
public class Cliente {
    
    private String nome;
    private String cpf;
    private String telefone;
    private String placadocarro;
    private String Endereco;

    public Cliente(String nome, String cpf, String telefone, String placadocarro, String Endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.placadocarro = placadocarro;
        this.Endereco = Endereco;
    }

    public Cliente() {
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

    public String getPlacadocarro() {
        return placadocarro;
    }

    public void setPlacadocarro(String placadocarro) {
        this.placadocarro = placadocarro;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", placadocarro=" + placadocarro + ", Endereco=" + Endereco + '}';
    }

}
