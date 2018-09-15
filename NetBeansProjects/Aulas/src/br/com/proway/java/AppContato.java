package br.com.proway.java;

import java.util.Scanner;

public class AppContato {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        CadastroContato cadastro = new CadastroContato();// referencia para chamar o menu
        cadastro.setTeclado(teclado);
        cadastro.menu();

        teclado.close();

    }

}
