
import adicionais.Acucar;
import adicionais.Creme;
import adicionais.Gelo;
import adicionais.Limao;
import bebidas.Cafe;
import bebidas.Cha;
import bebidas.Refrigerante;
import interfaces.Bebida;

/**
 *
 * @author 78522
 */
public class Teste {

    public static void main(String[] args) {
        Bebida bebida1 = new Cafe();
        bebida1 = new Creme(bebida1);
        bebida1 = new Acucar(bebida1);
        

        System.out.println("Bebida 1 = " + bebida1.getDescricao());

        Bebida bebida2 = new Cha();
        bebida2 = new Acucar(bebida2);
        bebida2 = new Gelo(bebida2);

        System.out.println("Bebida 2 = " + bebida2.getDescricao());
        
        Bebida bebida3 = new Refrigerante();
        bebida3 = new Limao(bebida3);
        bebida3 = new Gelo(bebida3);
        
        System.out.println("Bebida 3 = " + bebida3.getDescricao());
    }
}
