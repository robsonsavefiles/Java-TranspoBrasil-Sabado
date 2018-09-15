package exer26ate28.IO;

import exer26ate28.produto.model.Entidade;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IO {

    public static <T extends Entidade> List<T> lerObjetosNoArquivo(String nomeArquivo) {
        List<T> retorno = new ArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            while (true) {
                retorno.add((T) ois.readObject());
            }
        } catch (EOFException e) {
        } catch (IOException e) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public static <T extends Entidade> void gravarObjetosNoArquivo(String nomeArquivo, List<T> objs) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            for (T obj : objs) {
                oos.writeObject(obj);
            }
        } catch (IOException ex) {
            System.out.println("Erro ao salvar para o arquivo " + nomeArquivo + "!");
        }
    }
}
