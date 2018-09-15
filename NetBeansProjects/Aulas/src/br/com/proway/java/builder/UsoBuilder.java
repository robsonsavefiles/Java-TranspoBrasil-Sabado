package br.com.proway.java.builder;

import java.util.Date;

/**
 *
 * @author 89087
 */
public class UsoBuilder {

    public static void main(String[] args) {
        
        try{
        ClienteBuilder builder = new ClienteBuilder("Ferreira","Robson","34860234898");
        builder.setDataNascimento(new Date()).setSexo(Genero.MASCULINO).setTelefoneResidencial("33839482");

        Cliente cliente = builder.build();
        System.out.println(cliente.toString());

    }catch(Exception E){
        System.out.println("Erro");
    }
}
}