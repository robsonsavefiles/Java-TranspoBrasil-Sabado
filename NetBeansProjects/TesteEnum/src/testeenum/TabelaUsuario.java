package testeenum;

/**
 *
 * @author 78522
 */
public enum TabelaUsuario {

    ID("id", DatabaseType.INTEGER),
    NAME("name", DatabaseType.STRING),
    EMAIL("email", DatabaseType.STRING),
    PASSWORD("password", DatabaseType.STRING),
    BIRTHDAY("birthday", DatabaseType.DATE),
    IS_DELETED("is_deleted", DatabaseType.BOOLEAN),
    CREATED("created", DatabaseType.DATETIME),
    LAST_EDITED("last_edited", DatabaseType.DATETIME);

    private static final String tableName = "TabelaUsuario";
    private static final TabelaUsuario defaultSort = ID;

    private String name;
    private DatabaseType type;

    private TabelaUsuario(String name, DatabaseType type) {
        this.name = name;
        this.type = type;
    }

    public static String getTableName() {
        return tableName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DatabaseType getType() {
        return type;
    }

    public void setType(DatabaseType type) {
        this.type = type;
    }

    public static TabelaUsuario getDefaultSort() {
        return defaultSort;
    }
}
