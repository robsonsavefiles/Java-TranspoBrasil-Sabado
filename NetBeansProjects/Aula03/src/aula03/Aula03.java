/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03;

/**
 *
 * @author 89087
 */
public class Aula03 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean verdadeiro = true;
        boolean falso = false;
        
        System.out.println("TABELA VERDADE");
        System.out.println("------------------ E (&)-----------------");
        System.out.println("Verdadeiro E Verdadeiro ="+ (verdadeiro & verdadeiro));
        System.out.println("Verdadeiro e falso"+(verdadeiro & falso));
        System.out.println("Verdadeiro e falso"+(verdadeiro & falso));
        System.out.println("Falso e verdadeiro"+(falso & verdadeiro));
        System.out.println("Falso e Falso"+(falso & falso));
        
        
        System.out.println("TABELA VERDADE");
        System.out.println("------------------ OU (|)-----------------");
        System.out.println("Verdadeiro | Verdadeiro ="+ (verdadeiro | verdadeiro));
        System.out.println("Verdadeiro | falso"+(verdadeiro | falso));
        System.out.println("Falso | verdadeiro"+(falso | verdadeiro));
        System.out.println("Falso | Falso"+(falso | falso));
        
        System.out.println("TABELA VERDADE");
        System.out.println("------------------ NÃO (!)-----------------");
        System.out.println("! Verdadeiro ="+ (!verdadeiro));
        System.out.println("! falso"+(!falso));
        
        System.out.println("TABELA VERDADE");
        System.out.println("------------------ OU Exclusivo (^)-----------------");
        System.out.println("Verdadeiro ^ Verdadeiro ="+ (verdadeiro ^ verdadeiro));
        System.out.println("Verdadeiro ^ falso"+(verdadeiro ^ falso));
        System.out.println("Falso ^ verdadeiro"+(falso ^ verdadeiro));
        System.out.println("Falso ^ Falso"+(falso ^ falso));
        
        System.out.println("Tabela Verdade");
         System.out.println("----------------------------------------");
        System.out.println("Verdadeiro && Verdadeiro ="+ (verdadeiro() && verdadeiro()));
         System.out.println("----------------------------------------");
        
        
       
        }
        static boolean falso(){
            System.out.println("falso");
            return false;
            
        }

       static boolean verdadeiro() {
        System.out.println("VERDADEIRO");
        return true;
    }
        
        
        
        
    }


