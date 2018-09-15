/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import hospital.view.controller.MenuPrincipalController;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 89087
 */
public class Menu extends javax.swing.JFrame implements MenuPrincipalController.Display {

    private final MenuPrincipalController controller;
    /**
     * Creates new form Menu
     */
    public Menu() {
         super("Tela de Menu");
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        controller = new MenuPrincipalController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUsuarios = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        btnVisitantes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        miLogoff = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telalogin/imagens/adm.png"))); // NOI18N
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telalogin/imagens/Uti.png"))); // NOI18N
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });

        btnVisitantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telalogin/imagens/visit.png"))); // NOI18N
        btnVisitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisitantesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Usuarios");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Lista De Pacientes");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Visitantes");

        miLogoff.setText("Logoff");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVisitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(miLogoff)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(miLogoff)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVisitantes)
                    .addComponent(btnPacientes)
                    .addComponent(btnUsuarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
   
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
       
       
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnVisitantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisitantesActionPerformed
      
        
    }//GEN-LAST:event_btnVisitantesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPacientes;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVisitantes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton miLogoff;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setAcaoMenuPacientes(ActionListener listener) {
        btnPacientes.addActionListener(listener);
    }

    @Override
    public void setAcaoMenuVisitantes(ActionListener listener) {
        btnVisitantes.addActionListener(listener);
    }

    @Override
    public void setAcaoMenuUsuarios(ActionListener listener) {
        btnUsuarios.addActionListener(listener);
    }

    @Override
    public void setAcaoLogoff(ActionListener listener) {
        miLogoff.addActionListener(listener);
    }

    @Override
    public void setAcessoBtnPacientes(boolean acesso) {
        btnPacientes.setEnabled(acesso);
    }

    @Override
    public void setAcessoBtnVisitantes(boolean acesso) {
        btnVisitantes.setEnabled(acesso);
    }

    @Override
    public void setAcessoBtnUsuarios(boolean acesso) {
        btnUsuarios.setEnabled(acesso);
    }

    @Override
    public void fechar() {
        dispose();
    }

}


