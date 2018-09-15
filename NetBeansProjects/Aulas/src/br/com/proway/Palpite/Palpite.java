package Palpite;

/**
 *
 * @author 78522
 */
public class Palpite {

    private final int valor;

    public Palpite(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.valor;
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
        final Palpite other = (Palpite) obj;
        if (this.valor != other.valor) {
            return false;
        }
        return true;
    }

}
