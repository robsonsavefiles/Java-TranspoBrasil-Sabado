package br.com.oficinaV2.presenter;

import br.com.oficinaV2.modelo.Veiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaListaVeiculoPresenter implements Presenter {

    private Display tela;
    private TableModelVeiculo modelo;

  
    public static interface Display {

        String getPlaca();

        String getCor();

        String getMarca();

        String getModelo();

        String anoFabricacao();

        String anoModelo();

        void limparCampos();

        void setAcaoSalvar(ActionListener listener);

        void configurarDados(TableModelVeiculo modelo);
        
        public void mostrar();

        public void ocultar();
    }

    public TelaListaVeiculoPresenter(Display tela) {
        this.tela = tela;
        inicializar();
    }

    private void inicializar() {
        modelo = new TableModelVeiculo();
        tela.configurarDados(modelo);
        tela.setAcaoSalvar(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           
            }
        });
    }
 @Override
    public void bind() {

    }

    @Override
    public void mostrar() {
          tela.mostrar();
    }

    @Override
    public void ocultar() {
        tela.ocultar();
    }
    

}
