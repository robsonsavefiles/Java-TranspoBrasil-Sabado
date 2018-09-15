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
public class UsoWhile {

    public static void main(String[] args) {

        int count = 0;

        //while(count=10)<100){
        while (count < 10) {
            if (count == 5) {
                count = count + 1;
                continue;
            }
            if (count == 7) {
                break;
            }
            System.out.println(count);
            count = count + 1;
        }

    }

}
