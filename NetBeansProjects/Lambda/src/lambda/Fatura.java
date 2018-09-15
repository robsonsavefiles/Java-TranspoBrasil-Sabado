package lambda;

import java.time.LocalDate;

/**
 *
 * @author 78522
 */
public class Fatura {

    private double valor;
    private LocalDate vencimento;
    private String emailDevedor;

    public Fatura(double valor, LocalDate vencimento, String emailDevedor) {
        this.valor = valor;
        this.vencimento = vencimento;
        this.emailDevedor = emailDevedor;
    }

    public Fatura() {
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public String getEmailDevedor() {
        return emailDevedor;
    }

    public void setEmailDevedor(String emailDevedor) {
        this.emailDevedor = emailDevedor;
    }

    @Override
    public String toString() {
        return "Fatura{" + "valor=" + valor + ", vencimento=" + vencimento + ", emailDevedor=" + emailDevedor + '}';
    }
}
