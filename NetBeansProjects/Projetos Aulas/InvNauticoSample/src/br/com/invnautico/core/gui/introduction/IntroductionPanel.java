/*
 * IntroductionPanel.java
 *
 * Created on February 2, 2006, 1:12 PM
 */

package br.com.invnautico.core.gui.introduction;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author  vsenger
 */
public class IntroductionPanel extends javax.swing.JPanel {
    ImageIcon img;
    /** Creates new form IntroductionPanel */
    public IntroductionPanel() {
        initComponents();
        URL u = IntroductionPanel.class.getResource("/inicial.jpg");
        img = new ImageIcon(u);
        imagem.setIcon(img);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        imagem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        imagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(imagem, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bem-vindo ao Invent\u00e1rio Nautico 1.0 - o passado, presente e futuro da sua embarca\u00e7\u00e3o");
        add(jLabel1, java.awt.BorderLayout.NORTH);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imagem;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
}