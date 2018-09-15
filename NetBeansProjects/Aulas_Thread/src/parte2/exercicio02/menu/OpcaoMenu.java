package parte2.exercicio02.menu;

/**
 *
 * @author 78522
 */
public class OpcaoMenu {

    private static final String DIVISOR = " - ";

    private String id;
    private String descricao;

    public OpcaoMenu(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String opcaoString() {
        return id + DIVISOR + descricao;
    }

}
