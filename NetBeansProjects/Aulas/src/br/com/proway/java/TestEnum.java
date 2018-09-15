/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

/**
 * BASIC(1),MEDIUM(2),HARD(3),ADMIM(4);
 *
 * @author 89087
 */
public class TestEnum {

    public static void main(String[] args) {
        System.out.println(TipoUsuario.BASIC.getCodigo());
        System.out.println(TipoUsuario.MEDIUM.getCodigo());
        System.out.println(TipoUsuario.HARD.getCodigo());
        System.out.println(TipoUsuario.ADMIM.getCodigo());

        System.out.println(TipoUsuario.values()[0]);
        System.out.println(TipoUsuario.values()[1]);
        System.out.println(TipoUsuario.values()[2]);
        System.out.println(TipoUsuario.values()[3]);

    }
}
