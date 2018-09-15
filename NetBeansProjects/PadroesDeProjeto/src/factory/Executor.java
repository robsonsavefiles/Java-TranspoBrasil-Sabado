
package factory;

import javax.swing.JOptionPane;

/**
 *
 * @author 89087
 */
public class Executor {
    
    public static void main(String[] args){
        TelaFactory.getTela01().abrirTela();
        
        TelaFactory.getTela02().abrirTela();
        JOptionPane.showInputDialog("");
        TelaFactory.getTela02().setVisible(false);
    }

}
