
package tables;

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

public class PrimeiraTela extends JFrame {
    
    private SegundaTela segundaTela;
    private JTextField txtSelecionado; 

    public void setSegundaTela(SegundaTela segundaTela) {
        this.segundaTela = segundaTela;
    }

    public void setTxtSelecionado(String texto) {
        this.txtSelecionado.setText(texto);
    }
    
    
    public PrimeiraTela(){
        setTitle("Informações Pessoais");
        setSize(600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        getContentPane().add(painelPrincipal);
        
        String[] coluna = {"Nome", "Data Nascimento", "Profissao", "Salário"};
        String [][] linha = {
            {"Joao", "01/12/1990", "Programador", "R$1.000,00"},
            {"Maria", "01/12/1990", "Balconista", "R$2.000,00"},
            {"Pedro", "02/10/1989", "Gerente", "R$3.000,00"},
            {"Joao", "01/12/1990", "Programador", "R$1.000,00"},
            
        };
        
        
        JTable tabela = new JTable(linha, coluna);
        
        JScrollPane scroll = new JScrollPane(tabela);
        painelPrincipal.add(scroll);
        
        JPanel painelSec = new JPanel();
        painelSec.setLayout(new BorderLayout());
        painelPrincipal.add(painelSec, BorderLayout.SOUTH);
        
        JPanel painelTer = new JPanel();
        painelTer.setLayout(new BorderLayout());
        painelSec.add(painelTer, BorderLayout.EAST);
        
        JButton mudarTela = new JButton("Muda TELA");
        painelTer.add(mudarTela, BorderLayout.EAST);
        
        txtSelecionado = new JTextField("Vai ter algo aqui");
        painelSec.add(txtSelecionado, BorderLayout.WEST);
        
        mudarTela.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                segundaTela.setVisible(true);
                
            }
        });
        
        
        
        
        
        
    }

}
