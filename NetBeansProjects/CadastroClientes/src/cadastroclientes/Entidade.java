/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroclientes;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author 88178
 */
public class Entidade {
    
    private Long id;
    private Date dataCriacao;
    private Date dataAltercao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entidade other = (Entidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public void setDataCriacao(Date dataCriacao) {

        this.dataCriacao = dataCriacao;
    }

    public Date getDataAltercao() {
        return dataAltercao;
    }

    public void setDataAltercao(Date dataAltercao) {
       
        
        this.dataAltercao = dataAltercao;
    }
    
}
