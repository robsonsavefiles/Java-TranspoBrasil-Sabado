package aula.exercicios.util;


/**
 *
 * @author 78522
 */
public class NumeroExtensoPrefixo {

    private String singular;
    private String plural;

    public NumeroExtensoPrefixo(String singular, String plural) {
        this.singular = singular;
        this.plural = plural;
    }

    public String getSingular() {
        return singular;
    }

    public void setSingular(String singular) {
        this.singular = singular;
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

}
