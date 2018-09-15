
package factory;

/**
 *
 * @author 89087
 */
public class TelaFactory {
    
    public static Tela01 getTela01(){
        return Tela01.getInstance();
        
    }
    public static Tela02 getTela02(){
        return Tela02.getInstance();
        
    }

}
