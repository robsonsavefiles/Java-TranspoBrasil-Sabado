package table;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author 89087
 */
public class MeuPrimeiroJTable extends JFrame implements ActionListener{
    private JTextField area;
    private javax.swing.JTextField jTextFieldDisplay; 
    
    private SegundaJanela janela;

    public SegundaJanela getJanela() {
        return janela;
    }

    public void setJanela(SegundaJanela janela) {
        this.janela = janela;
    }

    public MeuPrimeiroJTable() {
        setSize(200, 300);
        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        getContentPane().add(pPrincipal);

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
       
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        
       
    }

}
