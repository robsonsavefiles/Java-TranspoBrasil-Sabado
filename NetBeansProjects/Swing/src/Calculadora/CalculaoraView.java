package Calculadora;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author 89087
 */
public class CalculaoraView extends JFrame implements ActionListener {

//    private static final String UM = "1";
//    private static final String DOIS = "2";
//    private static final String TRES = "3";
//    private static final String QUATRO = "4";
//    private static final String CINCO = "5";
//    private static final String SEIS = "6";
//    private static final String SETE = "7";
//    private static final String OITO = "8";
//    private static final String NOVE = "9";
//    private static final String ZERO = "0";
//    private static final String Ponto = ".";
//    private static final String Dividir = "/";
//    private static final String Multiplicar = "*";
//    private static final String Mais = "+";
//    private static final String Menos = "-";
//    private static final String Igual = "=";
//    
    private JTextField tfNumeros;
    private static final String VALORES = "0123456789.";
    private javax.swing.JTextField jTextFieldDisplay;

    public CalculaoraView() {
        setTitle("Calculadora");
        tfNumeros = new JTextField();

        add(tfNumeros, BorderLayout.NORTH);
        tfNumeros.setEditable(false);
        Container view = new JPanel();
        JPanel painelBotoes = new JPanel();
       //GridLayout gridLayout = new GridLayout(4, 4);
        view.setLayout(new GridLayout(4,4,5,5));
       // painelBotoes.setLayout(gridLayout);

        JButton btnNove = criarBotaoNove();
        JButton btnOito = criarBotaoOito();
        JButton btnSete = criarBotaoSete();
        JButton btnSeis = criarBotaoSeis();
        JButton btnCinco = criarBotaoCinco();
        JButton btnQuatro = criarBotaoQuatro();
        JButton btnTres = criarBotaoTres();
        JButton btnDois = criarBotaoDois();
        JButton btnUm = criarBotaoUm();
        JButton btnZero = criarBotaoZero();
        JButton btnMais = criarBotaoMais();
        JButton btnMenos = criarBotaoMenos();
        JButton btnMultiplicar = criarBotaoMultiplicar();
        JButton btnDividir = criarBotaoDividir();
        JButton btnIgual = criarBotaoIgual();

        painelBotoes.add(btnSete);
        painelBotoes.add(btnOito);
        painelBotoes.add(btnNove);

        painelBotoes.add(btnQuatro);
        painelBotoes.add(btnCinco);
        painelBotoes.add(btnSeis);

        painelBotoes.add(btnUm);
        painelBotoes.add(btnDois);
        painelBotoes.add(btnTres);

        painelBotoes.add(btnZero);
        painelBotoes.add(btnMais);
        painelBotoes.add(btnMenos);
        painelBotoes.add(btnMultiplicar);
        painelBotoes.add(btnDividir);
        painelBotoes.add(btnIgual);

        JButton btnPonto = new JButton(".");
        painelBotoes.add(btnPonto);
        btnPonto.addActionListener(this);
        add(painelBotoes);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,200);
        setVisible(true);

    }

    private JButton criarBotaoIgual() {
        JButton btnIgual = new JButton("=");
        btnIgual.addActionListener(this);
        return btnIgual;
    }

    private JButton criarBotaoDividir() {
        JButton btnDividir = new JButton("/");
        btnDividir.addActionListener(this);
        return btnDividir;
    }

    private JButton criarBotaoMultiplicar() {
        JButton btnMultiplicar = new JButton("*");
        btnMultiplicar.addActionListener(this);
        return btnMultiplicar;
    }

    private JButton criarBotaoMenos() {
        JButton btnMenos = new JButton("-");
        btnMenos.addActionListener(this);
        return btnMenos;
    }

    private JButton criarBotaoMais() {
        JButton btnMais = new JButton("+");
        btnMais.addActionListener(this);
        return btnMais;
    }

    private JButton criarBotaoZero() {
        JButton btnZero = new JButton("0");
        btnZero.addActionListener(this);
        return btnZero;
    }

    private JButton criarBotaoUm() {
        JButton btnUm = new JButton("1");
        btnUm.addActionListener(this);
        return btnUm;
    }

    private JButton criarBotaoDois() {
        JButton btnDois = new JButton("2");
        btnDois.addActionListener(this);
        return btnDois;
    }

    private JButton criarBotaoTres() {
        JButton btnTres = new JButton("3");
        btnTres.addActionListener(this);
        return btnTres;
    }

    private JButton criarBotaoQuatro() {
        JButton btnQuatro = new JButton("4");
        btnQuatro.addActionListener(this);
        return btnQuatro;
    }

    private JButton criarBotaoCinco() {
        JButton btnCinco = new JButton("5");
        btnCinco.addActionListener(this);
        return btnCinco;
    }

    private JButton criarBotaoSeis() {
        JButton btnSeis = new JButton("6");
        btnSeis.addActionListener(this);
        return btnSeis;
    }

    private JButton criarBotaoSete() {
        JButton btnSete = new JButton("7");
        btnSete.addActionListener(this);
        return btnSete;
    }

    private JButton criarBotaoOito() {
        JButton btnOito = new JButton("8");
        btnOito.addActionListener(this);
        return btnOito;
    }

    private JButton criarBotaoNove() {
        JButton btnNove = new JButton("9");
        btnNove.addActionListener(this);
        return btnNove;
    }

    public static void main(String[] args) {
        CalculaoraView mostrar = new CalculaoraView();

    }

    public void limpar() {
        this.jTextFieldDisplay.setText("");
    }

    public void erro(String erro) {
        JOptionPane.showMessageDialog(rootPane, erro);
    }

    public boolean eNumero(String caractere) {
        return "0123456789.".indexOf(caractere) != -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btn = (JButton) e.getSource();
        String text = btn.getText();
       // String numeros = tfNumeros.getText();
        if (VALORES.contains(text)) {
            String numeros = tfNumeros.getText();
           //tfNumeros.setText(tfNumeros.getText() + text);
        if (".".equals(text)&& numeros.contains(text)){
            return ;
            //this.erro("Erro de operação");
        }
           
            tfNumeros.setText(numeros+text);
        }

    }


}