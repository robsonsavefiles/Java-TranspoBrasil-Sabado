package exer26ate28.cadastro;

import exer26ate28.produto.model.InfoCampo;

/**
 *
 * @author 89087
 */
public class OpcaoMenu {

    private int id;
    private String descricao;
    private InfoCampo campo;

    public OpcaoMenu(int id, String descricao, InfoCampo campo) {
        this.id = id;
        this.descricao = descricao;
        this.campo = campo;
    }

    public OpcaoMenu(int id, String descricao) {
        this(id, descricao, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
