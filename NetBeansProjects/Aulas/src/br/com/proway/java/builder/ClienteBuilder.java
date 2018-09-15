//essa classe
package br.com.proway.java.builder;

import java.util.Date;
import java.util.Objects;

public class ClienteBuilder {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private Date dataNascimento;
    private Genero sexo;
    private String telefoneResidencial;
    private String telefoneCelular;
    private String telefoneRecados;
    
    public ClienteBuilder(String nome,String sobrenome,String cpf){
        this.nome = Objects.requireNonNull(nome,"Nome nao pode ser nulo");
        this.sobrenome = Objects.requireNonNull(sobrenome,"Sobrenome nao pode ser nulo");
        this.cpf = cpf = Objects.requireNonNull(cpf,"Cpf nao pode ser nulo");
    }
    
    public Cliente build(){
       Nome nomeCompleto = new Nome(nome,sobrenome);
       TelefoneContato telefoneContato = new TelefoneContato(telefoneResidencial,telefoneCelular,telefoneRecados);
       return new Cliente(id,nomeCompleto, cpf, dataNascimento, sexo,telefoneContato);
    }

    public ClienteBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ClienteBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public ClienteBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public ClienteBuilder setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public ClienteBuilder setSexo(Genero sexo) {
        this.sexo = sexo;
        return this;
    }

    public ClienteBuilder setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
         return this;
    }

    public ClienteBuilder setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
         return this;
    }

    public ClienteBuilder setTelefoneRecados(String telefoneRecados) {
        this.telefoneRecados = telefoneRecados;
         return this;
    }

}
