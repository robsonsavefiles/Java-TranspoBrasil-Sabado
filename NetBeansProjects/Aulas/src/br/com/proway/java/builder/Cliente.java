//builder -> encapsula um objeto

package br.com.proway.java.builder;

import java.util.Date;

/**
 *
 * @author 89087
 */
public class Cliente {
    
    private Long id;
    private Nome nome;
    private String cpf;
    private Date dataNascimento;
    private Genero sexo;
    private TelefoneContato contato;

    Cliente(Long id, Nome nome, String cpf, Date dataNascimento, Genero sexo,TelefoneContato contato) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.contato = contato;
        
    }

    public TelefoneContato getContato() {
        return contato;
    }

    public void setContato(TelefoneContato contato) {
        this.contato = contato;
    }

    public Cliente(Long id, Nome nome, String sobrenome, String cpf, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Nome getNome() {
        return nome;
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

}
