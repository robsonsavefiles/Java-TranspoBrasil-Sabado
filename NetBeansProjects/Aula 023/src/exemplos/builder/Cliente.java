package exemplos.builder;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 78522
 */
public class Cliente {

    private Long id;
    private final Nome nome;
    private final String cpf;
    private Date dataNascimento;
    private Genero sexo;
    private TelefoneContato telefones;

    public Cliente(Long id, Nome nome, String cpf, Date dataNascimento, Genero sexo, TelefoneContato telefones) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefones = telefones;
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

    public String getCpf() {
        return cpf;
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

    public TelefoneContato getTelefones() {
        return telefones;
    }

    public void setTelefones(TelefoneContato telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", telefones=" + telefones + '}';
    }

    public static class Builder implements IBuilder<Cliente> {

        private Long id;
        private String nome;
        private String sobrenome;
        private String cpf;
        private Date dataNascimento;
        private Genero sexo;
        private String telefoneResidencial;
        private String telefoneComercial;
        private String telefoneCelular;
        private String telefoneRecados;

        public Builder(String nome, String sobrenome, String cpf) {
            this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo.");
            this.sobrenome = Objects.requireNonNull(sobrenome, "Sobrenome não pode ser nulo.");
            this.cpf = Objects.requireNonNull(cpf, "Cpf não pode ser nulo.");
        }

        @Override
        public Cliente build() {
            Nome nomeCompleto = new Nome(nome, sobrenome);
            TelefoneContato telefones = new TelefoneContato(telefoneResidencial, telefoneComercial, telefoneCelular, telefoneRecados);
            return new Cliente(id, nomeCompleto, cpf, dataNascimento, sexo, telefones);
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public Builder setCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder setDataNascimento(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public Builder setSexo(Genero sexo) {
            this.sexo = sexo;
            return this;
        }

        public Builder setTelefoneResidencial(String telefoneResidencial) {
            this.telefoneResidencial = telefoneResidencial;
            return this;
        }

        public Builder setTelefoneComercial(String telefoneComercial) {
            this.telefoneComercial = telefoneComercial;
            return this;
        }

        public Builder setTelefoneCelular(String telefoneCelular) {
            this.telefoneCelular = telefoneCelular;
            return this;
        }

        public Builder setTelefoneRecados(String telefoneRecados) {
            this.telefoneRecados = telefoneRecados;
            return this;
        }

    }

}
