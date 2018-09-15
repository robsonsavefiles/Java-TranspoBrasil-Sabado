/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.oficina.view;

import br.com.proway.oficina.controle.CadastroVeiculoControle;
import java.util.Calendar;
import java.util.Scanner;

public class CadastroVeiculo {

    private Scanner teclado;
    private CadastroVeiculoControle controle = new CadastroVeiculoControle();

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public void menu() {

        System.out.println("==== OFICINA DO JOÃO ====");
        String opcao = "";
        do {
            System.out.println("1 - Adicionar Veiculo");
            System.out.println("2 - Listar Veiculo");
            System.out.println("3 - Editar Veiculo");
            System.out.println("4 - Remover Veiculo");
            System.out.println("X - Sair");
            opcao = teclado.nextLine();
            tratarOpcao(opcao);
        } while (!"x".equalsIgnoreCase(opcao));

    }

    private void tratarOpcao(String opcao) {
        switch (opcao) {
            case "1":
                novo();
                break;
            case "2":
                listar();
                break;
            case "3":
                editar();
                break;
            case "4":
                remover();
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

    

    private void listar() {
        System.out.println("=== Lista de Veiculos ===");
        int total = controle.contarVeiculos();
        if(total == 0 ){
            System.out.println("Não exitem veículos cadastrados!");
        }else{
            System.out.printf("%-7s|%-10s|%-10s|%-10s|%-10s|%-10s\r\n","PLACA",
                    "MARCA","MODELO","COR","ANO FABR.", "ANO MOD");
            for(int index = 0;index < total; index++){
                System.out.printf("%-7s|%-10s|%-10s|%-10s|%-10d|%-10d\r\n",
                     controle.getPlaca(index),
                    controle.getMarca(index),
                    controle.getModelo(index),
                    controle.getCor(index),
                    controle.getAnoFabricacao(index),
                    controle.getAnoModelo(index));
        }
             
        }
    }

    private void editar() {
        
    }

    private void remover() {
        
    }

}
