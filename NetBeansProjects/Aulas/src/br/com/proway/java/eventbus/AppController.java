package br.com.proway.java.eventbus;

/**
 *
 * @author 89087
 */
public class AppController implements NavegacaoPresenter {

    @Override
    public void irPara(Telas telas) {
        if (Telas.PRINCIPAL == tela) {
            PainelTabelaCliente painelTabela = new PainelTabelaCliente();
            TabelaClientesPresenter presenter1 = new TabelaClientesPresenter(painelTabela);
            presenter.bind();

            PainelFormularioCliente painelFormularioCliente = new PainelFormularioCliente();
            FormularioClientePresenter presenter2 = new FormularioClientePresenter(painelTabela);
            presenter.bind();
            Tela tela = new Tela(painelTabela,painelFormularioCliente);
            frame.setVisible(true);
            
        }

    }

}
