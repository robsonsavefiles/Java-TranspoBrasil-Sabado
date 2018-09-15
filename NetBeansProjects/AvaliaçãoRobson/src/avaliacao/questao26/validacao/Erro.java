package avaliacao.questao26.validacao;

import avaliacao.questao26.info.InfoCampo;

/**
 *
 * @author 78522
 */
public class Erro {

    private InfoCampo campo;
    private String descricao;

    public Erro() {
    }

    public Erro(InfoCampo campo, String descricao) {
        this.campo = campo;
        this.descricao = descricao;
    }

    public Erro(String descricao) {
        this.descricao = descricao;
    }

    public InfoCampo getCampo() {
        return campo;
    }

    public void setCampo(InfoCampo campo) {
        this.campo = campo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMensagem() {
        if (campo != null) {
            return "Erro: " + campo.getNome() + " " + descricao;
        }
        return "Erro: " + descricao;
    }

}
