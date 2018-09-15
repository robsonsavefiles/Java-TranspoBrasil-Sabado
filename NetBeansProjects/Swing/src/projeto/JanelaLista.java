package projeto;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author 78522
 */
public class JanelaLista extends JFrame implements ActionListener {
    private javax.swing.JTextField jTextFieldDisplay;
    private final JRadioButton opcao1;
    private final JRadioButton opcao2;
    private enum OPCOES {

        ESCOLHER("0"), TROCAR("1");

        private final String command;

        private OPCOES(String command) {
            this.command = command;
        }

        public String getCommand() {
            return command;
        }

    }

    private JanelaTabela outra;
    private JList lista;
    private JLabel labelUrl;

    public JanelaTabela getOutra() {
        return outra;
    }

    public void setOutra(JanelaTabela outra) {
        this.outra = outra;
    }

    public JanelaLista() {
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        add(pPrincipal);

        JPanel pCentro = new JPanel();
        pCentro.setLayout(new BorderLayout());
        pPrincipal.add(pCentro, BorderLayout.CENTER);
        
        

        lista = new JList(new String[]{"Lista 1", "Lista 2", "Lista 3"});
        pCentro.add(lista, BorderLayout.CENTER);

        labelUrl = new JLabel();
        pCentro.add(labelUrl, BorderLayout.SOUTH);

        JPanel pSul = new JPanel();
        pSul.setLayout(new BorderLayout());
        pPrincipal.add(pSul, BorderLayout.SOUTH);
        
              
        JButton botaoOutra = new JButton();
        botaoOutra.setActionCommand(OPCOES.TROCAR.getCommand());
        botaoOutra.setText("Outra Janela");
        botaoOutra.addActionListener(this);
        pSul.add(botaoOutra, BorderLayout.EAST);
       
        JButton botaoFc = new JButton();
        botaoFc.setActionCommand(OPCOES.ESCOLHER.getCommand());
        botaoFc.setText("Escolher Arquivo");
        botaoFc.addActionListener(this);
        pSul.add(botaoFc, BorderLayout.CENTER);
        
        
        JPanel pSudoeste = new JPanel();
        pSudoeste.setLayout(new FlowLayout());
        pSul.add(pSudoeste, BorderLayout.WEST);
        
        opcao1 = new JRadioButton("1");
        opcao2 = new JRadioButton("2");
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(opcao1);
        grupo.add(opcao2);
        
        pSudoeste.add(opcao1);
        pSudoeste.add(opcao2);
       

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equalsIgnoreCase(OPCOES.TROCAR.getCommand())) {
            outra.getLabel().setText(lista.isSelectionEmpty() ? "" : lista.getSelectedValue().toString());
            outra.setVisible(true);
            setVisible(false);
        }

        if (command.equalsIgnoreCase(OPCOES.ESCOLHER.getCommand())) {
            JFileChooser jfc = new JFileChooser();
            int result = jfc.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                labelUrl.setText(jfc.getSelectedFile().getAbsolutePath());
            }
        }
    }

}









