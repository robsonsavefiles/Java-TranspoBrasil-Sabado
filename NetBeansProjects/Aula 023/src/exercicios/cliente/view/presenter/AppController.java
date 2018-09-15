package exercicios.cliente.view.presenter;

import exercicios.cliente.Telas;
import exercicios.cliente.view.PainelCliente;
import exercicios.cliente.view.PainelTabela;
import exercicios.cliente.view.Principal;

/**
 *
 * @author 78522
 */
public class AppController implements NavegacaoPresenter {

    @Override
    public void irPara(Telas tela) {
        if (Telas.PRINCIPAL == tela) {
            PainelTabela painelTabela = new PainelTabela();
            PainelTabelaPresenter presenter1 = new PainelTabelaPresenter(painelTabela);
            presenter1.bind();

            PainelCliente painelCliente = new PainelCliente();
            PainelClientePresenter presenter2 = new PainelClientePresenter(painelCliente);
            presenter2.bind();
            
            Principal frame = new Principal(painelTabela, painelCliente);
            frame.setVisible(true);
        }
    }

}
