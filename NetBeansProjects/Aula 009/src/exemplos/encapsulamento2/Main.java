package exemplos.encapsulamento2;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        Produto produto1 = new Produto("Arroz Tio Jo�o", 2.57);
        Produto produto2 = new Produto("Feij�o Tio Jos�", 2.70);
        Produto produto3 = new Produto("Farinha Farofeira", 3.0);
        Produto produto4 = new Produto("Traquinas Nestl�", 2.20);
        Produto produto5 = new Produto("Coca-Cola 2L", 4.6);
        Produto produto6 = new Produto("Salgadinho Fandangos", 3.5);
        Produto produto7 = new Produto("Alcatra Mimosa", 23.8);

        Pedido pedido = new Pedido("Maria");

        System.out.println(pedido);
    }

}
