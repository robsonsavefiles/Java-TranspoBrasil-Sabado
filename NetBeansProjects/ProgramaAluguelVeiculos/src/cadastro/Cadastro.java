package cadastro;

import java.util.Scanner;

/**
 *
 * @author Robinho
 */
public class Cadastro {

    public class CadastroCaminhao {

        VeiculoCaminhao veiculoCaminhao = new VeiculoCaminhao();

        public CadastroCaminhao() {
        }

        public void ExecutaCadastro() {

            System.out.println("Número do Chassi:");
            veiculoCaminhao.DefinirNumeroChassi(Teclado.LerInteiro());

            System.out.println("Número da Placa:");
            veiculoCaminhao.DefinirNumeroPlaca(Teclado.LerString());

            System.out.println("Modelo:");
            veiculoCaminhao.DefinirModelo(Teclado.LerString());

            System.out.println("Fabricante:");
            veiculoCaminhao.DefinirFabricante(Teclado.LerString());

            System.out.println("Ano de Fabricação:");
            veiculoCaminhao.DefinirAnoFabricacao(Teclado.LerInteiro());

            System.out.println("Cor:");
            veiculoCaminhao.DefinirCor(Teclado.LerString());

            System.out.println("Capacidade da Carga (kgs):");
            veiculoCaminhao.DefinirCapacidadeCarga(Teclado.LerFloat());

            System.out.println("Número de Eixos:");
            veiculoCaminhao.DefinirNumeroEixos(Teclado.LerInteiro());

            System.out.println("Cadastro de Onibus: ");
            System.out.println("Número do Chassi: "
                    + veiculoCaminhao.ObterNumeroChassi());
            System.out.println("Número da Placa: "
                    + veiculoCaminhao.ObterNumeroPlaca());
            System.out.println("Modelo: " + veiculoCaminhao.ObterModelo());
            System.out.println("Fabricante: " + veiculoCaminhao.ObterFabricante());
            System.out.println("Ano de Fabricação: "
                    + veiculoCaminhao.ObterAnoFabricacao());
            System.out.println("Cor: " + veiculoCaminhao.ObterCor());
            System.out.println("Capacidade da Carga: "
                    + veiculoCaminhao.ObterCapacidadeCarga() + "kgs");
            System.out.println("Número de Eixos: "
                    + veiculoCaminhao.ObterNumeroEixos());
        }
    }

}
