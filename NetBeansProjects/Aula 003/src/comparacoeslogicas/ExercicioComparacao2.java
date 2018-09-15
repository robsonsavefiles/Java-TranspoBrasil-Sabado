/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tiago.comparacao;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ExercicioComparacao2 {

    public static void main(String[] args) {
        int[] nums = new int[4];
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Forneça o número " + (i + 1));
            nums[i] = Integer.parseInt(teclado.nextLine());
        }

        System.out.println("Primeiro igual ao último? " + (nums[0] == nums[3]));
        System.out.println("Segundo igual ao terceiro? " + (nums[1] == nums[2]));
    }
}
