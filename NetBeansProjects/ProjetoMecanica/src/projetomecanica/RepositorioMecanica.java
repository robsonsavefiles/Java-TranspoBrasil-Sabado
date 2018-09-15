package projetomecanica;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class RepositorioMecanica {

    private static final ArrayList<Veiculo> lista = new ArrayList<>();

    public void salvar(Veiculo veiculo) {
        
        File dados = new File("veiculos.txt");
        Date atual = new Date();
        
        if (veiculo == null) {
            return;
        }
        if (veiculo.getId() == null) {
            veiculo.setId(System.currentTimeMillis());
        } else {
        }
        int index = lista.indexOf(veiculo);
        if (index > -1) {
            lista.set(index, veiculo);
        
        }else{
             veiculo.setDataCriacao(atual);
            veiculo.setDataAlteracao(atual);
            lista.add(veiculo);
        }
        DadosMecanica.gravarDadosMecanica(veiculo,new File ("Veiculos.txt"));
        lista.add(veiculo);
    }

    public void remover(Veiculo veiculo ) {
        lista.remove(veiculo);
       
    }

    public ArrayList<Veiculo> buscarTodos() {
        return lista;
    }

    public ArrayList<Veiculo> buscarPorModelo() {
        return lista;
    }

    public Veiculo BuscarPorId(Long id) {
        for (Veiculo atual : lista) {
            if (id.equals(atual.getId()));
            return atual;
        }
        return null;
    }

    public ArrayList<Veiculo> BuscarPorMarca(String marca) {
        ArrayList<Veiculo> resultMarca = new ArrayList<Veiculo>();
        for (Veiculo atual : lista) {
            if (atual.getMarca().equalsIgnoreCase(marca)) {
                resultMarca.add(atual);
            }
        }
        return resultMarca;

    }
    public Veiculo BuscarPorPlaca(String placa) {
        
        for (Veiculo atual : lista) {
            if (placa.equalsIgnoreCase(atual.getPlaca())) {
                return atual;
            }
        }
        return null;
    }

    public ArrayList<Veiculo> BuscarPorModelo(String modelo) {
        ArrayList<Veiculo> resultModelo = new ArrayList<Veiculo>();
        for (Veiculo atual : lista) {
            if (atual.getModelo().equalsIgnoreCase(modelo)) {
                resultModelo.add(atual);
            }
        }
        return resultModelo;

    }

    public ArrayList<Veiculo> BuscarPorAnoFabricacao(int anoFabricacao) {
        ArrayList<Veiculo> resultAnoFab = new ArrayList<Veiculo>();
        for (Veiculo atual : lista) {
            if (atual.getAnoFabricacao() == anoFabricacao) {
                resultAnoFab.add(atual);
            }
        }
        return resultAnoFab;
    }

    public ArrayList<Veiculo> BuscarPorAnoModelo(int anoModelo) {
        ArrayList<Veiculo> resultAnoMod = new ArrayList<Veiculo>();
        for (Veiculo atual : lista) {
            if (atual.getAnoModelo() == anoModelo) {
                resultAnoMod.add(atual);
            }
        }
        return resultAnoMod;
    }

    
    }


