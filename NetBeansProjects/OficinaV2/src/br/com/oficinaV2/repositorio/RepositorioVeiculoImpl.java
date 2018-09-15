package br.com.oficinaV2.repositorio;

import br.com.oficinaV2.modelo.Veiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author 89087
 */
public class RepositorioVeiculoImpl implements RepositorioVeiculo {

    private static List<Veiculo> lista = new ArrayList<>();

    static {
        lista.add(new Veiculo("DDD1214", "Ford", "Fusion,", "Prata", 2015, 2016, 1L, new Date(), new Date()));
        lista.add(new Veiculo("BXZ8380", "BMW", "X6,", "Prata", 2014, 2015, 1L, new Date(), new Date()));
        lista.add(new Veiculo("MZQ8977", "Mercedes", "CLS3000,", "Vermelho", 2015, 2016, 1L, new Date(), new Date()));
        lista.add(new Veiculo("EWY9010", "Chevrolet", "Cruze", "Preto", 2012, 2013, 1L, new Date(), new Date()));
    }

    private static void Date() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Veiculo veiculo) {
        if (veiculo == null) {
            return;
        }
        if (veiculo.getId() == null) {
            veiculo.setId(System.currentTimeMillis());
            veiculo.setDataCriacao(new Date());

        }
        veiculo.setDataAlteracao(new Date());
        int index = lista.indexOf(veiculo);
        if (index > -1) {
            lista.set(index, veiculo);
        } else {
            lista.add(veiculo);
        }
    }

    @Override
    public void remover(Veiculo veiculo) {
        lista.remove(veiculo);
    }

    @Override
    public Veiculo buscarPorId(Long id) {
        for (Veiculo veiculo : lista) {
            if (veiculo.getId().equals(id)) {
                return veiculo;
            }
        }
        return null;
    }

    @Override
    public List<Veiculo> buscarTodos() {
        return lista;

    }

    @Override
    public Veiculo buscarPorPlaca(String placa) {
        for (Veiculo veiculo : lista) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Veiculo> buscarPorMarca(String marca) {
        ArrayList<Veiculo> resultado = new ArrayList<Veiculo>();
        for (Veiculo veiculo : lista) {
            if (veiculo.getMarca().contains(marca)) {
                resultado.add(veiculo);
            }
        }
        
        return resultado;
    }

    @Override
    public ArrayList<Veiculo> buscarPorModelo(String modelo) {
         ArrayList<Veiculo> resultado = new ArrayList<Veiculo>();
        for (Veiculo veiculo : lista) {
            if (veiculo.getModelo().contains(modelo)) {
                resultado.add(veiculo);
            }
        }
        return resultado;

    }

    @Override
    public ArrayList<Veiculo> buscarPorAnoFabricacao(int ano) {
         ArrayList<Veiculo> resultado = new ArrayList<Veiculo>();
        for (Veiculo veiculo : lista) {
            if (veiculo.getAnoFabricacao() == ano) {
                resultado.add(veiculo);
            }
        }
        return resultado;
    }

    @Override
    public ArrayList<Veiculo> buscarPorAnoModelo(int ano) {
         ArrayList<Veiculo> resultado = new ArrayList<Veiculo>();
        for (Veiculo veiculo : lista) {
            if (veiculo.getAnoModelo()== ano) {
                resultado.add(veiculo);
            }
        }
        return resultado;
    }

}
