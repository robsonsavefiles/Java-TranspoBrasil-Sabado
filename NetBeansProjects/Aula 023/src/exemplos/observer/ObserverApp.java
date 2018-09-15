package exemplos.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author 78522
 */
public class ObserverApp {

    private final Scanner teclado;
    private final Observavel observavel = new Observavel();
    private final List<Observador> observadores = new ArrayList();

    public ObserverApp(Scanner teclado) {
        this.teclado = teclado;
    }

    public void menu() {
        String opcao;
        do {
            System.out.println("1 - Adicionar Observador");
            System.out.println("2 - Remover Observador");
            System.out.println("3 - Adicionar Item");
            System.out.println("4 - Sair");
            opcao = teclado.nextLine();
            tratarOpcao(opcao);
        } while (!"4".equals(opcao));
    }

    public void tratarOpcao(String opcao) {
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

    public void adicionarObservador() {
        Observador obs = new Observador() {
            int numero = observadores.size();

            @Override
            public void notificar(String data) {
                System.out.println("Observador " + numero + " recebendo Item " + data);
            }
        };
        observadores.add(obs);
        observavel.registrarObservador(obs);
    }

    public void removerUltimoObservador() {
        if (!observadores.isEmpty()) {
            observavel.removerObservador(observadores.get(observadores.size() - 1));
            observadores.remove(observadores.size() - 1);
        } else {
            System.out.println("Não exitem observadores!");
        }
    }

    public void adicionarItem() {
        String item = UUID.randomUUID().toString();
        observavel.adicionarItem(item);
    }
}
