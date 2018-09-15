package decorator;

/**
 *
 * @author 89087
 */
public class DecoradorBarraVertical extends JanelaDecorator {

    public DecoradorBarraVertical(Janela janela) {
        super(janela);
    }

    @Override
    public void abrir() {
        System.out.println("Colocou uma Barra Vertical");

    }
}
