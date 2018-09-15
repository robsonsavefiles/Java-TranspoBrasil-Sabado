package avaliacao.questao26;

import avaliacao.questao26.menu.MenuMain;
import java.util.Scanner;

/**
 * Realize um cadastro de Produtos. O cadastro deve ter a opção de adicionar um produto, editar, buscar por código ou por nome, listar todos e remover. As
 * informações do produto devem ser: id (inteiro longo), dataCriacao (data), dataAlteracao (data), codigo (texto), nome (texto), descricao (texto) e
 * valorUnitario (real). As informações devem ser gravadas em arquivo. As informações de código, nome, e valor unitário não podem ficar vazias, o sistema também
 * não deve aceitar valores negativos
 *
 * Adicione ao programa do exercício anterior o cadastro de Cliente. Cada cliente deve ter as informações: id (inteiro longo), dataCriacao (data), dataAlteracao
 * (data), Nome, cpf, Telefone residencial e Telefone celular. As informações devem ser gravadas em Arquivo e os campos Nome e cpf não podem estar vazios. O
 * campo cpf não pode possuir letras, apenas números.
 *
 * Adiciona ao programa do exercício 26 o cadastro de pedidos. Entre outras informações cada pedido deve possuir um Cliente, uma lista de Itens.O sistema deve
 * permirir o cadastro de Pedidos, e a busca de pedidos por cliente ou por data. O sistema também deve ter a opção de verificar as informações de um
 * pedido,apresentando todos dados do pedido. A classe Pedido teve conter as informações abaixo: id (inteiro longo), dataCriacao (data), dataAlteracao (data),
 * código, Cliente, itens e total.
 *
 * Cada Item deve possuir as seguintes informações: id (inteiro longo), dataCriacao (data), dataAlteracao (data), Produto, quantidade e valor.
 *
 * @author 78522
 */
public class Questao26 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            new MenuMain(teclado).mostrarMenu();
        }
    }

}
