package hospital.views;

import hospital.model.Paciente;
import hospital.view.controller.BuscaPacienteController;
import hospital.view.controller.PacienteSelectionListener;
import hospital.view.controller.TableModelPaciente;
import java.awt.event.ActionListener;

/**
 *
 * @author 78522
 */
public class BuscaPaciente extends javax.swing.JFrame implements BuscaPacienteController.Display {

    private final BuscaPacienteController controller;

    public BuscaPaciente(PacienteSelectionListener listener) {
        initComponents();
        controller = new BuscaPacienteController(this, listener);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelBotoes = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Pacientes UTI");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelBotoes.setLayout(new java.awt.GridLayout(1, 0));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/resources/cross108.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        panelBotoes.add(btnCancelar);

        btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/resources/ok2.png"))); // NOI18N
        btnSelecionar.setText("Selecionar");
        panelBotoes.add(btnSelecionar);

        getContentPane().add(panelBotoes, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(0, 1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/resources/add182.png"))); // NOI18N
        jPanel2.add(btnAdd);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelBotoes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setAcaoAdd(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    @Override
    public void configurarTabela(TableModelPaciente model) {
        jTable1.setModel(model);
    }

    @Override
    public Paciente getSelected() {
        return jTable1.getSelectedRowCount() > 0 ? ((TableModelPaciente) jTable1.getModel()).getRow(jTable1.convertRowIndexToModel(jTable1.getSelectedRow())) : null;
    }

    @Override
    public void setAcaoCancel(ActionListener listener) {
        btnCancelar.addActionListener(listener);
    }

    @Override
    public void setAcaoSelecionar(ActionListener listener) {
        btnSelecionar.addActionListener(listener);
    }

    @Override
    public void fechar() {
        dispose();
    }

}
