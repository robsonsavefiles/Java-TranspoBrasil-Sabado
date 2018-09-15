package chatsimples;

import javax.swing.JOptionPane;

public class Programa {
    
    public static void main(String[] args) {
        String  ip = (String)JOptionPane.showInputDialog("Informe o IP","192.168.0.");
        int porta = Integer.parseInt(JOptionPane.showInputDialog("Informe a Porta","5000"));
        
        Conexao c = new Conexao(ip, porta);
        
        
        JanelaChat j = new JanelaChat();
        j.setLocationRelativeTo(null);
        j.setVisible(true);
    }
}