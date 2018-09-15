
package projeto;

/**
 *
 * @author 89087
 */
public class JanelaApp {

  
    public static void main(String[] args) {
        JanelaLista lista = new JanelaLista();
        JanelaTabela tabela = new JanelaTabela();
        
        lista.setOutra(tabela);
        tabela.setOutra(lista);
        
        lista.setVisible(true);
    }
   
}



