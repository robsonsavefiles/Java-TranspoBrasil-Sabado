/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import tela.Login;

/**
 *
 * @author 88178
 */
public class CadastroLogins {

    public static void main(String[] args) {
      
     try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
       }
        new Login().setVisible(true);

    }

}
