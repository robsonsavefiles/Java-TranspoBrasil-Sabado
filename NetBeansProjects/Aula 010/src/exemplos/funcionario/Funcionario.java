package exemplos.funcionario;

import exemplos.funcionario.acesso.FuncionarioAcesso;
import exemplos.funcionario.folha.FuncionarioFolha;
import exemplos.funcionario.rh.FuncionarioRH;

/**
 *
 * @author 78522
 */
public class Funcionario implements FuncionarioAcesso, FuncionarioFolha, FuncionarioRH {

    private String codigoAutenticacao;
    private String codigo;
    private String nome;
    private String cpf;
    private String cargo;
    private int anoNascimento;
    private int dependentes;
    private String escolaridade;
    private double salario;

    public Funcionario() {
    }

    public Funcionario(String codigoAutenticacao, String codigo, String nome, String cpf, String cargo, int anoNascimento, int dependentes, String escolaridade, double salario) {
        this.codigoAutenticacao = codigoAutenticacao;
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.anoNascimento = anoNascimento;
        this.dependentes = dependentes;
        this.escolaridade = escolaridade;
        this.salario = salario;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCodigoAutenticacao(String codigoAutenticacao) {
        this.codigoAutenticacao = codigoAutenticacao;
    }

    @Override
    public String getCodigoAutenticacao() {
        return codigoAutenticacao;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    @Override
    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    @Override
    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

}
