/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import Controle.Tarefa;
import Controle.Usuario;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author home
 */
public class JFrameTarefas extends javax.swing.JFrame {

    /**
     * Creates new form JFrameTarefas
     */
    public JFrameTarefas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        JavaApplicationAgendaJAVAPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("JavaApplicationAgendaJAVAPU").createEntityManager();
        tarefaQuery = java.beans.Beans.isDesignTime() ? null : JavaApplicationAgendaJAVAPUEntityManager.createQuery("SELECT t FROM Tarefa t WHERE t.idUsuario.id=" + this.usuario.getId());
        tarefaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(tarefaQuery.getResultList());
        jButtonExcluir = new javax.swing.JButton();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabelDescricao = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabelData = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonInserir = new javax.swing.JButton();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jButtonSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTarefas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tarefas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableTarefas, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.descricao}"), jTextFieldDescricao, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextFieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyPressed(evt);
            }
        });

        jLabelDescricao.setText("Descrição");

        jLabelId.setText("Id");

        jTextFieldId.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableTarefas, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.id}"), jTextFieldId, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabelData.setText("Data");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonInserir.setText("Inserir");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTableTarefas, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.data}"), jFormattedTextFieldData, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jFormattedTextFieldData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyPressed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tarefaList, jTableTarefas);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descricao}"));
        columnBinding.setColumnName("Descricao");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${data}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idUsuario}"));
        columnBinding.setColumnName("Id Usuario");
        columnBinding.setColumnClass(Controle.Usuario.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane1.setViewportView(jTableTarefas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDescricao)
                            .addComponent(jLabelData)
                            .addComponent(jLabelId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldId)
                            .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelar))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelId)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDescricao)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelData)
                            .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:

        if (JOptionPane.showConfirmDialog(rootPane, "Confirma a exclusão deste registro?") == JOptionPane.OK_OPTION) {
            try {
                Tarefa tarefa = new Tarefa(); // Cria o objeto
                tarefa.setId(Long.valueOf(this.jTextFieldId.getText())); // Configura o id de exclusão
                if (tarefa.desarmazenado()) { // Exclui o objeto do BD
                    int linhaSelecionada = this.jTableTarefas.getSelectedRow(); // Marca linha selecionada da tabela
                    this.tarefaList.remove(this.jTableTarefas.getSelectedRow()); // Remove objeto da lista
                    if (this.jTableTarefas.getRowCount() > 0) { // Se houver linhas na tabela
                        if (linhaSelecionada > 0) {
                            linhaSelecionada--;
                        }
                        this.jTableTarefas.setRowSelectionInterval(linhaSelecionada, linhaSelecionada); // Seleciona linha marcada
                    }

                    //Configura botões
                    this.jButtonInserir.setEnabled(true);
                    this.jButtonExcluir.setEnabled(this.jTableTarefas.getRowCount() != 0);
                    this.jButtonCancelar.setEnabled(false);
                    this.jButtonSalvar.setEnabled(false);

                    this.estado = Estado.CONSULTANDO;

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTextFieldDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyPressed
        // TODO add your handling code here:
        // Configura botões
        this.jButtonInserir.setEnabled(false);
        this.jButtonExcluir.setEnabled(false);
        this.jButtonCancelar.setEnabled(true);
        this.jButtonSalvar.setEnabled(true);

        if (this.estado == Estado.CONSULTANDO) {
            if (this.jTableTarefas.getRowCount() != 0) {
                this.estado = Estado.EDITANDO;
            } else {
                this.jButtonInserirActionPerformed(null);
            }
        }
    }//GEN-LAST:event_jTextFieldDescricaoKeyPressed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        try {
            if (this.estado == Estado.INSERINDO) {
                this.tarefaList.remove(this.jTableTarefas.getSelectedRow()); // Remove objeto inserido na lista
                if (this.jTableTarefas.getRowCount() > 0) { // Se houver objetos na lista
                    // Seleciona o último da lista
                    this.jTableTarefas.setRowSelectionInterval(this.jTableTarefas.getRowCount() - 1, this.jTableTarefas.getRowCount() - 1);
                }
            } else {
                Tarefa tarefa = new Tarefa();
                if (tarefa.encontradoId(Long.valueOf(this.jTextFieldId.getText()))) {
                    this.jTextFieldDescricao.setText(tarefa.getDescricao());
                    this.jFormattedTextFieldData.setText(tarefa.getData().toString());
                }

            }

            //Configura botões
            this.jButtonInserir.setEnabled(true);
            this.jButtonExcluir.setEnabled(this.jTableTarefas.getRowCount() != 0);
            this.jButtonCancelar.setEnabled(false);
            this.jButtonSalvar.setEnabled(false);
            this.estado = Estado.CONSULTANDO;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        try {

            // Cria e configura o objeto
            Tarefa tarefa = new Tarefa();

            if (this.estado == Estado.INSERINDO) {

                // Atualiza o objeto
                tarefa.setIdUsuario(this.getUsuario());
                tarefa.setDescricao(this.jTextFieldDescricao.getText());
                SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                tarefa.setData((java.util.Date) data.parse(this.jFormattedTextFieldData.getText()));

                if (tarefa.armazenado()) { // Se armazenado objeto no BD

                    // Retira o objeto da lista e o adiciona com o id
                    this.tarefaList.remove(this.jTableTarefas.getSelectedRow());
                    this.tarefaList.add(tarefa);

                    // Seleciona o último da lista
                    this.jTableTarefas.setRowSelectionInterval(this.jTableTarefas.getRowCount() - 1, this.jTableTarefas.getRowCount() - 1);
                    this.jButtonInserir.setEnabled(true);
                    this.jButtonExcluir.setEnabled(this.jTableTarefas.getRowCount() != 0);
                    this.jButtonCancelar.setEnabled(false);
                    this.jButtonSalvar.setEnabled(false);

                    this.estado = Estado.CONSULTANDO;
                }
            } else {
                // Encontra e carrega o objeto de atualização
                if (tarefa.encontradoId(Long.valueOf(this.jTextFieldId.getText()))) {

                    // Atualiza o objeto
                    tarefa.setDescricao(this.jTextFieldDescricao.getText());
                    SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                    tarefa.setData((java.util.Date) data.parse(this.jFormattedTextFieldData.getText()));


                    if (tarefa.atualizado()) { // Se atualizado objeto no BD

                        // Seleciona o último da lista
                        this.jButtonInserir.setEnabled(true);
                        this.jButtonExcluir.setEnabled(this.jTableTarefas.getRowCount() != 0);
                        this.jButtonCancelar.setEnabled(false);
                        this.jButtonSalvar.setEnabled(false);

                        this.estado = Estado.CONSULTANDO;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        // TODO add your handling code here:
        Tarefa tarefa = new Tarefa();
        this.tarefaList.add(tarefa);

        // Seleciona objeto inserido na lista e estabelece foco
        this.jTableTarefas.setRowSelectionInterval(this.jTableTarefas.getRowCount() - 1, this.jTableTarefas.getRowCount() - 1);
        this.jTextFieldDescricao.requestFocus();

        //Configura botões
        this.jButtonInserir.setEnabled(false);
        this.jButtonExcluir.setEnabled(false);
        this.jButtonCancelar.setEnabled(true);
        this.jButtonSalvar.setEnabled(true);

        this.estado = Estado.INSERINDO;
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.setTitle(this.getTitle() + this.getUsuario().getNome());

        if (this.jTableTarefas.getRowCount() > 0) { // Se houver linhas na lista
            this.jTableTarefas.setRowSelectionInterval(0, 0); // Seleciona linha 0
        }

        // Configura botões 
        this.jButtonInserir.setEnabled(true);
        this.jButtonExcluir.setEnabled(this.jTableTarefas.getRowCount() != 0);
        this.jButtonCancelar.setEnabled(false);
        this.jButtonSalvar.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameTarefas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTarefas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTarefas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTarefas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameTarefas().setVisible(true);
            }
        });
    }

    public JFrameTarefas(Usuario usuario) {
        this.setUsuario(usuario);
        this.initComponents();
        this.setTitle(this.getTitle() + " do usuário ");
    }

    private enum Estado {

        INSERINDO,
        EDITANDO,
        CONSULTANDO
    }
    private Estado estado = Estado.CONSULTANDO;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager JavaApplicationAgendaJAVAPUEntityManager;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTarefas;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldId;
    private java.util.List<Controle.Tarefa> tarefaList;
    private javax.persistence.Query tarefaQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
