package exemplos.factory.clientes;

import exemplos.factory.relatorios.RelatorioFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class Sistema {

    private Properties properties;

    public Sistema() {
        File file = new File("Sistema.properties");
        try {
            FileInputStream fis = new FileInputStream(file);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public RelatorioFactory getRelatorioFactory() throws Exception {
        String property = properties.getProperty("relatorioFactory", "exemplos.factory.relatorios.RelatorioFactoryPadrao");
        Class<? extends RelatorioFactory> classe = (Class<? extends RelatorioFactory>) Class.forName(property);
        return classe.newInstance();
    }

}
