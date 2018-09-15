package sistema;
import java.io.*;

public class Teclado{
    private static BufferedReader teclado = new BufferedReader(
    new InputStreamReader(System.in));

    public static String LerString() {
        String valor = null;
        try {
            valor = teclado.readLine();
        } catch (IOException e) {
        }
        return (valor);
    }

    public static int LerInteiro() {
        String valor = null;
        int numero;
        valor = LerString();
        numero = Integer.parseInt(valor);
        return (numero);
    }

    public static float LerFloat() {
        String valor = null;
        float numero;
        valor = LerString();
        numero = Float.parseFloat(valor);
        return (numero);
    }
}