/*
 * 
 */
package Excecoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Exemplos {

     public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        try{
        System.out.println("Digite um número inteiro");
        int numero = Integer.parseInt(teclado.nextLine());
        
        System.out.printf("O número digitado foi %d \r\n",numero);
        }catch(NumberFormatException ex){
            System.out.println("Não foi possível converter o número");
            System.out.println("Tchau!!!!!");
            System.exit(0);
        }
        //teste(teclado);
        try{
        meuCodigo1(teclado);
        }catch(MinhaExcecaoChecada e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Esta mensagem sempre vai aparecer");
        }
        
        System.out.println(teste2());
    }
    
    private static void meuCodigo1(Scanner teclado) throws MinhaExcecaoChecada{
        System.out.println("Digite sua idade");
        int idade = Integer.parseInt(teclado.nextLine());
        if(idade < 16){
            throw new MinhaExcecaoChecada("Menores de 16 anos não podem trabalhar");
        }
    }
    
    private static int teste2(){
       try{
          
           return 10;
       }finally{
           System.out.println("Execudando finaly");
        }
    }
    
    private static void  teste(Scanner teclado) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            System.out.println("Digite uma data no formato dd/mm/aaaa");
            Date date = sdf.parse(teclado.nextLine());
            System.out.println(date);
        } catch(ParseException ex){
            System.out.println("Não foi possivel fazer o parser");
            System.out.println("Digite data certa!!!!!");
            Date date;
            try {
                date = sdf.parse(teclado.nextLine());
                System.out.println(date);
            } catch (ParseException ex1) {
                Logger.getLogger(Exemplos.class.getName()).log(Level.SEVERE, null, ex1);
                throw new RuntimeException(ex1);
            }
            
        }catch(Exception ex){
            System.out.println(ex);
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ocorreu algum erro mais genérico");
        }
    }
    
}
