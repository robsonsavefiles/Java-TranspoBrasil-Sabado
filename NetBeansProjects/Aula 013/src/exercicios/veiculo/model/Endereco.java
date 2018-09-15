package exercicios.veiculo.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 78522
 */
public class Endereco implements Serializable, Imprimivel {

    public static final Map<String, InfoCampo> CAMPOS = new HashMap();

    public static final InfoCampo CAMPO_RUA = new InfoCampo("Rua", 50);
    public static final InfoCampo CAMPO_NUMERO = new InfoCampo("Numero", 10);
    public static final InfoCampo CAMPO_COMPLEMENTO = new InfoCampo("Complemento", 20);
    public static final InfoCampo CAMPO_BAIRRO = new InfoCampo("Bairro", 20);
    public static final InfoCampo CAMPO_CIDADE = new InfoCampo("Cidade", 20);
    public static final InfoCampo CAMPO_CEP = new InfoCampo("CEP", 20);
    public static final InfoCampo CAMPO_ESTADO = new InfoCampo("Estado", 20);

    static {
        CAMPOS.put(CAMPO_RUA.getNome(), CAMPO_RUA);
        CAMPOS.put(CAMPO_NUMERO.getNome(), CAMPO_NUMERO);
        CAMPOS.put(CAMPO_COMPLEMENTO.getNome(), CAMPO_COMPLEMENTO);
        CAMPOS.put(CAMPO_BAIRRO.getNome(), CAMPO_BAIRRO);
        CAMPOS.put(CAMPO_CIDADE.getNome(), CAMPO_CIDADE);
        CAMPOS.put(CAMPO_CEP.getNome(), CAMPO_CEP);
        CAMPOS.put(CAMPO_ESTADO.getNome(), CAMPO_ESTADO);
    }

    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;

    public Endereco() {
    }

    public Endereco(String rua, int numero, String complemento, String bairro, String cidade, String cep, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String infoLinhaString() {
        String retorno = "";
        retorno += String.format("%-" + CAMPO_RUA.getTamanhoImpressao() + "s", rua) + "|";
        retorno += String.format("%-" + CAMPO_NUMERO.getTamanhoImpressao() + "d", numero) + "|";
        retorno += String.format("%-" + CAMPO_COMPLEMENTO.getTamanhoImpressao() + "s", complemento) + "|";
        retorno += String.format("%-" + CAMPO_BAIRRO.getTamanhoImpressao() + "s", bairro) + "|";
        retorno += String.format("%-" + CAMPO_CIDADE.getTamanhoImpressao() + "s", cidade) + "|";
        retorno += String.format("%-" + CAMPO_ESTADO.getTamanhoImpressao() + "s", estado + "|");
        retorno += String.format("%-" + CAMPO_CEP.getTamanhoImpressao() + "s", cep);
        return retorno;
    }

}
