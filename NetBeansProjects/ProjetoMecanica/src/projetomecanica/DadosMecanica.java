/*
 *Classe para salvar todos os dados da mecanica
 */
package projetomecanica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DadosMecanica {

    public static void gravarDadosMecanica(Veiculo veiculo, File dados) {

        Entidade entidade = new Entidade();
        try (PrintWriter pWriter = new PrintWriter(new FileWriter(dados, true))) {
            pWriter.println("Data de criação:"+ veiculo.getDataCriacao());
            pWriter.println("Data de alteraçao:"+veiculo.getDataAlteracao());
            pWriter.println("Placa:" + veiculo.getPlaca());
            pWriter.println("Cor:" + veiculo.getCor());
            pWriter.println("Marca:" + veiculo.getMarca());
            pWriter.println("Moddelo:" + veiculo.getModelo());
            pWriter.println("Ano de Fabricação:" + veiculo.getAnoFabricacao());
            pWriter.println("Ano do Modelo" + veiculo.getAnoModelo());
            pWriter.println("=================================================");

            pWriter.flush();
        } catch (IOException ex) {
            System.out.println("FALHA AO GRAVAR O ARQUIVO");
        }

    }

}
