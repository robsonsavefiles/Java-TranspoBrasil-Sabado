package br.com.oficinaV2.base;
import br.com.OficinaV2.base.Telas;
/**
 * Representa um evento de navegaçao entre telas do sistema
 *
 * @author 89087
 */
public class EventosNavegacao implements Evento {

    private final Telas tela;

    public EventosNavegacao(Telas tela) {
        this.tela = tela;
    }

    @Override
    public String getTipo() {
        return EventosNavegacao.class.getName();
    }

    /**
     * Representa a tela que deve ser disponibilizada
     *
     * @return enum com codigo de tela ea ser encontrada.
     */
    public Telas getDestino() {
        return this.tela;
    }
}
