/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programapernas;

import java.util.Scanner;

/**
 *
 * @author Robinho
 */
public class ProgramaPernas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner tec = new Scanner(System.in);
        System.out.print("Quantas pernas?:");
        int perna = tec.nextInt();
        String tipo;
        System.out.print("Isso é um(A):");
        switch(perna){
            case 1:
                tipo = "Saci";
                break;
            case 2:
                tipo = "Bípede";
                break;
            case 3:
                tipo = "Tripé";
                break;
            case 4:
                tipo = "Quadrúpede";
                break;
            case 6:
                tipo = "Aranha";
                break;
                
            default:
                tipo = "ET";
                break;
               
        }
        System.out.println(tipo);
   
    }
    
}
