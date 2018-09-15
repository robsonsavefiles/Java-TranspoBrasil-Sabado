package exer26ate28.produto.model;

import static exer26ate28.produto.model.Cliente.CAMPOS;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 78522
 */
public class Modelo extends Entidade {

    public static final Map<String, InfoCampo> CAMPOS = new HashMap();

    public static final InfoCampo CAMPO_MARCA = new InfoCampo("Marca", 50);
    public static final InfoCampo CAMPO_NOME = new InfoCampo("Nome", 50);
    public static final InfoCampo CAMPO_ANO = new InfoCampo("Ano", 10);

    static {
        CAMPOS.put(CAMPO_ID.getNome(), CAMPO_ID);
        CAMPOS.put(CAMPO_DATA_CRIACAO.getNome(), CAMPO_DATA_CRIACAO);
        CAMPOS.put(CAMPO_DATA_ALTERACAO.getNome(), CAMPO_DATA_ALTERACAO);
        CAMPOS.put(CAMPO_MARCA.getNome(), CAMPO_MARCA);
        CAMPOS.put(CAMPO_NOME.getNome(), CAMPO_NOME);
        CAMPOS.put(CAMPO_ANO.getNome(), CAMPO_ANO);
    }

    private Marca marca;
    private String nome;
    private int ano;

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Modelo() {
    }

    public Modelo(LocalDateTime dataCriacao, LocalDateTime dataAlteracao, Marca marca, String nome, int ano) {
        this(null, dataCriacao, dataAlteracao, marca, nome, ano);
    }

    public Modelo(Long id, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, Marca marca, String nome, int ano) {
        super(id, dataCriacao, dataAlteracao);
        this.marca = marca;
        this.nome = nome;
        this.ano = ano;
    }

    @Override
    public String infoLinhaString() {
        String retorno = "";
        retorno += super.infoLinhaString() + "|";
        retorno += String.format("%-" + CAMPO_NOME.getTamanhoImpressao() + "s", nome) + "|";
        retorno += String.format("%-" + CAMPO_ANO.getTamanhoImpressao() + "d", ano) + "|";
        retorno += marca.infoLinhaString();
        return retorno;
    }

        @Override
    public Map<String, InfoCampo> getCampos() {
        return CAMPOS;
    }
}
