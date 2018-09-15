package exercicios.cliente;

/**
 *
 * @author 78522
 */
public interface ClienteTableInfo {

    public static String[] getColunas() {
        return new String[]{"ID", "Nome", "CPF", "Telefone"};
    }

    default String[] getLinha() {
        return new String[]{String.valueOf(getId()), getNome(), getCpf(), getTelefone()};
    }

    public Long getId();

    public String getNome();

    public String getCpf();

    public String getTelefone();

}
