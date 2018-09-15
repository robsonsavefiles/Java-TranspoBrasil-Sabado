package exemplos.builder;

import java.util.Date;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        try {
            Cliente.Builder builder = new Cliente.Builder("Tiago", "Dionesto", "45685215932");
            builder.setDataNascimento(new Date()).setSexo(Genero.MASCULINO).setTelefoneCelular("47975811445");
            Cliente cliente = builder.build();
            System.out.println(cliente.toString());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
