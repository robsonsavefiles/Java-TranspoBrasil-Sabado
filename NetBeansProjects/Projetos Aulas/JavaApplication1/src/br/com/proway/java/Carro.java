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
public class Carro extends VeiculoConstrutor1 {
    
        private int quantidadePortas;

    public int getQuantidadePortas(String marca, int paramPortas) {
    
        quantidadePortas = paramPortas;
            return 0;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public Carro(String paramMarca) {
        super(paramMarca);
    }

    public Carro(String paramMarca, String paramModelo) {
        super(paramMarca, paramModelo);
    }

    public Carro(String paramMarca, String paramModelo, int paramAnoFab, int paraAnoFab, int paramAnoMod, int anoModelo) {
        super(paramMarca, paramModelo, paramAnoFab, paraAnoFab, paramAnoMod, anoModelo);
    }
    
    public static String teste(){
        return "teste";
        
    }
    public static Carro build(String marca, int modelo){
        
    }
        
    
       private int valor = 10;
       private static String teste = "testando...";
       static{
           System.out.println("Chamando o bloco statico so aparece 1 vez:");
       }
       {
           System.out.println("Este bloco vai rodar sempre que o construtor criar:");
       }
       public Carro(){
        super(marca);
        System.out.println("Construtor do carro chamado");
        System.out.println("Valor"+valor);
        System.out.println(teste);
        System.out.println("=======================================================");
    }

    static class build extends Carro {

        build(String ford, int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

       
    }

}
