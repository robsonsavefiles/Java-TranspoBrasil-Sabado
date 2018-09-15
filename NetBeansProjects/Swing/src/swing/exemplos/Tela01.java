package swing.exemplos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author 89087
 */
public class Tela01 extends JFrame implements ActionListener {

    public Tela01() {
        setTitle("Titulo de Tela");
        JPanel painel = new JPanel();
        JButton btnClick = new JButton("Click Aqui");
        btnClick.setActionCommand("click");
        btnClick.addActionListener(this);
        painel.add(btnClick);

        JButton btnClickCancel = new JButton("Cancelar");
        btnClickCancel.setActionCommand("cancel");
        btnClickCancel.addActionListener(this);
        painel.add(btnClickCancel);

        btnClickCancel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setText("Clickou");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setText("Pressionou");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setText("Soltou");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setText("Entrou");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setText("Saiu");
            }

        });

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new FlowLayout());
        
        add(btnClick, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        add(btnClickCancel, BorderLayout.EAST);
        setLocationRelativeTo(null);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if ("click".equals(actionCommand)) {
            JOptionPane.showMessageDialog(this, "Click Efetuado");
        } else if ("cancel".equals(actionCommand)) {
            JOptionPane.showMessageDialog(this, "Cancelando com Sucesso:");

        }
    }

}
