
package projetomecanica;

public class ValidadorUtil {
    
    
    public static boolean isVazio(String valor){
        return  valor == null || "".equals(valor.trim());
    }
    
    public static boolean isDentroDoIntervado(int valor, int inicio, int fim){
        return valor >= inicio && valor <= fim;
    }
    
    public static boolean isNull(Object valor){
            return valor == null;
    }
    
     public static String getValor(String valor){
        return valor != null ? valor : "";
    }
    
}
