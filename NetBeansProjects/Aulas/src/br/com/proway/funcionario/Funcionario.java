package aula.pkg009;

import java.util.Objects;

/**
 *
 * @author 78522
 */
public class Funcionario {

    private Long codigo;
    private String nome;
    private double salarioBase;
    private Cargo cargo;

    public Funcionario(Long codigo, String nome, double salarioBase, Cargo cargo) {
        this.codigo = codigo;
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
    }

    public Funcionario() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigo);
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
        final Funcionario other = (Funcionario) obj;
        return Objects.equals(this.codigo, other.codigo);
    }
}
