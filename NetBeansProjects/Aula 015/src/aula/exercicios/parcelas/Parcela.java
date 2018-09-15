package aula.exercicios.parcelas;

/**
 *
 * @author 78522
 */
public class Parcela {

    int numero;
    double valor;

    public Parcela(int numero, double valor) {
        this.numero = numero;
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
