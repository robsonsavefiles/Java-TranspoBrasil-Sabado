/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programamedia;

import java.util.Scanner;

/**
 *
 * @author Robinho
 */
public class ProgramaMedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
           Scanner teclado = new Scanner(System.in);
           System.out.print("Informe a Primeira Nota:");
           float n1 = teclado.nextFloat();
           System.out.print("Informe a Segunda Nota:");
           float n2 = teclado.nextFloat();
           float m =(n1+n2)/2;
           System.out.println("Sua Media foi"+m );
           if(m>9){
               System.out.println("Parabens, pequeno Gafanhoto!");
               
           }
    }
    
}
