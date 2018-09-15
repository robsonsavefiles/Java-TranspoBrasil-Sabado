package contexto;

import implementacoes.Correios;
import implementacoes.PAC;
import implementacoes.Sedex;
import implementacoes.SemFrete;
import modelo.Transporte;

public class Executor extends javax.swing.JFrame {
    
    Transporte transporte;

    public Executor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rbCorreios = new javax.swing.JRadioButton();
        rbPAC = new javax.swing.JRadioButton();
        rbSedex = new javax.swing.JRadioButton();
        rbSemFrete = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(rbCorreios);
        rbCorreios.setText("Correios");

        buttonGroup1.add(rbPAC);
        rbPAC.setText("PAC");

        buttonGroup1.add(rbSedex);
        rbSedex.setText("Sedex");

        buttonGroup1.add(rbSemFrete);
        rbSemFrete.setText("Sem Frete");

        jButton1.setText("Gerar Frete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbCorreios)
                    .addComponent(rbPAC)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbSemFrete)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1))
                    .addComponent(rbSedex))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbCorreios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPAC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbSedex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSemFrete)
                    .addComponent(jButton1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        transporte = new Transporte();
        
        if (rbCorreios.isSelected()) {
            
            transporte.setFrete(new Correios());
        } else if (rbPAC.isSelected()) {
            
            transporte.setFrete(new PAC());
        } else if (rbSedex.isSelected()) {
            
            transporte.setFrete(new Sedex());
        } else {
            
            transporte.setFrete(new SemFrete());
        }
        
        System.out.println(transporte.getFrete().calculaFrete("SC"));
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Executor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButton rbCorreios;
    private javax.swing.JRadioButton rbPAC;
    private javax.swing.JRadioButton rbSedex;
    private javax.swing.JRadioButton rbSemFrete;
    // End of variables declaration//GEN-END:variables
}
