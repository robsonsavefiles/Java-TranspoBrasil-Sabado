package exercicios.cliente.view;

import exercicios.cliente.view.presenter.ClienteTableModel;
import exercicios.cliente.view.presenter.PainelTabelaPresenter;
import exercicios.cliente.model.Cliente;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author 78522
 */
public class PainelTabela extends javax.swing.JPanel implements PainelTabelaPresenter.Display {

    /**
     * Creates new form PainelTabela
     */
    public PainelTabela() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();

        setLayout(new java.awt.GridLayout());

        tableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableCliente);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCliente;
    // End of variables declaration//GEN-END:variables

    @Override
    public void configurarTabela(ClienteTableModel model) {
        tableCliente.setModel(model);
        tableCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @Override
    public Cliente getSelecionado() {
        ClienteTableModel model = (ClienteTableModel) tableCliente.getModel();
        return model.getLinha(tableCliente.convertRowIndexToModel(tableCliente.getSelectedRow()));
    }

    @Override
    public void setAcaoSelecionar(ListSelectionListener listener) {
        tableCliente.getSelectionModel().addListSelectionListener(listener);
    }
}