package aula.pkg009;

/**
 *
 * @author 78522
 */
public abstract class Cargo {

    private Long id;
    private String nome;
    private double salarioBase;

    public Cargo(String nome, double salarioBase) {
        this(null, nome, salarioBase);
    }

    public Cargo(Long id, String nome, double salarioBase) {
        this.id = id;
        this.nome = nome;
        this.salarioBase = salarioBase;
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

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public abstract double getSalarioTotal();
}
