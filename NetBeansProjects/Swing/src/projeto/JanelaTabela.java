
package projeto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author 89087
 */
public class JanelaTabela extends JFrame implements ActionListener {

    private JanelaLista outra;
    private JLabel label;

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JanelaLista getOutra() {
        return outra;
    }

    public void setOutra(JanelaLista outra) {
        this.outra = outra;
    }

    public JanelaTabela() {
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        add(pPrincipal);

        String[] colunas = {"Coluna 1", "Coluna 2", "Coluna 3"};
        String[][] linhas = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}
        };

        JTable tabela = new JTable(linhas, colunas);
        pPrincipal.add(tabela, BorderLayout.CENTER);

        JPanel pSul = new JPanel();
        pSul.setLayout(new BorderLayout());
        pPrincipal.add(pSul, BorderLayout.SOUTH);

        JButton botao = new JButton();
        botao.setText("Outra Janela");
        botao.addActionListener(this);
        pSul.add(botao, BorderLayout.EAST);

        label = new JLabel();
        pSul.add(label, BorderLayout.WEST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        outra.setVisible(true);
        setVisible(false);
    }

}

