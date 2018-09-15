/*

 */
package projetoswing;
public class AppTabela {
    
    public static void main(String[] args) {
        PrimeiraTela tela = new PrimeiraTela();
        tela.setVisible(true);
        
        SegundaTela tela2 = new SegundaTela();
        
        tela.setSegundaTela(tela2);
        tela2.setPrimeiraTela(tela);
        
    }
    
}
