/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exer26_cadastroProdutos;

import cadastroclientes.ProdutoApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class CadastrarVeiculo {

    Scanner teclado = new Scanner(System.in);

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public void menu() {
        String opcao = "";
        do {

            System.out.println("=====Escolha a opção desejada=====");
            System.out.println("1 - Inserir novo veiculo");
            System.out.println("2 - Editar um veículo");
            System.out.println("3 - Listar todos");
            System.out.println("4 - Remover veículo");
            System.out.println("5 - Buscar pela placa do veículo");
            System.out.println("6 - Bucasr pela marca do veículo");
            System.out.println("7 - Bucasr pelo modelo do veículo");
            System.out.println("8 - Buscar pelo ano de fabricação do veículo");
            System.out.println("9 - Bucasr pelo ano do modelo do veículo");
            System.out.println("10 - Sair da aplicação");
            opcao = teclado.nextLine();
            tratarOpcoes(opcao);
        } while (!opcao.equalsIgnoreCase("10"));

    }

    public void tratarOpcoes(String opcao) {

        switch (opcao) {
            case "1":
                inserir();
                break;
            case "2":
                editar();
                break;
            case "3":
                menu2();
                break;
            case "4":
                remover();
                break;
            case "5":
                buscarPorPlaca();
                break;
            case "6":
                buscarPorMarca();
                break;
            case "7":
                bucarPorModelo();
                break;
            case "8":
                buscarPorAnoFabricacao();
                break;
            case "9":
                buscarPorAnoModelo();
                break;

        }
    }

    public void menu2() {
        String op = "";

        do {
            System.out.println("===== Deseja listar por =====");
            System.out.println("1 - id");
            System.out.println("2 - Placa");
            System.out.println("3 - Modelo");
            System.out.println("4 - Marca");
            System.out.println("5 - Cor");
            System.out.println("6 - Ano de fabricação");
            System.out.println("7 - Ano do modelo");
            System.out.println("8 - Sair");
            op = teclado.nextLine();
            tratarListar(op);

        } while (!op.equalsIgnoreCase("8"));
    }

    private void inserir() {

        System.out.println("=============CADASTRANDO NOVO VEÍCULO==============");

        System.out.println("Digite a placa do veículo");
        String placa = teclado.nextLine();
        System.out.println("Digite o modelo do veículo");
        String modelo = teclado.nextLine();
        System.out.println("Digite a marca do veículo");
        String marca = teclado.nextLine();
        System.out.println("Digite a cor do veículo");
        String cor = teclado.nextLine();
        System.out.println("Digite ano de fabricação do veículo");
        int anoModelo = Integer.parseInt(teclado.nextLine());
        System.out.println("Digite o o ano do modelo veículo");
        int anoFabricacao = Integer.parseInt(teclado.nextLine());
        novo(placa, modelo, marca, cor, anoModelo, anoFabricacao);

    }

    private void novo(String placa, String modelo, String marca, String cor, int anoModelo, int anoFabricacao) {
        RepositorioVeiculos repositorio = new RepositorioVeiculos();
        ValidadorVeiculo vl = new ValidadorVeiculo();
        Veiculo novoVeiculo = new Veiculo(placa, modelo, marca, cor, anoFabricacao, anoModelo);

        repositorio.salvar(novoVeiculo);
        File file = new File("Veiculos.txt");

    }

    private void editar() {

        Date agora = new Date();
        File file = new File("Veiculo.txt");
        System.out.println("Editando um veiculo");
        System.out.println("Digite o id do veiculo para ser editado");
        Long id = Long.parseLong(teclado.nextLine());
        RepositorioVeiculos repositorio = new RepositorioVeiculos();
        Veiculo veiculo = repositorio.buscarPorId(id);
        if (veiculo != null) {

            System.out.printf("Informe a nova placa ou enter para permanecer %s :", veiculo.getPlaca());
            String placa = teclado.nextLine();

            System.out.printf("Informe o modelo ou enter para permanecer %s :", veiculo.getModelo());
            String modelo = teclado.nextLine();

            System.out.printf("Informe a nova marca ou enter para permanecer %s :", veiculo.getMarca());
            String marca = teclado.nextLine();

            System.out.printf("Informe a nova cor ou enter para permanecer %s :", veiculo.getCor());
            String cor = teclado.nextLine();

            System.out.printf("Informe o ano de fabricação %s :", veiculo.getAnoFabricacao());
            String anoFabricacao1 = (teclado.nextLine());

            System.out.printf("Informe o ano do modelo %s :", veiculo.getAnoModelo());
            String anoModelo1 = (teclado.nextLine());

            if (!"".equalsIgnoreCase(anoFabricacao1)) {
                veiculo.setAnoFabricacao(Integer.parseInt(anoFabricacao1));
            }

            if (!"".equalsIgnoreCase(anoModelo1)) {
                veiculo.setAnoModelo(Integer.parseInt(anoModelo1));
            }

            veiculo.setPlaca(!"".equalsIgnoreCase(placa) ? placa : veiculo.getPlaca());
            veiculo.setCor(!"".equalsIgnoreCase(cor) ? cor : veiculo.getCor());
            veiculo.setMarca(!"".equalsIgnoreCase(marca) ? marca : veiculo.getMarca());
            veiculo.setModelo(!"".equalsIgnoreCase(modelo) ? modelo : veiculo.getModelo());
         
            placa = veiculo.getPlaca();
            marca = veiculo.getMarca();
            modelo = veiculo.getModelo();
            cor = veiculo.getCor();

            veiculo.setDataAltercao(agora);
            ProdutoApp.gravarUtilizandoFilerPrintWriter(file, veiculo);
            repositorio.salvar(veiculo);
        }

    }

    private void buscarporId() {
        String op = "";
        tratarListar(op);     
    }

    private void remover() {
        System.out.println("Removendo o veiculo");
        System.out.println("Digiete o id do veiculo a ser removido");
        Long id = Long.parseLong(teclado.nextLine());
        RepositorioVeiculos repositorio = new RepositorioVeiculos();
        Veiculo veiculo = repositorio.buscarPorId(id);
        if (veiculo != null) {
            repositorio.remover(veiculo);
        }
        System.out.println("Id não encontrado");
    }

    private void buscarPorPlaca() {
        System.out.println("============================Lista os veiculos por placas=============================");

        System.out.println("Digite a placa do veiculo");
        String placa = (teclado.nextLine());
        RepositorioVeiculos repositorio = new RepositorioVeiculos();

        Veiculo veiculo = repositorio.buscarPorplacas(placa);

        if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
            System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s|%-30s|%-30s\r\n", "ID", "PLACA", "MODELO", "MARCA", "COR", "ANOMODELO", "ANOFABRICAÇÃO");

            System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s|%-30s|%-30s\r\n",
                    veiculo.getId(),
                    veiculo.getPlaca(),
                    veiculo.getModelo(),
                    veiculo.getMarca(),
                    veiculo.getCor(),
                    veiculo.getAnoModelo(),
                    veiculo.getAnoFabricacao());
        } else {
            System.out.println("Veiculo não cadastrado");
        }

    }

    private void bucarPorModelo() {

        System.out.println("Lista de todos os produtos");
        RepositorioVeiculos repositorio = new RepositorioVeiculos();
        ArrayList<Veiculo> listaModelo = repositorio.buscarTodos();
        if (listaModelo.isEmpty()) {
            System.out.println("Não existe contatos cadastrados");
        } else {
            System.out.printf("%-19s|%-60s|%-40s|%-40s| %-11s\r\n", "ID", "MODELO", "MARCA", "COR", "ANOMODELO", "ANOFABRICAÇÃO");
            for (Veiculo veiculo : listaModelo) {
                System.out.printf("%-19s|%150s?%-150s|%-11s\r\n", veiculo.getId(),
                        veiculo.getId(),
                        veiculo.getModelo(),
                        veiculo.getMarca(),
                        veiculo.getCor(),
                        veiculo.getAnoModelo(),
                        veiculo.getAnoFabricacao());
            }
        }
    }

    private void buscarPorMarca() {
        System.out.println("=============LISTA DE MARCA =============");
        System.out.println("Digite a marca desejada");
        String marca = teclado.nextLine();
        RepositorioVeiculos repositorio = new RepositorioVeiculos();
        ArrayList<Veiculo> listaMarca = repositorio.buscarTodos();
        if (listaMarca.isEmpty()) {
            System.out.println("Não existe contatos cadastrados");
        } else {
            System.out.printf("%-19s|%-60s|%-40s|%-40s| %-11s\r\n", "ID", "MODELO", "MARCA", "COR", "ANOMODELO", "ANOFABRICAÇÃO");
            for (Veiculo veiculo : listaMarca) {
                System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s\r\n",
                        veiculo.getId(),
                        veiculo.getModelo(),
                        veiculo.getMarca(),
                        veiculo.getCor(),
                        veiculo.getAnoModelo(),
                        veiculo.getAnoFabricacao());
            }
        }
    }

    private void buscarPorAnoModelo() {
        System.out.println("============================Lista de todos os veiculos=============================");
        System.out.println("Digite a marca desejada");
        int anoModelo = Integer.parseInt(teclado.nextLine());
        RepositorioVeiculos repositorio = new RepositorioVeiculos();
        ArrayList<Veiculo> listaAnomodelo = repositorio.listarAnoModelo(anoModelo);
        if (listaAnomodelo.isEmpty()) {
            System.out.println("Não existe veiculos cadastrados");
        } else {
            System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s|%-30s\r\n", "ID", "PLACA", "MODELO", "MARCA", "COR", "ANOMODELO", "ANOFABRICAÇÃO");
            for (Veiculo veiculo : listaAnomodelo) {
                System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s|%-30s|%-30s\r\n",
                        veiculo.getId(),
                        veiculo.getPlaca(),
                        veiculo.getModelo(),
                        veiculo.getMarca(),
                        veiculo.getCor(),
                        veiculo.getAnoModelo(),
                        veiculo.getAnoFabricacao());
            }
        }
    }

    private void buscarPorAnoFabricacao() {
        System.out.println("============================Lista de todos os veiculos=============================");
        System.out.println("Digite a marca desejada");
        int anoFabricacao = Integer.parseInt(teclado.nextLine());
        RepositorioVeiculos repositorio = new RepositorioVeiculos();
        ArrayList<Veiculo> listaAnoFabricacao = repositorio.listarAnoFab(anoFabricacao);
        if (listaAnoFabricacao.isEmpty()) {
            System.out.println("Não existe veiculos cadastrados");
        } else {
            System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s|%-30s\r\n", "ID", "PLACA", "MODELO", "MARCA", "COR", "ANOMODELO", "ANOFABRICAÇÃO");
            for (Veiculo veiculo : listaAnoFabricacao) {
                System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s|%-30s|%-30s\r\n",
                        veiculo.getId(),
                        veiculo.getPlaca(),
                        veiculo.getModelo(),
                        veiculo.getMarca(),
                        veiculo.getCor(),
                        veiculo.getAnoModelo(),
                        veiculo.getAnoFabricacao());
            }
        }
    }

    private void tratarListar(String op) {

        switch (op) {
            case "1":
                compararPorId();
                break;
            case "2":
                compararPorPlaca();
                break;
            case "3":
                compararPorModelo();
                break;
            case "4":
                compararPorMarca();
                break;
            case "5":
                compararPorCor();
                break;
            case "6":
                compararPorAnoFabricacao();
                break;
            case "7":
                compararPorAnoModelo();
                break;

        }
    }

    private void compararPorId() {
        RepositorioVeiculos repositorio = new RepositorioVeiculos();
        ArrayList<Veiculo> lista = repositorio.buscarTodos();
        Comparator<Veiculo> comparatorPorId = new Comparator<Veiculo>() {

            @Override
            public int compare(Veiculo o1, Veiculo o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };

        Collections.sort(lista, comparatorPorId);

        if (lista.isEmpty()) {
            System.out.println("Não existe contatos cadastrados");
        } else {
            System.out.printf("%-19s|%-60s|%-40s|%-40s| %-11s\r\n", "ID", "MODELO", "MARCA", "COR", "ANOMODELO", "ANOFABRICAÇÃO");
            for (Veiculo veiculo : lista) {
                System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s\r\n",
                        veiculo.getId(),
                        veiculo.getModelo(),
                        veiculo.getMarca(),
                        veiculo.getCor(),
                        veiculo.getAnoModelo(),
                        veiculo.getAnoFabricacao());
            }
        }

    }

    private void compararPorAnoModelo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void compararPorAnoFabricacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void compararPorCor() {
        RepositorioVeiculos repositorio = new RepositorioVeiculos();
        ArrayList<Veiculo> lista = repositorio.buscarTodos();
        Comparator<Veiculo> comparatorPorCor = new Comparator<Veiculo>() {

            @Override
            public int compare(Veiculo o1, Veiculo o2) {
                return o1.getCor().compareTo(o2.getCor());
            }
        };

        Collections.sort(lista, comparatorPorCor);

        if (lista.isEmpty()) {
            System.out.println("Não existe contatos cadastrados");
        } else {
            System.out.printf("%-19s|%-60s|%-40s|%-40s| %-11s\r\n", "ID", "MODELO", "MARCA", "COR", "ANOMODELO", "ANOFABRICAÇÃO");
            for (Veiculo veiculo : lista) {
                System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s\r\n",
                        veiculo.getId(),
                        veiculo.getModelo(),
                        veiculo.getMarca(),
                        veiculo.getCor(),
                        veiculo.getAnoModelo(),
                        veiculo.getAnoFabricacao());
            }
        }
    }

    private void compararPorMarca() {
        RepositorioVeiculos repositorio = new RepositorioVeiculos();
        ArrayList<Veiculo> lista = repositorio.buscarTodos();
        Comparator<Veiculo> comparatorPorMarca = new Comparator<Veiculo>() {

            @Override
            public int compare(Veiculo o1, Veiculo o2) {
                return o1.getMarca().compareTo(o2.getMarca());
            }
        };

        Collections.sort(lista, comparatorPorMarca);

        if (lista.isEmpty()) {
            System.out.println("Não existe contatos cadastrados");
        } else {
            System.out.printf("%-19s|%-60s|%-40s|%-40s| %-11s\r\n", "ID", "MODELO", "MARCA", "COR", "ANOMODELO", "ANOFABRICAÇÃO");
            for (Veiculo veiculo : lista) {
                System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s\r\n",
                        veiculo.getId(),
                        veiculo.getModelo(),
                        veiculo.getMarca(),
                        veiculo.getCor(),
                        veiculo.getAnoModelo(),
                        veiculo.getAnoFabricacao());
            }
        }
    }

    private void compararPorModelo() {
        RepositorioVeiculos repositorio = new RepositorioVeiculos();
        ArrayList<Veiculo> lista = repositorio.buscarTodos();
        Comparator<Veiculo> comparatorPorModelo = new Comparator<Veiculo>() {

            @Override
            public int compare(Veiculo o1, Veiculo o2) {
                return o1.getModelo().compareTo(o2.getModelo());
            }
        };

        Collections.sort(lista, comparatorPorModelo);

        if (lista.isEmpty()) {
            System.out.println("Não existe contatos cadastrados");
        } else {
            System.out.printf("%-19s|%-60s|%-40s|%-40s| %-11s\r\n", "ID", "MODELO", "MARCA", "COR", "ANOMODELO", "ANOFABRICAÇÃO");
            for (Veiculo veiculo : lista) {
                System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s\r\n",
                        veiculo.getId(),
                        veiculo.getModelo(),
                        veiculo.getMarca(),
                        veiculo.getCor(),
                        veiculo.getAnoModelo(),
                        veiculo.getAnoFabricacao());
            }
        }
    }

    private void compararPorPlaca() {
        RepositorioVeiculos repositorio = new RepositorioVeiculos();
        ArrayList<Veiculo> lista = repositorio.buscarTodos();
        Comparator<Veiculo> comparatorPorPlaca = new Comparator<Veiculo>() {

            @Override
            public int compare(Veiculo o1, Veiculo o2) {
                return o1.getPlaca().compareTo(o2.getPlaca());
            }
        };

        Collections.sort(lista, comparatorPorPlaca);

        if (lista.isEmpty()) {
            System.out.println("Não existe contatos cadastrados");
        } else {
            System.out.printf("%-19s|%-60s|%-40s|%-40s| %-11s\r\n", "ID", "MODELO", "MARCA", "COR", "ANOMODELO", "ANOFABRICAÇÃO");
            for (Veiculo veiculo : lista) {
                System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s\r\n",
                        veiculo.getId(),
                        veiculo.getModelo(),
                        veiculo.getMarca(),
                        veiculo.getCor(),
                        veiculo.getAnoModelo(),
                        veiculo.getAnoFabricacao());
            }
        }
    }

}
