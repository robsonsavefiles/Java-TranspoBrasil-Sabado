package br.com.proway.java.factory.clientes;

import br.com.proway.java.factory.FabricaDeRelatorio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 89087
 */
public class Sistema {

    private Properties properties;
    public Sistema(){
        File file = new File("Sistema.properties");
   
        try {
            FileInputStream fInput = new FileInputStream(file);
             properties = new Properties();
             properties.load(fInput);
            } catch (IOException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
           
            }
       
    }
    
    public FabricaDeRelatorio getFabricaDeRelatorio() throws Exception {
        
        String property = properties.getProperty("fabricaRelatorio", "br.com.proway.java.factory.FabricaPadrao");
        Class<? extends FabricaDeRelatorio> classe = (Class<? extends FabricaDeRelatorio>) Class.forName(property);

        return classe.newInstance();//Chama o construtor da classe 

    }
    
    
}
