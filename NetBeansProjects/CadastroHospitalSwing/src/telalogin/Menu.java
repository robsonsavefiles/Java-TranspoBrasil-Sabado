/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telalogin;

import javax.swing.JOptionPane;

/**
 *
 * @author 89087
 */
public class Menu extends javax.swing.JFrame {

    private Object lblLogin;
    private Object lblSenha;

    /**
     * Creates new form Menu
     */
    public Menu() {
         super("Tela de Menu");
        initComponents();
        switch(Tela.usuario){
            case "atendente":
               btnVisitantes.setVisible(true);
               btncadastrar.setEnabled(false);
               btnListaUTI.setEnabled(false);
                break;
            case "medico":
              btncadastrar.setEnabled(false);
              btnListaUTI.setVisible(true);
              btnVisitantes.setVisible(true);
                break;
            case "gerente":
               btnVisitantes.setVisible(true);
               btncadastrar.setVisible(true);
               btnListaUTI.setVisible(true);
                break;
                default:
                   
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

        btncadastrar = new javax.swing.JButton();
        btnListaUTI = new javax.swing.JButton();
        btnVisitantes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btncadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telalogin/imagens/adm.png"))); // NOI18N
        btncadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarActionPerformed(evt);
            }
        });

        btnListaUTI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telalogin/imagens/Uti.png"))); // NOI18N
        btnListaUTI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaUTIActionPerformed(evt);
            }
        });

        btnVisitantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telalogin/imagens/visit.png"))); // NOI18N
        btnVisitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisitantesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Administração");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Lista De Pacientes-UTI");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Visitantes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btncadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(btnListaUTI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVisitantes)
                    .addComponent(btncadastrar)
                    .addComponent(btnListaUTI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
     
        new Cadastrar().setVisible(true);
       

    }//GEN-LAST:event_btncadastrarActionPerformed

    private void btnListaUTIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaUTIActionPerformed
        new PacienteUTI().setVisible(true);
       
    }//GEN-LAST:event_btnListaUTIActionPerformed

    private void btnVisitantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisitantesActionPerformed
        new Visitante().setVisible(true);
        
    }//GEN-LAST:event_btnVisitantesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListaUTI;
    private javax.swing.JButton btnVisitantes;
    private javax.swing.JButton btncadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
