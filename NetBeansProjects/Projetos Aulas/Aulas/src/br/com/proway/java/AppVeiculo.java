package br.com.proway.java;

import java.util.Scanner;

public class AppVeiculo {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        CadastroVeiculo veiculo = new CadastroVeiculo();// referencia para chamar o menu

        veiculo.setTeclado(teclado);
        veiculo.menu();

        teclado.close();

    }

}
