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
public class TestStatic {

    public static void main(String[] args) {
        People p1 = new People();

        System.out.println(p1.contador);
        System.out.println(p1.count);

        People p2 = new People();

        System.out.println(p2.contador);
        System.out.println(p2.count);

        People.contador++;
        p2.count++;
        System.out.println(People.contador);
        System.out.println(p1.count);

    }

}
