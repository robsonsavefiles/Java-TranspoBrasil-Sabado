/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class AppUsuario {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        CadastrarUsuario usuario = new CadastrarUsuario();// referencia para chamar o menu
        usuario.setTeclado(teclado);
        usuario.menu();

        teclado.close();

    }

}
