package exer26ate28.produto.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 78522
 */
public class Marca extends Entidade {

    public static final Map<String, InfoCampo> CAMPOS = new HashMap();

    public static final InfoCampo CAMPO_NOME = new InfoCampo("Nome", 50);

    static {
        CAMPOS.put(CAMPO_ID.getNome(), CAMPO_ID);
        CAMPOS.put(CAMPO_DATA_CRIACAO.getNome(), CAMPO_DATA_CRIACAO);
        CAMPOS.put(CAMPO_DATA_ALTERACAO.getNome(), CAMPO_DATA_ALTERACAO);
        CAMPOS.put(CAMPO_NOME.getNome(), CAMPO_NOME);
    }

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca() {
    }

    public Marca(LocalDateTime dataCriacao, LocalDateTime dataAlteracao, String nome) {
        super(dataCriacao, dataAlteracao);
        this.nome = nome;
    }

    public Marca(Long id, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, String nome) {
        super(id, dataCriacao, dataAlteracao);
        this.nome = nome;
    }

    @Override
    public String infoLinhaString() {
        String retorno = "";
        retorno += super.infoLinhaString() + "|";
        retorno += String.format("%-" + CAMPO_NOME.getTamanhoImpressao() + "s", nome);
        return retorno;
    }

    @Override
    public Map<String, InfoCampo> getCampos() {
        return CAMPOS;
    }

}
