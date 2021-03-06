/*
 * CategoryPanel.java
 *
 * Created on 1 de Fevereiro de 2006, 12:12
 */

package br.com.invnautico.core.gui.panel;

import br.com.invnautico.core.gui.InvNautico;
import br.com.invnautico.core.gui.common.GUICommand;
import br.com.invnautico.core.model.INBasicEntity;
import br.com.invnautico.core.model.INBrand;
import br.com.invnautico.core.model.INCategory;
import br.com.invnautico.core.model.INLocation;
import br.com.invnautico.core.persistence.DataManager;
import java.util.Collection;

/**
 *
 * @author  vsenger
 */
public class BasicEntityPanel extends javax.swing.JPanel {
    private INBasicEntity entity;
    public InvNautico master;
    /** Creates new form CategoryPanel */
    public BasicEntityPanel() {
        initComponents();
        initEvents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        checkAtivo = new javax.swing.JCheckBox();
        okCancelApplyPanel1 = new br.com.invnautico.core.gui.common.OkCancelApplyPanel();
        labelTitulo = new javax.swing.JLabel();

        jLabel1.setText("ID");

        textID.setEditable(false);

        jLabel2.setText("Nome");

        checkAtivo.setText("Ativo");
        checkAtivo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        checkAtivo.setMargin(new java.awt.Insets(0, 0, 0, 0));

        labelTitulo.setText("Edi\u00e7\u00e3o de Entidades Simples");
        labelTitulo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(labelTitulo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jLabel1))
                        .add(14, 14, 14)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(textID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 187, Short.MAX_VALUE)
                                .add(checkAtivo))
                            .add(textNome, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, okCancelApplyPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(labelTitulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(checkAtivo)
                    .add(textID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(textNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 21, Short.MAX_VALUE)
                .add(okCancelApplyPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelTitulo;
    private br.com.invnautico.core.gui.common.OkCancelApplyPanel okCancelApplyPanel1;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
    
    public void setEntityObject(INBasicEntity entity) {
        this.entity=entity;
        this.textID.setText(entity.getId()!=null ? entity.getId().toString() : null);
        this.textNome.setText(entity.getDescricao());
        this.checkAtivo.setSelected(entity.isAtivo());
        labelTitulo.setText("Edi��o do registro " + entity.toString());
    }
    
    public INBasicEntity commitToObject() {
        entity.setDescricao(textNome.getText());
        entity.setAtivo(checkAtivo.isSelected());
        return entity;
    }
    public void initEvents() {
        okCancelApplyPanel1.setCommandOK(new GUICommand() {
            public Collection execute(Collection a) {
                DataManager.getInstance().save(commitToObject());
                if(entity instanceof INCategory) master.populateTreeCategory();
                else if(entity instanceof INBrand) master.populateTreeBrand();
                else if(entity instanceof INLocation) master.populateTreeLocation();
                
                return null;
            }
        });
        
        
    }
    
    
    
}
