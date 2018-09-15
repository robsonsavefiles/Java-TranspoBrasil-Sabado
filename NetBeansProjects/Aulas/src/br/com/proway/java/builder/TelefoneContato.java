
package br.com.proway.java.builder;

/**
 *
 * @author 89087
 */
public class TelefoneContato {
    private String telefoneResidencial;
    private String telefoneCelular;
    private String telefoneRecados;

    public TelefoneContato(String telefoneResidencial, String telefoneCelular, String telefoneRecados) {
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneCelular = telefoneCelular;
        this.telefoneRecados = telefoneRecados;
    }

    public TelefoneContato() {
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneRecados() {
        return telefoneRecados;
    }

    public void setTelefoneRecados(String telefoneRecados) {
        this.telefoneRecados = telefoneRecados;
    }
    
    
}
