
/**
 *
 * @author 78522
 */
public class Telefone {

    private String codigoPais;
    private String codigoArea;
    private String numero;

    public Telefone() {
    }

    public Telefone(String codigoPais, String codigoArea, String numero) {
        this.codigoPais = codigoPais;
        this.codigoArea = codigoArea;
        this.numero = numero;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefone{" + "codigoPais=" + codigoPais + ", codigoArea=" + codigoArea + ", numero=" + numero + '}';
    }

}
