package JList;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;


public class Exemplo extends JFrame {

    public Exemplo(){
        setSize(200, 300);
        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        getContentPane().add(pPrincipal);

        String[] itens = {"Primeiro", "segundo", "Terceiro"};

        JList lista = new JList(itens);
        pPrincipal.add(lista);
        pPrincipal.add(lista);
        
        JButton btnAcao = new JButton("Aperte-me");
        pPrincipal.add(btnAcao,BorderLayout.SOUTH);
        btnAcao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(lista.getSelectedValue().toString());
            }
        });

    }

    public static void main(String[] args) {
        Exemplo tela = new Exemplo();
        tela.setVisible(true);
    }

}
