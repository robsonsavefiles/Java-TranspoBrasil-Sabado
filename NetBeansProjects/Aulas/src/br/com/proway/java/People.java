package br.com.proway.java;

public class People {

    static int contador = 0;
    int count = 0;

    public People() {
        contador++;
        count++;

    }

    public static int getContador() {
        return contador;// varivel statica

    }

    public static int getContador2() {
        return contador;
    }
}
