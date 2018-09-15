/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

/**
 *
 * @author 89087
 */
public class TestContadorCachorro {

    public static void main(String[] args) {

        System.out.printf("Total de cachorros é %d\r\n", Cachorro.getQuantidadeCachorros());

        Cachorro c = new Cachorro();
        System.out.printf("Total de cachorros é %d\r\n", Cachorro.getQuantidadeCachorros());

    }

}
