
package br.com.proway.oficina.validador;

public class Erro {
    
    private final String campo;
    private final String descricao;

    public Erro(String campo, String descricao) {
        this.campo = campo;
        this.descricao = descricao;
    }

    public String getCampo() {
        return campo;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
    
}
