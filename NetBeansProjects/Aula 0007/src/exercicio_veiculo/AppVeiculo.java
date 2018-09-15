package exercicio_veiculo;

import exercicio_veiculo.cadastro.Cadastro;
import exercicio_veiculo.model.Marca;
import exercicio_veiculo.model.Modelo;
import exercicio_veiculo.model.Veiculo;
import exercicio_veiculo.repositorio.RepositorioMarca;
import exercicio_veiculo.repositorio.RepositorioModelo;
import exercicio_veiculo.repositorio.RepositorioVeiculo;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class AppVeiculo {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Cadastro cadastro = new Cadastro(teclado);
        RepositorioMarca repositorioMarca = new RepositorioMarca();
        RepositorioModelo repositorioModelo = new RepositorioModelo();
        RepositorioVeiculo repositorioVeiculo = new RepositorioVeiculo();

        String[] marcas = new String[]{"Volkswagen", "Ford", "Fiat", "Toyota", "Renaut", "Lamborghini"};
        String[][] modelos = new String[marcas.length][];
        modelos[0] = new String[]{"Gol", "Golf", "Fusca", "New Beetle"};
        modelos[1] = new String[]{"Taurus", "Ka"};
        modelos[2] = new String[]{"Uno", "Palio"};
        modelos[3] = new String[]{"Prius", "Corola"};
        modelos[4] = new String[]{"Logan", "Clio"};
        modelos[5] = new String[]{"Gallardo", "Aventador"};

        Marca marca;
        Modelo modelo;
        Random random = new Random();
        int ano = LocalDate.now().getYear();

        for (int i = 0; i < marcas.length; i++) {
            marca = new Marca(marcas[i]);
            repositorioMarca.salvar(marca);
            for (int j = 0; j < modelos[i].length; j++) {
                for (int k = 0; k < random.nextInt(3 - 1) + 1; k++) {
                    modelo = new Modelo(marca, modelos[i][j], random.nextInt(ano - (ano - 10) + 1) + (ano - 10)); //random.nextInt(LocalDate.now().getYear()) + LocalDate.now().getYear() - 10);
                    repositorioModelo.salvar(modelo);
                    for (int m = 0; m < random.nextInt(3 - 1) + 1; m++) {
                        repositorioVeiculo.salvar(new Veiculo(modelo, random.nextInt(ano - modelo.getAno() + 1) + modelo.getAno()));
                    }
                }
            }
        }

        cadastro.mostrarMenu();
    }
}
