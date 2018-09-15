package layouts;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author 89087
 */
public class EditorDeTexto extends JFrame implements ActionListener {

    JTextArea texto;

    public EditorDeTexto() {
        super("Editor De Textos");

        texto = new JTextArea();
        JScrollPane scroll = new JScrollPane(texto);
        texto.setFont(new Font("Serif", Font.PLAIN, 26));

        JButton botao = new JButton("Abrir Arquivo");
        botao.setFont(new Font("Serif", Font.BOLD, 26));
        botao.addActionListener(this);

        Container c = getContentPane();
        c.add(BorderLayout.CENTER, scroll);
        c.add(BorderLayout.SOUTH, botao);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);

    }

    public static void main(String[] args) {
        new EditorDeTexto();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser c = new JFileChooser();
        c.showOpenDialog(this);
        c.getSelectedFile();
        File file = c.getSelectedFile();
        try {
            Path path = Paths.get(file.getAbsolutePath());
            String retorno = new String(Files.readAllBytes(path));
            texto.setText(retorno);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Não Conseguimos carregar o Arquivo");
        }

    }

}
