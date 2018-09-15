package br.cursojava.model;

import br.cursojava.model.Providencia;

/**
 *
 * @author 89087
 */
public class ChamadoProvidencia {

    private long chamadoId;
    private Providencia providencia;

    public ChamadoProvidencia() {
    }

    public ChamadoProvidencia(long chamadoId, Providencia providencia) {
        this.chamadoId = chamadoId;
        this.providencia = providencia;
    }

    public long getChamadoId() {
        return chamadoId;
    }

    public void setChamadoId(long chamadoId) {
        this.chamadoId = chamadoId;
    }

    public Providencia getProvidencia() {
        return providencia;
    }

    public void setProvidencia(Providencia providencia) {
        this.providencia = providencia;
    }
    
}
