/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import cadastro.UtilitarioLogin;

/**
 *
 * @author 88178
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
        switch (UtilitarioLogin.usuarioLogado.getTipo()) {
            case ATENDENTE:
                btnUsuario.setEnabled(false);
                btnPaciente.setEnabled(false);
                break;
            case GERENTE:
                break;
            case MÉDICO:
                btnUsuario.setEnabled(false);
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPaciente = new javax.swing.JButton();
        btnVisitante = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new java.awt.GridLayout());

        btnPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tela/hospital32.png"))); // NOI18N
        btnPaciente.setText("Lista de pacientes");
        btnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnPaciente);

        btnVisitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tela/stethoscope.png"))); // NOI18N
        btnVisitante.setText("Visitantes");
        btnVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisitanteActionPerformed(evt);
            }
        });
        jPanel1.add(btnVisitante);

        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tela/heart8.png"))); // NOI18N
        btnUsuario.setText("Cadastro");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnUsuario);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tela/Philips.png"))); // NOI18N
        getContentPane().add(jLabel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        new AdmUsuario().setVisible(true);  
            

    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisitanteActionPerformed
        new ListaVisitante().setVisible(true);  
            
    }//GEN-LAST:event_btnVisitanteActionPerformed

    private void btnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteActionPerformed
        new ListaPacienteUti().setVisible(true);
    }//GEN-LAST:event_btnPacienteActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPaciente;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVisitante;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
