package aula.exercicios.util;

/**
 *
 * @author 78522
 */
public class NumeroExtenso {

    private String unidade;
    private String dezena;
    private String centena;

    public NumeroExtenso(String unidade, String dezena, String centena) {
        this.unidade = unidade;
        this.dezena = dezena;
        this.centena = centena;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getDezena() {
        return dezena;
    }

    public void setDezena(String dezena) {
        this.dezena = dezena;
    }

    public String getCentena() {
        return centena;
    }

    public void setCentena(String centena) {
        this.centena = centena;
    }

    public String[] arrayValores() {
        return new String[]{centena, unidade, dezena};
    }
}
