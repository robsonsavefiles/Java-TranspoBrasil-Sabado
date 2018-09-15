
package br.com.proway.java.factory.clientes;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author 89087
 */
public class Main {
    
    public static void main(String[] args) {
        Properties  properties = System.getProperties();
        Set<Map.Entry<Object,Object>> entrySet = properties.entrySet();
        for(Map.Entry<Object,Object> entrada : entrySet){
            System.out.printf("%s = %s\r\n",entrada.getKey(),entrada.getValue());
        }
        
    }

}
