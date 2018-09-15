package fileChooser;

import table.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author 89087
 */
public class MeuPrimeiroFileChooser extends JFrame implements ActionListener {

    private JTextField area;
    private javax.swing.JTextField jTextFieldDisplay;

    private FileChooser_SegundaJanela janela;

    public FileChooser_SegundaJanela getJanela() {
        return janela;
    }

    public void setJanela(FileChooser_SegundaJanela janela) {
        this.janela = janela;
    }

    public MeuPrimeiroFileChooser() {
        setSize(200, 300);
        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        getContentPane().add(pPrincipal);

        JPanel south2 = new JPanel();
        south2.setLayout(new BorderLayout());
        getContentPane().add(south2);

        area = new JTextField();
        add(area, BorderLayout.NORTH);
        area.setEditable(false);

        String[] colunas = {"Pessoa", "Profissão"};
        String[][] linhas = {
            {"Robson", "Programador "},
            {"Ricardo", "Programado Senior"},
            {"Fernando", "Programador Senior"},
            {"Tiago", "Programador Senior"}

        };

        JTable tabela = new JTable(linhas, colunas);
        JScrollPane scroll = new JScrollPane(tabela);
        pPrincipal.add(scroll, BorderLayout.CENTER);

        JPanel south = new JPanel();
        JButton btnCadastrar = new JButton("Troca Tela");
        btnCadastrar.addActionListener(this);
        add(btnCadastrar, BorderLayout.SOUTH);
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
@Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }



    public static void main(String[] args) {

        table.MeuPrimeiroJTable janela1 = new table.MeuPrimeiroJTable();
        table.SegundaJanela janela2 = new table.SegundaJanela();
        janela1.setJanela(janela2);

        janela1.setVisible(true);
        janela2.setJanela(janela1);

    }

}