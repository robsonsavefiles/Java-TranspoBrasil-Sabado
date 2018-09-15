//package br.com.proway.java;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class CadastroVeiculo {
//
//    private Scanner teclado;
//    
//    void setTeclado(Scanner teclado) {
//        this.teclado = teclado;
//    }
//    
//    public void menu() {
//        String opcao = "";
//        do {
//            System.out.println("1-Inserir Veiculo");
//            System.out.println("2-Listar Veiculo:");
//            System.out.println("3-Listar por Marca:");
//            System.out.println("4-Listar por Modelo:");
//            System.out.println("5-Listar por Ano de Fabricação:");
//            System.out.println("6-Listar por Ano Modelo :");
//            System.out.println("7-Listar por Ano Fabricaçao Até:");
//            System.out.println("8-Listar por Ano Modelo Até");
//            System.out.println("9-Editar Veiculo:");
//            System.out.println("9-Remover Veiculo:");
//            System.out.println("10-Sair");
//            opcao = teclado.nextLine();
//            
//            tratarOpcoes(opcao);//alt shif + m
//        } while (!"s".equalsIgnoreCase(opcao));
//        
//    }
//    
//    private void tratarOpcoes(String opcao) {
//        switch (opcao) {
//            case "1":
//                novo();
//                break;
//            case "2":
//                listar();
//                break;
//            case "3":
//                listMarca();
//                break;
//            case "4":
//                listModelo();
//                break;
//            case "5":
//                listAnoFab();
//                break;
//            case "6":
//                listAnoMod();
//                break;
//            case "7":
//                listFabAte();
//                break;
//            case "8":
//                listFabModate();
//                break;
//            case "9":
//                remover();
//                break;
//        }
//    }
//    
//    private void novo() {
//        
//        System.out.println("Cadastrar Veiculo Novo");
//        System.out.println("Marca:");
//        String marca = teclado.nextLine();
//        System.out.println("Modelo:");
//        String modelo = teclado.nextLine();
//        System.out.println("Ano de Fabricaçao:");
//        int anoFabricacao =Integer.parseInt(teclado.nextLine());
//        System.out.println("Ano do Modelo:");
//        int anoModelo = Integer.parseInt(teclado.nextLine());
//        
//        novo(marca,modelo,anoFabricacao,anoModelo);
//        
//    }
//
//    private void novo(String marca, String modelo, int anoFabricacao, int anoModelo) {
//        RepositorioVeiculo repositorio = new RepositorioVeiculo();
//        Veiculo novoVeiculo = new Veiculo();
//        novoVeiculo.setMarca(marca);
//        novoVeiculo.setModelo(modelo);
//        novoVeiculo.setAnoFabricacao(anoFabricacao);
//        novoVeiculo.setAnoModelo(anoModelo);
//      
//        repositorio.salvar(novoVeiculo);
//        
//    }
//    
//    private void listar() {
//        System.out.println("LISTAR VEICULOS");
//        RepositorioVeiculo repositorio = new RepositorioVeiculo();
//        ArrayList<Veiculo> lista = repositorio.buscarTodos();
//        if (lista.isEmpty()) {
//            System.out.println("nao existem Veiculos");
//        } else {
//            System.out.printf("%-19s|%-50s|%-50s|%-11s\r\n", "ID", "MARCA", "ANO DE FABRICAÇÃO", "ANO MODELO");
//            
//            for (Veiculo veiculo : lista) {
//                System.out.printf("% -19s|%-50s|%-11s\r\n", veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(),veiculo.getAnoModelo());
//                
//            }
//        }
//    }
//    
//    private void editar() {
//        System.out.println("EDITAR VEICULO ");
//        System.out.println("Informe o id do Veiculo:");
//        Long id = Long.parseLong(teclado.nextLine());
//        RepositorioVeiculo repositorio = new RepositorioVeiculo();
//        Veiculo veiculo = repositorio.BuscarPorId(id);
//        if (veiculo!= null) {
//            System.out.printf("Informe A Marca ou Enter para permanecer %s", veiculo.getMarca());
//            String marca = teclado.nextLine();
//            System.out.printf("Informe o Modelo ou Enter para permanecer %s", veiculo.getModelo());
//            String modelo = teclado.nextLine();
//            System.out.printf("Informe o Ano de Fabricao ou Enter para permanecer %s", veiculo.getAnoFabricacao());
//            int anoFabricacao =Integer.parseInt(teclado.nextLine());
//            System.out.printf("Informe o Ano do Modelo ou Enter para permanecer %s", veiculo.getAnoModelo());
//            int anoModelo = Integer.parseInt(teclado.nextLine());
//             
//            
//            veiculo.setMarca(!"".equals(marca) ? marca : veiculo.getMarca());
//            veiculo.setModelo(!"".equals(modelo) ? modelo : veiculo.getModelo());
//            veiculo.setAnoFabricacao(!"".equals(anoFabricacao) ? anoFabricacao : veiculo.getAnoFabricacao());
//            veiculo.setAnoModelo(!"".equals(anoModelo)? anoModelo : veiculo.getAnoModelo());
//            
//            repositorio.salvar(veiculo);
//            
//        } else {
//            System.out.println("Veiculo nao Encontrado");
//        }
//    }
//
//    private void remover() {
//        System.out.println("REMOVE VEICULO ");
//        System.out.println("Informe o id do Veiculo:");
//        Long id = Long.parseLong(teclado.nextLine());
//        RepositorioVeiculo repositorio = new RepositorioVeiculo();
//        Veiculo veiculo = repositorio.BuscarPorId(id);
//        if (veiculo != null) {
//            repositorio.remover(veiculo);
//        } else {
//            System.out.println("Contato nao Encontrado");
//        }
//    }
//    //private void novo(String marca, String modelo, int anoFabricacao, int anoModelo) {
//        
//    //}
//    private void listMarca() {
//        System.out.println("LISTAR POR MARCA");
//        RepositorioVeiculo repositorio = new RepositorioVeiculo();
//        ArrayList<Veiculo> marca = repositorio.buscarPorMarca();
//        if (marca.isEmpty()) {
//            System.out.println("nao existem Veiculos");
//        } else {
//            System.out.printf("%-19s|\r\n","MARCA");
//            
//            for (Veiculo veiculo : marca) {
//                System.out.printf("% -19s|%-50s|%-11s\r\n", veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(),veiculo.getAnoModelo());
//                
//            }
//        }
//          
//    }
//
//    private void listModelo() {
//        System.out.println("LISTAR POR MODELO");
//        RepositorioVeiculo repositorio = new RepositorioVeiculo();
//        ArrayList<Veiculo> modelo = repositorio.BuscarPorModelo(teclado.nextLine());
//        if (modelo.isEmpty()) {
//            System.out.println("nao existem Veiculos");
//        } else {
//            System.out.printf("%-19s|\r\n","MODELO");
//            
//            for (Veiculo veiculo : modelo) {
//                System.out.printf("% -19s|%-50s|%-11s\r\n", veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(),veiculo.getAnoModelo());
//                
//            }
//        }
//    }
//
//    private void listAnoFab() {
//        System.out.println("LISTAR POR ANO DE FABRICAÇÃO");
//        RepositorioVeiculo repositorio = new RepositorioVeiculo();
//        ArrayList<Veiculo> anoFabricacao = repositorio.BuscarPorAnoFabricacao(teclado.nextLine());
//        if (anoFabricacao.isEmpty()) {
//            System.out.println("nao existem Veiculos");
//        } else {
//            System.out.printf("%-19s|\r\n","FABRICAÇÃO");
//            
//            for (Veiculo veiculo : anoFabricacao) {
//                System.out.printf("% -19s|%-50s|%-11s\r\n", veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(),veiculo.getAnoModelo());
//                
//            }
//        }
//        
//    }
//    private void listAnoMod() {
//        System.out.println("LISTAR POR ANO DO MODELO");
//        RepositorioVeiculo repositorio = new RepositorioVeiculo();
//        ArrayList<Veiculo> anoModelo = repositorio.BuscarPorAnoModelo();
//        if (anoModelo.isEmpty()) {
//            System.out.println("nao existem Veiculos");
//        } else {
//            System.out.printf("%-19s|\r\n","ANO DO MODELO");
//            
//            for (Veiculo veiculo : anoModelo) {
//                System.out.printf("% -19s|%-50s|%-11s\r\n", veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(),veiculo.getAnoModelo());
//                
//            }
//        }
//        
//    }
//
//    private void listFabAte() {
//        System.out.println("LISTAR POR ANO DE FABRICACAO ATE");
//        RepositorioVeiculo repositorio = new RepositorioVeiculo();
//        ArrayList<Veiculo> anoFabricacaoAte = repositorio.BuscarPorAnoFabricacaoAte();
//        if (anoFabricacaoAte.isEmpty()) {
//            System.out.println("nao existem Veiculos");
//        } else {
//            System.out.printf("%-19s|\r\n","ANO DO MODELO");
//            
//            for (Veiculo veiculo : anoFabricacaoAte) {
//                System.out.printf("% -19s|%-50s|%-11s\r\n", veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(),veiculo.getAnoModelo());
//                
//            }
//        }
//       
//    }
//    private void listFabModate() {
//    System.out.println("LISTAR POR ANO DO MODELO ATE");
//        RepositorioVeiculo repositorio = new RepositorioVeiculo();
//        ArrayList<Veiculo> anoModeloAte = repositorio.BuscarPorAnoModeloAte();
//        if (anoModeloAte.isEmpty()) {
//            System.out.println("nao existem Veiculos");
//        } else {
//            System.out.printf("%-19s|\r\n","ANO DO MODELO");
//            
//            for (Veiculo veiculo : anoModeloAte) {
//                System.out.printf("% -19s|%-50s|%-11s\r\n", veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao(),veiculo.getAnoModelo());
//                
//            }
//        }
//    
//    
//    }
//    
//}
//
