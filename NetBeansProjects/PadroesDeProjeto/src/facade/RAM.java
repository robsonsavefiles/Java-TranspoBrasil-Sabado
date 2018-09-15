
package facade;

/**
 *
 * @author 89087
 */
public class RAM {
    
     public void read(String position){
        System.out.println("RAM- read "+ position);
        
    }
    public void write (String positon, String value){
        System.out.println("RAM - Write"+ positon + ","+value);
    }

}
