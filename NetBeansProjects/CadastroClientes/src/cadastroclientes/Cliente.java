/*
Seu joão necessita de uma nova funcionalidade no sistema de sua oficina, ele necessita armazenar informações referente aos seus clientes.
após uma análise, o analista definiu que as informações relevantes referente ao Cliente são:
Nome
DataNascimento
Nome do pai
Nome da mãe
CPF
Telefone


implemente o cadastro destas informações:
 */
package cadastroclientes;

import java.util.Date;
import java.util.Objects;



public class Cliente{
    
    private Long id;
    private String Nome;
    private String cpf;
    private String dataNascimento;
    private String NomePai;
    private String NomeMae;
    private String telefone;

    public Cliente() {
    }

    public Cliente(Long id, String Nome,String cpf, String dataNascimento, String NomePai, String NomeMae, String telefone) {
        super();
        this.id = id;
        this.cpf= cpf;
        this.Nome = Nome;
        this.dataNascimento = dataNascimento;
        this.NomePai = NomePai;
        this.NomeMae = NomeMae;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
     public String getCpf(String cpf) {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomePai() {
        return NomePai;
    }

    public void setNomePai(String NomePai) {
        this.NomePai = NomePai;
    }

    public String getNomeMae() {
        return NomeMae;
    }

    public void setNomeMae(String NomeMae) {
        this.NomeMae = NomeMae;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Nome=" + Nome +  ", cpf=" + cpf +", dataNascimento=" + dataNascimento + ", NomePai=" + NomePai + ", NomeMae=" + NomeMae + ", telefone=" + telefone + '}';
    }

    @Override
    public int hashCode() {
        int hash = 8;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.cpf);
        hash = 89 * hash + Objects.hashCode(this.Nome);
        hash = 89 * hash + Objects.hashCode(this.dataNascimento);
        hash = 89 * hash + Objects.hashCode(this.NomePai);
        hash = 89 * hash + Objects.hashCode(this.NomeMae);
        hash = 89 * hash + Objects.hashCode(this.telefone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.NomePai, other.NomePai)) {
            return false;
        }
        if (!Objects.equals(this.NomeMae, other.NomeMae)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        return true;
    }

    void setDataAltercao(Date agora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
