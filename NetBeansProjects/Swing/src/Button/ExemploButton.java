package Button;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author 89087
 */
public class ExemploButton extends JFrame {

    private final JRadioButton opcao1;
    private final JRadioButton opcao2;
    private final JRadioButton opcao3;

    public ExemploButton() {
        super("Exemplo Button");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new FlowLayout());
        getContentPane().add(pPrincipal);

        JPanel nNorte = new JPanel();
        pPrincipal.add(nNorte, BorderLayout.NORTH);

        opcao1 = new JRadioButton("Liberar Veiculo");
        opcao2 = new JRadioButton("Não Liberar Veiculo");
        opcao3 = new JRadioButton("Documentação invalida");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(opcao1);
        grupo.add(opcao2);
     
        pPrincipal.add(opcao1);
        pPrincipal.add(opcao2);
        

        JButton btOpcao = new JButton("Mostrar Opção Selecionado");
        pPrincipal.add(btOpcao, BorderLayout.SOUTH);

        btOpcao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (opcao1.isSelected()) {
                    System.out.println(opcao1.getText());
                }
                if (opcao2.isSelected()) {
                    System.out.println(opcao2.getText());

                }
                if (opcao3.isSelected()) {
                    System.out.println(opcao3.getText());

                }else{
                    System.out.println("Nenhuma opcao foi selecionada");
                }
            }

        });

    }

    public static void main(String[] args) {
        ExemploButton ex = new ExemploButton();
        ex.setVisible(true);
    }

}
