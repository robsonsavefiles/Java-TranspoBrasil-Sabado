package modelo;

import java.util.ArrayList;



public class Executor {
    
    static ArrayList<Produto> produtosLoja = new ArrayList<Produto>();
     
    public static void main(String[] args) {
        
        Celular c = new Celular();
        Tablet t = new Tablet();
        
        produtosLoja.add(t);
        produtosLoja.add(c);
        System.out.println(c.desconto());
    }
    
    public static void calculaTotalDescontos() {
        int total = 0;
        for (Produto p : produtosLoja) {
            total += p.desconto();
        }
        System.out.println(total);
    }
}