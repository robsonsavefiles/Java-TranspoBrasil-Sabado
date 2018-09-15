package avaliacao.questao26.objeto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class IO {

    public static List lerObjetosNoArquivo(String nomeArquivo) {
        List retorno = new ArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            retorno = (List) ois.readObject();
        } catch (IOException e) {
            // Ocorre quando o arquivo ainda n�o foi criado.
            // System.out.println("Erro ao ler o arquivo " + nomeArquivo + "!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public static void gravarObjetosNoArquivo(String nomeArquivo, List objs) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(objs);
        } catch (IOException ex) {
            System.out.println("Erro ao salvar para o arquivo " + nomeArquivo + "!");
        }
    }
}
