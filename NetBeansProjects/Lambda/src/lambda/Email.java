package lambda;

/**
 *
 * @author 78522
 */
public class Email {

    public void enviar(String para, String conteudo) {
        System.out.printf("Enviando e-mail para %s, com o conteúdo: \"%s\"\n", para, conteudo);
    }
}
