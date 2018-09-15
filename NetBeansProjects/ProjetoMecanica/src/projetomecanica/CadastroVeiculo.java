/*
 CadastroVeiculo
 +listar();
 +adicionar();
 +editar();
 +remover();
 +buscarPorPlaca();
 +listarPorMarca();
 +listarModelo();
 +listarPorAnoFabricacao();
 +listarPorAnoModelo();
 */
package projetomecanica;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class CadastroVeiculo {

    Scanner teclado = new Scanner(System.in);
    private CadastroVeiculoControle controle = new CadastroVeiculoControle();

    void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public void menu() {
        String opcao = "";
        do {
            System.out.println("\t\t\t####MECANICA JOAO####\n");
            System.out.println("1-Adicionar Veiculo");
            System.out.println("2-Editar Veiculo:");
            System.out.println("3-Remover Veiculo:");
            System.out.println("4-Listar Tudo");
            System.out.println("5-Listar por Placa:");
            System.out.println("6-Listar por Marca:");
            System.out.println("7-Listar por Modelo :");
            System.out.println("8-Listar por Ano Fabricaçao:");
            System.out.println("9-Listar por Ano Modelo:");
            System.out.println("10-Sair");

            opcao = teclado.nextLine();

            tratarOpcoes(opcao);//alt shif + m
        } while (!"s".equalsIgnoreCase("10"));

    }

    private void tratarOpcoes(String opcao) {
        switch (opcao) {
            case "1":
                novo();
                break;
            case "2":
                editar();
                break;
            case "3":
                remover();
                break;
            case "4":
                listar();
                break;
            case "5":
                listPorPlaca();
                break;
            case "6":
                listMarca();
                break;
            case "7":
                listModelo();
                break;
            case "8":
                listFabporAno();
                break;
            case "9":
                listModporAno();
                break;

        }
    }

    private void novo() {
        System.out.println("=== NOVO ===");
        controle.novo();
        String placa = solicitarParametro("Informe a Placa");
        String marca = solicitarParametro("Informe a Marca");
        String modelo = solicitarParametro("Informe o Modelo");
        String cor = solicitarParametro("Informe a Cor");
        int  anoFabricacao =solicitarParametro("Informe o ano de Fabricacao",
                                               1900,
                                               getAnoAtual());
        int  anoModelo = solicitarParametro("Informe o ano do Modelo",
                                               anoFabricacao,
                                               getAnoAtual()+1);
        
        controle.configurarVeiculo(placa,
                                   marca,
                                   modelo,
                                   cor,
                                   anoFabricacao,
                                   anoModelo);
        controle.salvar();
    }
    private int solicitarParametro(String mensagem, int inicio,int fim) {
        boolean tentarNovamente = false;
        int retorno = 0;
        do {
            System.out.println(mensagem);
            try{
                retorno = Integer.parseInt(teclado.nextLine());
                tentarNovamente = false;
            }catch(NumberFormatException ex){
                tentarNovamente = true;
            }
        } while (tentarNovamente || retorno < inicio || retorno > fim);
        return retorno;
    }
    private String solicitarParametro(String mensagem) {
        String retorno = "";
        do {
            System.out.println(mensagem);
            retorno = teclado.nextLine();
        } while ("".equals(retorno.trim()));
        
        return retorno;
    }
    
     private int getAnoAtual(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    } 


    private void novo(String placa, String cor, String marca, String modelo, int anoFabricacao, int anoModelo) {
        RepositorioMecanica repositorio = new RepositorioMecanica();
        Veiculo novoVeiculo = new Veiculo();
        novoVeiculo.setPlaca(placa);
        novoVeiculo.setCor(cor);
        novoVeiculo.setMarca(marca);
        novoVeiculo.setModelo(modelo);
        novoVeiculo.setAnoFabricacao(anoFabricacao);
        novoVeiculo.setAnoModelo(anoModelo);

        repositorio.salvar(novoVeiculo);

    }

    private void listar() {
        System.out.println("LISTAR VEICULOS");
        RepositorioMecanica repositorio = new RepositorioMecanica();
        ArrayList<Veiculo> lista = repositorio.buscarTodos();
        if (lista.isEmpty()) {
            System.out.println("nao existem Veiculos");
        } else {
            System.out.printf("%-19s|%-20s|%-20s|%-20s|%-20s|%-20s|%-50s\r\n", "ID", "PLACA", "COR", "MARCA", "MODELO", "ANO DE FABRICAÇÃO", "ANO MODELO");

            for (Veiculo veiculo : lista) {
                System.out.printf("%-19s|%-20s|%-20s|%-20s|%-20s|%-20s|%-50s\r\n\n", veiculo.getId(), veiculo.getPlaca(), veiculo.getCor(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(), veiculo.getAnoModelo());

            }
        }

    }

    private void editar() {
        Date atual = new Date();

        System.out.println("EDITAR VEICULO ");
        System.out.println("Informe o id do Veiculo:");
        Long id = Long.parseLong(teclado.nextLine());
        RepositorioMecanica repositorio = new RepositorioMecanica();
        Veiculo veiculo = repositorio.BuscarPorId(id);
        if (veiculo != null) {
            System.out.printf("Informe A Placa ou Enter para permanecer %s", veiculo.getMarca());
            String placa = teclado.nextLine();
            System.out.printf("Informe A Cor ou Enter para permanecer %s", veiculo.getCor());
            String cor = teclado.nextLine();
            System.out.printf("Informe A Marca ou Enter para permanecer %s", veiculo.getMarca());
            String marca = teclado.nextLine();
            System.out.printf("Informe o Modelo ou Enter para permanecer %s", veiculo.getModelo());
            String modelo = teclado.nextLine();
            System.out.printf("Informe o Ano de Fabricao ou Enter para permanecer %s", veiculo.getAnoFabricacao());
            int anoFabricacao = Integer.parseInt(teclado.nextLine());
            System.out.printf("Informe o Ano do Modelo ou Enter para permanecer %s", veiculo.getAnoModelo());
            int anoModelo = Integer.parseInt(teclado.nextLine());

            veiculo.setPlaca(!"".equals(placa) ? placa : veiculo.getPlaca());
            veiculo.setCor(!"".equals(cor) ? cor : veiculo.getCor());
            veiculo.setMarca(!"".equals(marca) ? marca : veiculo.getMarca());
            veiculo.setModelo(!"".equals(modelo) ? modelo : veiculo.getModelo());
            veiculo.setAnoFabricacao(!"".equals(anoFabricacao) ? anoFabricacao : veiculo.getAnoFabricacao());
            veiculo.setAnoModelo(!"".equals(anoModelo) ? anoModelo : veiculo.getAnoModelo());

            veiculo.setDataAlteracao(atual);
            repositorio.salvar(veiculo);

        } else {
            System.out.println("Veiculo nao Encontrado");
        }

    }

    private void remover() {
        System.out.println("REMOVE VEICULO ");
        System.out.println("Informe a Placa do Veiculo:");
        String placa = teclado.nextLine();
        RepositorioMecanica repositorio = new RepositorioMecanica();
        Veiculo veiculo = repositorio.BuscarPorPlaca(placa);
        if (veiculo != null) {
            repositorio.remover(veiculo);
        } else {
            System.out.println("Veiculo nao Encontrado");
        }
    }

    private void listMarca() {
        System.out.println("LISTAR POR MARCA");
        RepositorioMecanica repositorio = new RepositorioMecanica();
        ArrayList<Veiculo> marca = repositorio.BuscarPorMarca(teclado.nextLine());
        if (marca.isEmpty()) {
            System.out.println("nao existem Veiculos");
        } else {
            System.out.printf("%-19s|\r\n", "MARCA");

            for (Veiculo veiculo : marca) {
                System.out.printf("% -19s|%-50s|%-11s\r\n", veiculo.getId(), veiculo.getPlaca(), veiculo.getCor(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(), veiculo.getAnoModelo());

            }
        }

    }

    private void listPorPlaca() {
        System.out.println("LISTAR POR PLACA:");
        System.out.println("Informe a Placa:");
        String placa = (teclado.nextLine());
        RepositorioMecanica repositorio = new RepositorioMecanica();
        Veiculo veiculo = repositorio.BuscarPorPlaca(placa);

        if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
            System.out.printf("%-19s|%-20s|%-20s|%-20s|%-11s|%-11s|%-20s\r\n", "ID", "COR", "PLACA", "MARCA", "MODELO", "ANO DE FABRICAÇÃO", "ANO MODELO");
            System.out.printf("%-19s|%-20s|%-20s|%-20s|%-11s|%-11s|%-20s\r\n", veiculo.getId(), veiculo.getPlaca(), veiculo.getCor(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(), veiculo.getAnoModelo());
        } else {
            System.out.printf("Placa nao encontrada");

        }
    }

    private void listModelo() {
        System.out.println("LISTAR POR MODELO");
        RepositorioMecanica repositorio = new RepositorioMecanica();
        ArrayList<Veiculo> modelo = repositorio.BuscarPorModelo(teclado.nextLine());
        if (modelo.isEmpty()) {
            System.out.println("nao existem Veiculos");
        } else {
            System.out.printf("%-19s|\r\n", "MODELO");

            for (Veiculo veiculo : modelo) {
                System.out.printf("% -19s|%-50s|%-11s\r\n", veiculo.getId(), veiculo.getPlaca(), veiculo.getCor(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(), veiculo.getAnoModelo());

            }
        }
    }

    private void listFabporAno() {
        System.out.println("LISTAR POR ANO DE FABRICAÇÃO");
        RepositorioMecanica repositorio = new RepositorioMecanica();
        ArrayList<Veiculo> anoFabricacao = repositorio.BuscarPorAnoFabricacao(teclado.nextInt());
        if (anoFabricacao.isEmpty()) {
            System.out.println("nao existem Veiculos");
        } else {
            System.out.printf("%-19s|\r\n", "FABRICAÇÃO");

            for (Veiculo veiculo : anoFabricacao) {
                System.out.printf("% -19s|%-50s|%-11s\r\n", veiculo.getId(), veiculo.getPlaca(), veiculo.getCor(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(), veiculo.getAnoModelo());

            }
        }

    }

    private void listModporAno() {
        System.out.println("LISTAR POR ANO DO MODELO");
        RepositorioMecanica repositorio = new RepositorioMecanica();
        ArrayList<Veiculo> anoModelo = repositorio.BuscarPorAnoModelo(teclado.nextInt());
        if (anoModelo.isEmpty()) {
            System.out.println("nao existem Veiculos");
        } else {
            System.out.printf("%-19s|\r\n", "ANO DO MODELO");

            for (Veiculo veiculo : anoModelo) {
                System.out.printf("% -19s|%-50s|%-11s\r\n", veiculo.getId(), veiculo.getPlaca(), veiculo.getCor(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(), veiculo.getAnoModelo());

            }
        }

    }

}
