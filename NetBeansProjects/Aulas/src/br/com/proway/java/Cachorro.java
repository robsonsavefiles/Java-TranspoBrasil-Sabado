package br.com.proway.java;

public class Cachorro {

    private static long contador = 0;

    public Cachorro() {
        System.out.println("Criando um cachorro");
        contador++;

    }

    public static long getQuantidadeCachorros() {
        return contador;
    }

}
