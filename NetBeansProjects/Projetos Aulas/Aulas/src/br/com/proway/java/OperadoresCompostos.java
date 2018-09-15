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
public class OperadoresCompostos {

    public static void main(String[] args) {

//        // Operador de pré incremento
//        int total = 0;
//        System.out.println(total);
//        System.out.println(++total); // total = total+1;
//        
//        // Operador de pos incremento
//      
//        System.out.println(total++);
//        System.out.println(total);
//        
//
//        // decrementar 
//        System.out.println(--total); 
//        System.out.println(total--);
//        System.out.println(total);
//        
        int total = 0;

        //operadores composto
        total += 10;// total = total +10;

        System.out.println(total);

        total -= 5;// total = total -5;
        System.out.println(total);

        total *= 6; // total = total *5;
        System.out.println(total);

        total /= 6;// total = total / 6;
        System.out.println(total);

        total %= 3; // total = total % 3;
        System.out.println(total);

        total = (3 + 2) * 5;

        total *= 2 + 5 * 2 - 1;// total = total *(2+5 * 2- 1);

        System.out.println(total);

    }

}
