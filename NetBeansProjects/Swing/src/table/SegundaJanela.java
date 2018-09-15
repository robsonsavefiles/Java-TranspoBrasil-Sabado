
package table;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author 89087
 */
public class SegundaJanela extends JFrame implements ActionListener {
    
    private  MeuPrimeiroJTable janela;

    public MeuPrimeiroJTable getJanela() {
        return janela;
    }

    public void setJanela(MeuPrimeiroJTable janela) {
        this.janela = janela;
    }
    

    public SegundaJanela() {
    
        setSize(200, 300);
        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        getContentPane().add(pPrincipal);

        String[] colunas = {"Pessoa", "Profissão"};
        String[][] linhas = {
            {"Fabio", "Programador ABAP"},
            {"Getulio", "Programador COBOL"},
            {"Amanda", "Programador C#"},
            {"Jefferson", "Programador JAVA"}

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
        
       janela.setVisible(true);
       setVisible(false);
        
        
    }

}



