package swing.exemplos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MeuPrimeiroJFrame extends JFrame {

    public MeuPrimeiroJFrame() {
        setTitle("Meu Primeiro JFrame");
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        getContentPane().add(painelPrincipal);

//        JButton botao = new JButton("Aperte aqui");
//        painelPrincipal.add(botao,BorderLayout.SOUTH); 
//        JButton botao2 = new JButton("Aperte aqui");
//        painelPrincipal.add(botao2,BorderLayout.EAST);
//        JButton botao3 = new JButton("Aperte aqui");
//        painelPrincipal.add(botao3,BorderLayout.WEST);
//        JButton botao4 = new JButton("Aperte aqui");
//        painelPrincipal.add(botao4,BorderLayout.NORTH);
//        
        JPanel painelSul = new JPanel();
        painelSul.setLayout(new BorderLayout());
        painelPrincipal.add(painelSul,BorderLayout.SOUTH);
        
        JPanel painelSudeste = new JPanel();
        painelSudeste.setLayout(new FlowLayout());
        painelSul.add(painelSudeste,BorderLayout.WEST);
        
        JButton botao = new JButton("Aperte Aqui");
        painelSudeste.add(botao);
        
        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,"OI");
            }
        });
        
    
    }

    public static void main(String[] args) {
        MeuPrimeiroJFrame tela = new MeuPrimeiroJFrame();

    }

}
