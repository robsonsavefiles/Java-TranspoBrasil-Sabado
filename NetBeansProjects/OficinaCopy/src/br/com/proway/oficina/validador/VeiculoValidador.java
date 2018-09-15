
package br.com.proway.oficina.validador;

import br.com.proway.oficina.modelo.Veiculo;
import java.util.ArrayList;
import java.util.Calendar;


public class VeiculoValidador {
    
    private ArrayList<Erro> erros = new ArrayList<Erro>();
    
    public boolean isValido(Veiculo veiculo){
        
        if(!ValidadorUtil.isDentroDoIntervado(veiculo.getAnoFabricacao(), 1900, getAnoAtual())){
            erros.add(new Erro("anoFabricacao","Ano incompativel"));
        }
        
        if(!ValidadorUtil.isDentroDoIntervado(veiculo.getAnoModelo(), 1900, getAnoAtual()+1)){
            erros.add(new Erro("anoModelo","Ano incompativel"));
        }
        if(ValidadorUtil.isVazio(veiculo.getPlaca())){
             erros.add(new Erro("placa","valor obrigatório"));
        }
        if(ValidadorUtil.isVazio(veiculo.getModelo())){
             erros.add(new Erro("modelo","valor obrigatório"));
        }
        return erros.isEmpty();
                
    }
    
     private static int  getAnoAtual(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
     
     public ArrayList<Erro> getErros(){
         return erros;
     }
    
}
