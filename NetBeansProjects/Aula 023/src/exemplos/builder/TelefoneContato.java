package exemplos.builder;

/**
 *
 * @author 78522
 */
public class TelefoneContato {

    private String telefoneResidencial;
    private String telefoneComercial;
    private String telefoneCelular;
    private String telefoneRecados;

    public TelefoneContato() {
    }

    public TelefoneContato(String telefoneResidencial, String telefoneComercial, String telefoneCelular, String telefoneRecados) {
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneComercial = telefoneComercial;
        this.telefoneCelular = telefoneCelular;
        this.telefoneRecados = telefoneRecados;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
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
