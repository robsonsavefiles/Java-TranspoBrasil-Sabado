package exercicios.cachorro;

/**
 *
 * @author 78522
 */
public class Cachorro {

    private static int contador = 0;

    public Cachorro() {
        contador++;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Cachorro.contador = contador;
    }
}
