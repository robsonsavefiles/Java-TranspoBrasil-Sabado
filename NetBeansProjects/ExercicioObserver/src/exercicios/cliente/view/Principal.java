package exercicios.cliente.view;

import javax.swing.JPanel;

/**
 *
 * @author 78522
 */
public class Principal extends javax.swing.JFrame {

    private final JPanel painelTabela;
    private final JPanel painelCliente;

    public Principal(JPanel painelTabela, JPanel painelCliente) {
        this.painelTabela = painelTabela;
        this.painelCliente = painelCliente;
        initComponents();
        pnTabela.add(painelTabela);
        pnCliente.add(painelCliente);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTabela = new javax.swing.JPanel();
        pnCliente = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        pnTabela.setLayout(new java.awt.GridLayout());
        getContentPane().add(pnTabela);

        pnCliente.setLayout(new java.awt.GridLayout());
        getContentPane().add(pnCliente);

        setSize(new java.awt.Dimension(493, 548));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnTabela;
    // End of variables declaration//GEN-END:variables
}
