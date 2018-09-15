package br.com.proway.java;

import java.util.ArrayList;

public class RepositorioVeiculo {
    
    private static ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
   

    public void salvar(Veiculo veiculo) {
        if(veiculo == null){
            return;
        }
        if(veiculo.getId() == null){
            veiculo.setId(System.currentTimeMillis());
        }
       int index = lista.indexOf(veiculo);
       if(index >-1){
           lista.set(index, veiculo);
       }
    }
    public void remover(Veiculo veiculo){
        lista.remove(veiculo);
    }
    public ArrayList<Veiculo> buscarTodos(){
        return lista;
    }
    public ArrayList<Veiculo> buscarPorModelo(){
      return lista;
    }
   
    public Veiculo BuscarPorId(Long id) {
        for(Veiculo atual : lista){
            if(id.equals(atual.getId()));
            return atual;
        }
        return null;
    }
    public ArrayList<Veiculo> BuscarPorMarca(String marca) {
        ArrayList<Veiculo> resultMarca = new ArrayList<Veiculo>();
        for(Veiculo atual : lista){
            if(atual.getMarca().equalsIgnoreCase(marca)){
                resultMarca.add(atual);
            }
        }
        return resultMarca;
        
    }
    
    public ArrayList<Veiculo> BuscarPorModelo(String modelo) {
        ArrayList<Veiculo> resultModelo = new ArrayList<Veiculo>();
        for(Veiculo atual : lista){
            if(atual.getModelo().equalsIgnoreCase(modelo)){
                resultModelo.add(atual);
            }
        }
            return resultModelo;
       
    }
    
    public ArrayList<Veiculo> BuscarPorAnoFabricacao(int anoFabricacao) {
        ArrayList<Veiculo> resultAnoFab = new ArrayList<Veiculo>();
        for(Veiculo atual : lista){
            if(atual.getAnoFabricacao() == anoFabricacao){
            resultAnoFab.add(atual);
            }
        }
     return resultAnoFab;
    }
    
    public ArrayList<Veiculo>BuscarPorAnoModelo(int anoModelo) {
        ArrayList<Veiculo> resultAnoMod = new ArrayList<Veiculo>();
        for(Veiculo atual : lista){
           if(atual.getAnoModelo()== anoModelo){
            resultAnoMod.add(atual);
        }
        }
        return resultAnoMod;
    }
    public ArrayList<Veiculo> BuscarPorAnoFabricacaoAte(int anoFabricacaoAte) {
        ArrayList<Veiculo> resultAnoFabAte = new ArrayList<Veiculo>();
        for(Veiculo atual : lista){
           if(atual.getAnoModAte()== anoFabricacaoAte){
            resultAnoFabAte.add(atual);
        }
        }
        return resultAnoFabAte; 
    }
     public ArrayList<Veiculo> BuscarPorAnoModeloAte(int anoModeloAte) {
       ArrayList<Veiculo> resultAnoModAte = new ArrayList<Veiculo>();
        for(Veiculo atual : lista){
           if(atual.getAnoModAte()== anoModeloAte){
            resultAnoModAte.add(atual);
        }
        }
        return resultAnoModAte; 
    }

    ArrayList<Veiculo> buscarPorMarca() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ArrayList<Veiculo> BuscarPorAnoFabricacao(ArrayList<Veiculo> anoFabricacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
