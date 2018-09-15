/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certificacoes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 66463
 */
public class CerificacoesRepositorio {
    
     private static List<Certificacao> certificacoes = new ArrayList<>();
    
    static {
        certificacoes.add(new Certificacao(1l,"Java", "Oracle"));
        certificacoes.add(new Certificacao(1l,"Oracle", "Oracle"));
    }
    
    public List<Certificacao> buscarTodos() {
        return certificacoes;
    }

    public Certificacao salvar(Certificacao certificacao) {
        if (certificacao.getId() == null) {
            certificacao.setId(System.currentTimeMillis());
        }
        int indexOf = certificacoes.indexOf(certificacao);
        if (indexOf > -1) {
            certificacoes.set(indexOf, certificacao);
        } else {
            certificacoes.add(certificacao);
        }
        return certificacao;
    }
    
    public boolean remover(Certificacao cerificacao){
        return certificacoes.remove(cerificacao);
    }
    
    public Certificacao buscarPorId(Long id){
        for (Certificacao certificacao : certificacoes) {
            if(id.equals(certificacao.getId())){
                return certificacao;
            }
        }
        return null;
    }

    
}
