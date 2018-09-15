package fileChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import swing.exemplos.MeuPrimeiroJFrame;

/**
 *
 * @author 89087
 */
public class Exemplo01 extends JFrame {

    public Exemplo01() {
        setSize(300, 200);

        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        getContentPane().add(pPrincipal);

        JButton btFileChooser = new JButton("Selcione o Arquivo");
        pPrincipal.add(btFileChooser, BorderLayout.SOUTH);
        btFileChooser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser filechooser = new JFileChooser();
                int retornoValido = filechooser.showOpenDialog(null);
                if (retornoValido == JFileChooser.APPROVE_OPTION) {
                    File arquivoSelecionado = filechooser.getSelectedFile();
                    System.out.println(arquivoSelecionado.getAbsolutePath());
                }

            }
        });

    }

    public static void main(String[] args) {

        Exemplo01 tela = new Exemplo01();
        tela.setVisible(true);

    }

}
