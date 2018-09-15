package exercicios.enums.usuario;

/**
 *
 * @author 78522
 */
public enum TipoUsuario {

    BASIC(1),
    MEDIUM(2),
    HARD(3),
    ADMIN(4) {
                @Override
                public int getCodigo() {
                    return 1000;
                }
            };

    private final int codigo;

    private TipoUsuario(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoUsuario of(int codigo) {
        TipoUsuario[] tipos = values();
        for (TipoUsuario tipo : tipos) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return ordinal() + " - " + name();
    }
}
