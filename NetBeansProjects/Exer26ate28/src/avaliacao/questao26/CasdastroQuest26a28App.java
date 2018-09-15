package avaliacao.questao26;

import avaliacao.questao26.menus.MenuMain;
import java.util.Scanner;

/**
 * Realize um cadastro de Produtos. O cadastro deve ter a op��o de adicionar um produto, editar, buscar por c�digo ou por nome, listar todos e remover. As
 * informa��es do produto devem ser: id (inteiro longo), dataCriacao (data), dataAlteracao (data), codigo (texto), nome (texto), descricao (texto) e
 * valorUnitario (real). As informa��es devem ser gravadas em arquivo. As informa��es de c�digo, nome, e valor unit�rio n�o podem ficar vazias, o sistema tamb�m
 * n�o deve aceitar valores negativos
 *
 * Adicione ao programa do exerc�cio anterior o cadastro de Cliente. Cada cliente deve ter as informa��es: id (inteiro longo), dataCriacao (data), dataAlteracao
 * (data), Nome, cpf, Telefone residencial e Telefone celular. As informa��es devem ser gravadas em Arquivo e os campos Nome e cpf n�o podem estar vazios. O
 * campo cpf n�o pode possuir letras, apenas n�meros.
 *
 * Adiciona ao programa do exerc�cio 26 o cadastro de pedidos. Entre outras informa��es cada pedido deve possuir um Cliente, uma lista de Itens.O sistema deve
 * permirir o cadastro de Pedidos, e a busca de pedidos por cliente ou por data. O sistema tamb�m deve ter a op��o de verificar as informa��es de um
 * pedido,apresentando todos dados do pedido. A classe Pedido teve conter as informa��es abaixo: id (inteiro longo), dataCriacao (data), dataAlteracao (data),
 * c�digo, Cliente, itens e total.
 *
 * Cada Item deve possuir as seguintes informa��es: id (inteiro longo), dataCriacao (data), dataAlteracao (data), Produto, quantidade e valor.
 *
 * @author 89087
 */
public class CasdastroQuest26a28App {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            new MenuMain(teclado).mostrarMenu();
        }
    }

}
