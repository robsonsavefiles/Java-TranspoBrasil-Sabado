/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciorepita;

import javax.swing.JOptionPane;

/**
 *
 * @author Robinho
 */
public class ExercicioRepita {
    private static Object JOpitonPane;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // JOptionPane.showMessageDialog(null, "Ola Mundo","Boas Vindas",JOptionPane.INFORMATION_MESSAGE);
        int n, s =0;
        do{
        n = Integer.parseInt(JOptionPane.showInputDialog(null,
                "<html>Informe um numero: <br>(VALOR 0 INTERROMPE)</em></html>" ));
        s += n;
        }while (n != 0); 
        
        JOptionPane.showMessageDialog(null, "<html>Resultado Final<hr>" +
                "<br>Somatorio Vale" + s +"</html>");
        
        
    }
    
}
