package avaliacao.questao26.info;

import avaliacao.questao26.model.Entidade;

/**
 *
 * @author 78522
 */
public abstract class EntidadeInfo {

    public static final String SEPARADOR = "|\t";

    public static final InfoCampo CAMPO_ID = new InfoCampo("ID", 20);
    public static final InfoCampo CAMPO_DATA_CRIACAO = new InfoCampo("Data de Criação", 20);
    public static final InfoCampo CAMPO_DATA_ALTERACAO = new InfoCampo("Data de Alteração", 20);

    public static String infoCabecalhoString() {
        String retorno = "";
        retorno += String.format("%-" + CAMPO_ID.getTamanhoImpressao() + "s", CAMPO_ID.getNome());
        return retorno;
    }

    public static String infoLinhaString(Entidade obj) {
        String retorno = "";
        retorno += String.format("%-" + CAMPO_ID.getTamanhoImpressao() + "d", obj.getId());
        return retorno;
    }

    public static Object getValueCampo(Entidade entidade, InfoCampo campo) {
        if (campo == EntidadeInfo.CAMPO_ID) {
            return entidade.getId();
        }
        if (campo == EntidadeInfo.CAMPO_DATA_CRIACAO) {
            return entidade.getDataCriacao();
        }
        if (campo == EntidadeInfo.CAMPO_DATA_ALTERACAO) {
            return entidade.getDataAlteracao();
        }
        throw new AssertionError();
    }
}
