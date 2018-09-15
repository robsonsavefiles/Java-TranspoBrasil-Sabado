package jTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author 89087
 */
public class Exemplo01 extends JFrame {

    public Exemplo01() {

        super("Exemplo JTextArea");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        pPrincipal.setBackground(Color.red);
        getContentPane().add(pPrincipal);

        JTextField tField = new JTextField();
        pPrincipal.add(tField, BorderLayout.SOUTH);

        JTextArea tArea = new JTextArea();
        pPrincipal.add(tArea, BorderLayout.NORTH);
    }

    public static void main(String[] args) {

        Exemplo01 tela = new Exemplo01();
        tela.setVisible(true);

    }

}
