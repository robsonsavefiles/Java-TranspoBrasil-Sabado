/*
 
 */
package br.com.proway.arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExemplosGravarArquivosTexto {

    public static void main(String[] args) {

        File file = new File("dados.txt");
        System.out.println("Gravando o Arquivo");
        gravarUtilizandoFileWriter(file, "ESTA LINHA  FOI ESCRITA AGORA");
        System.out.println("Fim da gravaçao");

    }

    private static void gravarUtilizandoFileWriter2(File file, String texto) {

        try (PrintWriter pWriter = new PrintWriter(new FileWriter(file, true))) {
            pWriter.println(texto);
            pWriter.flush();
        } catch (IOException ex) {
            System.out.println("FALHA AO GRAVAR O ARQUIVO");
        }

    }

    private static void gravarUtilizandoFileWriter(File file, String texto) {
        boolean apendar = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, apendar);
            writer.write("\r\n");
            writer.write(texto);
            writer.flush();// para evitar um bug, obriga a gravar informaçao no disco 
        } catch (IOException ex) {
            Logger.getLogger(ExemplosGravarArquivosTexto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(ExemplosGravarArquivosTexto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
}
