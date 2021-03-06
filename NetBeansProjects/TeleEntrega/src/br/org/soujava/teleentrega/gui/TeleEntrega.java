/*
 * TeleEntrega.java
 *
 * Created on 11 de Mar�o de 2006, 10:37
 */

package br.org.soujava.teleentrega.gui;

import br.org.soujava.teleentrega.model.*;
import br.org.soujava.teleentrega.persistence.Manager;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Collection;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author  vsenger
 */
public class TeleEntrega extends javax.swing.JFrame {
  public static final String TITULO = "SouJava Brasil - Sistema para TeleEntrega 1.0";
  public static void main(String args[]) {
    TeleEntrega telaPrincipal = new TeleEntrega();
    telaPrincipal.setSize(500,400);
    telaPrincipal.center();
    telaPrincipal.populateTree();
    telaPrincipal.setTitle(TITULO);
    telaPrincipal.setVisible(true);
    
  }
  public void center() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    
  }
  /** Creates new form TeleEntrega */
  public TeleEntrega() {
    initComponents();
    panelCliente1.telaPai=this;
    panelPedido1.telaPai=this;
  }
  
  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
  private void initComponents() {
    jSplitPane1 = new javax.swing.JSplitPane();
    panelArvore = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    treeData = new javax.swing.JTree();
    panelDados = new javax.swing.JPanel();
    panelCliente1 = new br.org.soujava.teleentrega.gui.PanelCliente();
    panelPedido1 = new br.org.soujava.teleentrega.gui.PanelPedido();
    jMenuBar2 = new javax.swing.JMenuBar();
    jMenu2 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JSeparator();
    jMenuItem3 = new javax.swing.JMenuItem();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem4 = new javax.swing.JMenuItem();
    jMenuItem5 = new javax.swing.JMenuItem();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem6 = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    jSplitPane1.setDividerLocation(80);
    panelArvore.setLayout(new java.awt.BorderLayout());

    treeData.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
      public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
        treeDataValueChanged(evt);
      }
    });

    jScrollPane1.setViewportView(treeData);

    panelArvore.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    jSplitPane1.setLeftComponent(panelArvore);

    panelDados.setLayout(new java.awt.CardLayout());

    panelDados.add(panelCliente1, "cliente");

    panelDados.add(panelPedido1, "pedido");

    jSplitPane1.setRightComponent(panelDados);

    getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

    jMenu2.setMnemonic('C');
    jMenu2.setText("Clientes");
    jMenuItem1.setText("Novo cliente");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem1ActionPerformed(evt);
      }
    });

    jMenu2.add(jMenuItem1);

    jMenuItem2.setText("Excluir cliente");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem2ActionPerformed(evt);
      }
    });

    jMenu2.add(jMenuItem2);

    jMenu2.add(jSeparator1);

    jMenuItem3.setMnemonic('r');
    jMenuItem3.setText("Sair");
    jMenu2.add(jMenuItem3);

    jMenuBar2.add(jMenu2);

    jMenu1.setMnemonic('P');
    jMenu1.setText("Pedidos");
    jMenuItem4.setText("Novo pedido...");
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem4ActionPerformed(evt);
      }
    });

    jMenu1.add(jMenuItem4);

    jMenuItem5.setText("Excluir pedido");
    jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem5ActionPerformed(evt);
      }
    });

    jMenu1.add(jMenuItem5);

    jMenuBar2.add(jMenu1);

    jMenu3.setMnemonic('A');
    jMenu3.setText("Ajuda");
    jMenuItem6.setText("Sobre...");
    jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem6ActionPerformed(evt);
      }
    });

    jMenu3.add(jMenuItem6);

    jMenuBar2.add(jMenu3);

    setJMenuBar(jMenuBar2);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
// TODO add your handling code here:
    Sobre s = new Sobre(this, true);
    s.setSize(300,300);
    s.center();
    s.setVisible(true);
    
  }//GEN-LAST:event_jMenuItem6ActionPerformed

  private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
// TODO add your handling code here:
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeData.getLastSelectedPathComponent();
    if(node==null) return;
    Object objeto = node.getUserObject();
    if(objeto instanceof Pedido) {
      Manager.getInstance().delete(objeto);
      populateTree();
    }
    
  }//GEN-LAST:event_jMenuItem5ActionPerformed
  
  private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
// TODO add your handling code here:
    Pedido p =new Pedido();
    panelPedido1.bind(p);
    showPanel("pedido");
    
  }//GEN-LAST:event_jMenuItem4ActionPerformed
  
  private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
// TODO add your handling code here:
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeData.getLastSelectedPathComponent();
    if(node==null) return;
    Object objeto = node.getUserObject();
    if(objeto instanceof Cliente) {
      Cliente cliente = (Cliente) objeto;
      Manager.getInstance().delete(cliente);
      populateTree();
    }
    
  }//GEN-LAST:event_jMenuItem2ActionPerformed
  
  private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
    Cliente c =new Cliente();
    panelCliente1.bind(c);
    showPanel("cliente");
  }//GEN-LAST:event_jMenuItem1ActionPerformed
  private void showPanel(String nome) {
    CardLayout panelManager =(CardLayout) panelDados.getLayout();
    panelManager.show(panelDados, nome);
  }
  private void treeDataValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeDataValueChanged
// TODO add your handling code here:
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeData.getLastSelectedPathComponent();
    
    if(node==null) return;
    Object objeto = node.getUserObject();
    if(objeto instanceof String) {
    } else if(objeto instanceof Cliente) {
      Cliente cliente = (Cliente) objeto;
      showPanel("cliente");
      this.panelCliente1.bind(cliente);
    } else if(objeto instanceof Pedido) {
      Pedido pedido = (Pedido) objeto;
      showPanel("pedido");
      this.panelPedido1.bind(pedido);
      //this.panelCliente1.bind(cliente);
    }
    
  }//GEN-LAST:event_treeDataValueChanged
  
  /**
   * @param args the command line arguments
   */
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenuBar jMenuBar2;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JMenuItem jMenuItem4;
  private javax.swing.JMenuItem jMenuItem5;
  private javax.swing.JMenuItem jMenuItem6;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSplitPane jSplitPane1;
  private javax.swing.JPanel panelArvore;
  private br.org.soujava.teleentrega.gui.PanelCliente panelCliente1;
  private javax.swing.JPanel panelDados;
  private br.org.soujava.teleentrega.gui.PanelPedido panelPedido1;
  private javax.swing.JTree treeData;
  // End of variables declaration//GEN-END:variables
  public void populateTree() {
    Manager.getInstance().open();
    
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("TeleEntrega");
    DefaultMutableTreeNode nodeClientes = new DefaultMutableTreeNode("Clientes");
    DefaultMutableTreeNode nodeCliente = null;
    DefaultMutableTreeNode nodePedidos = new DefaultMutableTreeNode("Pedidos");
    DefaultTreeModel model = new DefaultTreeModel(root);
    treeData.setModel(model);
    root.removeAllChildren();
    root.add(nodeClientes);
    root.add(nodePedidos);
    Collection<Cliente> clientes = Manager.getInstance().getClientes();
    for(Cliente cliente : clientes) {
      nodeCliente =new DefaultMutableTreeNode(cliente);
      nodeClientes.add(nodeCliente);
      if(cliente.getPedidos()!=null && cliente.getPedidos().size()>0) {
        for(Pedido pedido : cliente.getPedidos()) {
          nodeCliente.add(new DefaultMutableTreeNode(pedido));
        }
      }
    }
    Collection<Pedido> pedidos = Manager.getInstance().getPedidos();
    for(Pedido pedido : pedidos) {
      nodePedidos.add(new DefaultMutableTreeNode(pedido));
    }
    
    
  }
  
}
