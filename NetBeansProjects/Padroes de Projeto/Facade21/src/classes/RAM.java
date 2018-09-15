
package classes;

public class RAM {
    
    public void read(String position) {
        System.out.println("RAM - read: " + position);
    }
    
    public void write(String position, String value) {
        System.out.println("RAM - write: " + position + ", " + value);
    }

}
