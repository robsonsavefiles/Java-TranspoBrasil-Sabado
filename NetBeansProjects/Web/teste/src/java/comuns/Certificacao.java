/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comuns;

/**
 *
 * @author 66463
 */
public class Certificacao {
    
    private String nome;
    private String orgaoExpeditor;

    public Certificacao(String nome, String orgaoExpeditor) {
        this.nome = nome;
        this.orgaoExpeditor = orgaoExpeditor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrgaoExpeditor() {
        return orgaoExpeditor;
    }

    public void setOrgaoExpeditor(String orgaoExpeditor) {
        this.orgaoExpeditor = orgaoExpeditor;
    }

    @Override
    public String toString() {
        return "Certificacao{" + "nome=" + nome + ", orgaoExpeditor=" + orgaoExpeditor + '}';
    }
    
    
    
}
