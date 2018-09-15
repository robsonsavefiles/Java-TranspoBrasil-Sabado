/*
 * INBasicEntity.java
 *
 * Created on 1 de Fevereiro de 2006, 12:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.invnautico.core.model;

/**
 *
 * @author vsenger
 */
public interface INBasicEntity  {
    public void setId(Integer id);
    public Integer getId();
    public String getDescricao() ;
    public void setDescricao(String descricao);
    public boolean isAtivo();
    public void setAtivo(boolean ativo);
}
