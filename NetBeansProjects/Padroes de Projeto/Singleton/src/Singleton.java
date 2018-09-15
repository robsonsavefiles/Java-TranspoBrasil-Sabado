
public class Singleton {

    private static Singleton instance = null;

    private Singleton() {
        // Existe apenas para previnir as instanciações 
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
