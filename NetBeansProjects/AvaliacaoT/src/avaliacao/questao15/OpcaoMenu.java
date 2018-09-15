package avaliacao.questao15;

/**
 *
 * @author 78522
 */
public class OpcaoMenu {

    private String id;
    private String descricao;

    public OpcaoMenu(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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

    public String getString() {
        return id + " - " + descricao;
    }

}
