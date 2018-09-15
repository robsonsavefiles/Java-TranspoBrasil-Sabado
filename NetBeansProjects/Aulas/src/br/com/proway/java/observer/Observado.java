
package br.com.proway.java.observer;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.java.observer.Observador;
/**
 *
 * @author 89087
 */
public class Observado  {
    
    private List<Observador> lista = new ArrayList<Observador>();
    private List<String> itens = new ArrayList<>();
    
    public void registrarObservador(Observador observador){
        if(!lista.contains(observador)){
            lista.add(observador);
        }
    }
    
    public void removerObservador(Observador observador){
        lista.remove(observador);
    }
    public void onEventoCorrido(String data){
        for(Observador observador : lista){
            observador.notificar(data);
        }
    }
    public void adicionarItem(String item){
        itens.add(item);
        onEventoCorrido(item);
    }
    
}
