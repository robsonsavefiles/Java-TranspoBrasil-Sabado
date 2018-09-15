package avaliacao.questao26.modelos;

import java.util.Date;

/**
 *
 * @author 89087
 */
public class Cliente extends Entidade {

    private String nome;
    private String cpf;
    private String telefone;
    private String celular;
    private String endereco;

    

    public Cliente() {
    }

    public Cliente(Date dataCriacao, Date dataAlteracao, String nome, String cpf, String telefone, String celular,String endereco) {
        this(null, dataCriacao, dataAlteracao, nome, cpf, telefone, celular,endereco);
    }

    public Cliente(Long id, Date dataCriacao, Date dataAlteracao, String nome, String cpf, String telefone, String celular,String endereco) {
        super(id, dataCriacao, dataAlteracao);
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.celular = celular;
        this.endereco = endereco;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", celular=" + celular + ",endereco="+endereco+'}';
    }

}
