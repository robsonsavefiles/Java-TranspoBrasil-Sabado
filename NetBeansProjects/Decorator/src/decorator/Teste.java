package decorator;

/**
 * @author 89087
 */
public class Teste {

    public static void main(String[] args) {

        Janela janela = new DecoradorBarraVertical(new JanelaSimples());
        janela.abrir();
    }

}
