
package facade;

/**
 *
 * @author 89087
 */
public class HD {
    
    public void read(String position){
        System.out.println("HD - read "+ position);
        
    }
    public void write (String position, String value){
        System.out.println("HD - Write"+ position + ","+value);
    }
}
