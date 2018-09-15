package avaliacao.questao26.menus;

import avaliacao.questao26.informacao.InfoCampo;

/**
 *
 * @author 89087
 */
public class OpcaoMenu {

    private String id;
    private String descricao;
    private InfoCampo campo;

    public OpcaoMenu(String id, String descricao, InfoCampo campo) {
        this.id = id;
        this.descricao = descricao;
        this.campo = campo;
    }

    public OpcaoMenu(String id, String descricao) {
        this(id, descricao, null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public InfoCampo getCampo() {
        return campo;
    }

    public void setCampo(InfoCampo campo) {
        this.campo = campo;
    }

    public String getString() {
        return id + " - " + descricao;
    }

}
