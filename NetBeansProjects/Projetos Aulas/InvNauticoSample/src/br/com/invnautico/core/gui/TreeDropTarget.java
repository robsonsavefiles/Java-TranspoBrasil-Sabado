/*
 * TreeDropTarget.java
 *
 * Created on February 2, 2006, 12:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.invnautico.core.gui;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author vsenger
 */
public class TreeDropTarget implements DropTargetListener {
    
    DropTarget target;
    
    JTree targetTree;
    
    public TreeDropTarget(JTree tree) {
        targetTree = tree;
        target = new DropTarget(targetTree, this);
    }
    
  /*
   * Drop Event Handlers
   */
    private TreeNode getNodeForEvent(DropTargetDragEvent dtde) {
        Point p = dtde.getLocation();
        DropTargetContext dtc = dtde.getDropTargetContext();
        JTree tree = (JTree) dtc.getComponent();
        TreePath path = tree.getClosestPathForLocation(p.x, p.y);
        return (TreeNode) path.getLastPathComponent();
    }
    
    public void dragEnter(DropTargetDragEvent dtde) {
        System.out.println("target-dragEnter");
        TreeNode node = getNodeForEvent(dtde);
        if (node.isLeaf()) {
            dtde.rejectDrag();
        } else {
            // start by supporting move operations
            //dtde.acceptDrag(DnDConstants.ACTION_MOVE);
            dtde.acceptDrag(dtde.getDropAction());
        }
    }
    
    public void dragOver(DropTargetDragEvent dtde) {
        
        TreeNode node = getNodeForEvent(dtde);
        if (node.isLeaf()) {
            dtde.rejectDrag();
        } else {
            // start by supporting move operations
            //dtde.acceptDrag(DnDConstants.ACTION_MOVE);
            dtde.acceptDrag(dtde.getDropAction());
        }
    }
    
    public void dragExit(DropTargetEvent dte) {
        System.out.println("target-dragExit");
    }
    
    public void dropActionChanged(DropTargetDragEvent dtde) {
    }
    
    public void drop(DropTargetDropEvent dtde) {
        System.out.println("target-drop");
        Point pt = dtde.getLocation();
        DropTargetContext dtc = dtde.getDropTargetContext();
        JTree tree = (JTree) dtc.getComponent();
        TreePath parentpath = tree.getClosestPathForLocation(pt.x, pt.y);
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) parentpath
                .getLastPathComponent();
        if (parent.isLeaf()) {
            dtde.rejectDrop();
            return;
        }
        
        try {
            Transferable tr = dtde.getTransferable();
            DataFlavor[] flavors = tr.getTransferDataFlavors();
            for (int i = 0; i < flavors.length; i++) {
                if (tr.isDataFlavorSupported(flavors[i])) {
                    dtde.acceptDrop(dtde.getDropAction());
                    TreePath p = (TreePath) tr.getTransferData(flavors[i]);
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) p
                            .getLastPathComponent();
                    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                    model.insertNodeInto(node, parent, 0);
                    dtde.dropComplete(true);
                    return;
                }
            }
            dtde.rejectDrop();
        } catch (Exception e) {
            e.printStackTrace();
            dtde.rejectDrop();
        }
    }
}

