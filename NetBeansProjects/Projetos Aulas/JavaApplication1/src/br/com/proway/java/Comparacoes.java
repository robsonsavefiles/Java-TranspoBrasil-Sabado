/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;
  /* Operdadores de comparação
        Menor(<)
        Maior ou igual(<=)


          */
public class Comparacoes {
    
    public static void main(String[] args) {
        
        System.out.println(3>2);
        System.out.println(2>3);
        System.out.println(2<10);
        System.out.println(2!=10);
        System.out.println(2<=10);
        System.out.println(2>=10);
        System.out.println(10 == 10);
        
        
       String nome = "Felipe";
       String nome2 = "Felipe";
       String teste1 = new String("TESTE");
       String teste2 = new String("TESTE");
       
        System.out.println(nome == nome2);
        
        System.out.println(teste1 == teste2);
        
        System.out.println(nome.equals(nome2));
        
        System.out.println(teste1.equals(teste2));
        
        Pessoa p1 = new Pessoa("Felipe");
        Pessoa p2 = new Pessoa("Felipe");
        
        System.out.println(p1 == p2);// comparação Simples
        System.out.println(p1.equals(p2));//Comparacao de objetos
        
        
        
        
        
        
    }
    
}
