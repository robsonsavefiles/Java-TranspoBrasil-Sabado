
package projetoswing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SegundaTela extends JFrame{
    
    private PrimeiraTela primeiraTela;
    private final JTextField tfArquivo;

    // RadioButton
    private ButtonGroup grupo = new ButtonGroup();
    private JRadioButton opcao1;
    private JRadioButton opcao2;
    
    private String dsCaminhoCompleto = "";
    private String dsNomeArquivo = "";
    
    public void setPrimeiraTela(PrimeiraTela primeiraTela) {
        this.primeiraTela = primeiraTela;
    }

    public SegundaTela(){
        setTitle("Informações Pessoais TELA 2");
        setSize(600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        getContentPane().add(painelPrincipal);
        
        String[] conteudo = {"Nome", "Data Nascimento", "Profissao", "Salário"};
        
        JList lista = new JList(conteudo);
        
        JScrollPane scroll = new JScrollPane(lista);
        painelPrincipal.add(scroll);
        
        JPanel painelSul = new JPanel();
        painelSul.setLayout(new BorderLayout());
        painelPrincipal.add(painelSul, BorderLayout.SOUTH);
        
        JPanel painelSudoeste = new JPanel();
        painelSudoeste.setLayout(new FlowLayout());
        painelSul.add(painelSudoeste, BorderLayout.EAST);
        
        // RadioButton
        opcao1 = new JRadioButton("Caminho Completo");
        opcao2 = new JRadioButton("Só nome do arquivo");
        opcao1.setSelected(true);
        grupo.add(opcao1);
        grupo.add(opcao2);        
        opcao1.addActionListener(new ClicouRadionButton());
        opcao2.addActionListener(new ClicouRadionButton());
                
        JButton mudarTela = new JButton("Muda TELA");
        
        tfArquivo = new JTextField("");
        tfArquivo.setEditable(false);
        
        JButton botaoFileChooser = new JButton("Selecione arquivo");
        botaoFileChooser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                int retorno = fileChooser.showOpenDialog(SegundaTela.this);
                if (retorno == JFileChooser.APPROVE_OPTION) {
                    File arquivo = fileChooser.getSelectedFile();
                    
                    dsCaminhoCompleto = arquivo.getAbsolutePath();
                    dsNomeArquivo = arquivo.getName();
                    
                    tfArquivo.setText(arquivo.getAbsolutePath());
                    if(opcao1.isSelected()){
                        tfArquivo.setText(dsCaminhoCompleto);
                    }else if(opcao2.isSelected()){
                        tfArquivo.setText(dsNomeArquivo );
                    }
                }
            }
        });
        
        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.add(botaoFileChooser);
        painelBotoes.add(mudarTela);
        painelBotoes.add(opcao1);
        painelBotoes.add(opcao2);
        
        painelSul.add(tfArquivo, BorderLayout.NORTH);
        painelSudoeste.add(painelBotoes, BorderLayout.SOUTH);
        mudarTela.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                primeiraTela.setVisible(true);
                primeiraTela.setTxtSelecionado(lista.getSelectedValue().toString());
                
            
            
            }
        });
        
        
        
        
        
        
    }
    
private class ClicouRadionButton implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(opcao1.isSelected()){
                tfArquivo.setText(dsCaminhoCompleto);
            }else if(opcao2.isSelected()){
                tfArquivo.setText(dsNomeArquivo);
            }
        }
        
    }    
    
    
}
