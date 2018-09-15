/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professor;

import certificacoes.Certificacao;
import comuns.Endereco;
import comuns.Escolaridade;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 66463
 */
public class Professor {
    
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private Escolaridade escolaridade;
    private String telefone;
    private String cpf;
    private Endereco endereco;
    private List<Certificacao> certificacoes = new ArrayList<>();

    public Professor() {
    }

    public Professor(Long id, String nome, String sobrenome, String email, Escolaridade escolaridade, String telefone, String cpf, Endereco endereco, List<Certificacao> certificacoes) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.escolaridade = escolaridade;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.certificacoes = certificacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Certificacao> getCertificacoes() {
        return certificacoes;
    }

    public void addCertificacao(Certificacao certificacoes) {
        this.certificacoes.add(certificacoes);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", escolaridade=" + escolaridade + ", telefone=" + telefone + ", cpf=" + cpf + ", endereco=" + endereco + ", certificacoes=" + certificacoes + '}';
    }
    
    
    

    
}
