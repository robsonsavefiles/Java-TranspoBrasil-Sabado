package br.com.proway.java.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author 89087
 */
public class ObserverApp {

    private Scanner teclado;
    private Observado observado = new Observado();

    private List<Observador> observadores = new ArrayList<Observador>();

    private void setTeclado(Scanner teclado) {
        this.teclado = teclado;

    }

    public void menu() {
        String opcao = "";
        do {

            System.out.println("1- Adicionar Observador");
            System.out.println("2- Remover Observador");
            System.out.println("3- Adicioanar Item");
            System.out.println("3- Sair ");
            opcao = teclado.nextLine();
            tratarOpcao(opcao);

        } while (!"4".equals(opcao));
    }

    private void tratarOpcao(String opcao) {
        switch (opcao) {
            case "1":
                adicionarObservador();
                break;
            case "2":
                removerUltimoObservador();
                break;
            case "3":
                adicionarItem();
                break;
        }
    }

    private void adicionarObservador() {
        Observador obs = new Observador() {
            int numero = observadores.size()+1;

            @Override
            public void notificar(String data) {
                System.out.printf("Observador %d recebendo item %s\r\n",numero, data);

            }
        };
        observadores.add(obs);
        observado.registrarObservador(obs);
    }

    private void removerUltimoObservador() {

        if (!observadores.isEmpty()) {
            Observador remove = observadores.remove(observadores.size()-1);
        } else {
            System.out.println("Nao existem observadores!!!!");
        }

    }

    private void adicionarItem() {

        String item = UUID.randomUUID().toString();
        observado.adicionarItem(item);

    }

    public static void main(String[] args) {
        ObserverApp app = new ObserverApp();
        Scanner teclado = new Scanner(System.in);
        app.setTeclado(teclado);
        app.menu();
        teclado.close();
    }
}
