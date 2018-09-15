package exemplos.interruptor;

/**
 *
 * @author 78522
 */
public class Interruptor implements Ligavel {

    private Ligavel dispositivo;

    public Interruptor(Ligavel objeto) {
        this.dispositivo = objeto;
    }

    public Ligavel getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Ligavel dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public void ligar() {
        dispositivo.ligar();
    }

    @Override
    public void desligar() {
        dispositivo.desligar();
    }
}
