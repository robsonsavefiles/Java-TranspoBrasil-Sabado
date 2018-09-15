/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

import java.util.Scanner;

public class AppProduto {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        CadastroProduto produto = new CadastroProduto();// referencia para chamar o menu
        produto.setTeclado(teclado);
        produto.menu();

        teclado.close();

    }

}
