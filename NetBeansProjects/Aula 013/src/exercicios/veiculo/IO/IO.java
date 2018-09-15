package exercicios.veiculo.IO;

import exercicios.veiculo.model.Entidade;
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

/**
 *
 * @author 78522
 */
public class IO {

//    public static <T extends Entidade> List<T> lerObjetosNoArquivo(String nomeArquivo, Class<T> clazz) {
//        ArrayList retorno = new ArrayList();
//
//        try (FileReader fr = new FileReader(new File(nomeArquivo));
//                BufferedReader br = new BufferedReader(fr);) {
//            String linha = br.readLine();
//            String[] dados = linha.split(Salvavel.TOKEN);
//            while (linha != null) {
//
//                if (clazz == Veiculo.class) {
//                    Veiculo obj = new Veiculo();
//                    obj.fromStringArray(dados);
//                    retorno.add(obj);
//                } else if (clazz == Marca.class) {
//                    Marca obj = new Marca();
//                    obj.fromStringArray(dados);
//                    retorno.add(obj);
//                } else if (clazz == Modelo.class) {
//                    Modelo obj = new Modelo();
//                    obj.fromStringArray(dados);
//                    retorno.add(obj);
//                }
//
//                linha = br.readLine();
//            }
//        } catch (FileNotFoundException e) {
//            // Ocorre quando o arquivo ainda não foi criado.
//        } catch (Exception e) {
//            System.out.println("Erro ao ler o arquivo " + nomeArquivo + "!");
//        }
//
//        return retorno;
//    }
    public static <T extends Entidade> List<T> lerObjetosNoArquivo(String nomeArquivo) {
        List<T> retorno = new ArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            while (true) {
                retorno.add((T) ois.readObject());
            }
        } catch (EOFException e) {
            // Ocorre quando não há mais objetos para serem lidos.
        } catch (IOException e) {
            // Ocorre quando o arquivo ainda não foi criado.
            // System.out.println("Erro ao ler o arquivo " + nomeArquivo + "!");
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
