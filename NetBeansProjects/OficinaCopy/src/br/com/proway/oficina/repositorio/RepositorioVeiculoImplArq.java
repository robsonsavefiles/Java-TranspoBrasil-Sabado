
package br.com.proway.oficina.repositorio;

import br.com.proway.oficina.VeiculoException;
import br.com.proway.oficina.modelo.Veiculo;
import br.com.proway.oficina.validador.ValidadorUtil;
import br.com.proway.oficina.validador.VeiculoValidador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RepositorioVeiculoImplArq implements RepositorioVeiculo {

    private static final String ARQUIVO = "veiculos.txt";
    private static ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    static {
        carregarLista();
    }

    @Override
    public void salvar(Veiculo veiculo) {
        if(veiculo == null){
            return;
        }
        if(ValidadorUtil.isNull(veiculo.getId())){
            veiculo.setId(System.currentTimeMillis());
        }
        VeiculoValidador validador = new VeiculoValidador();
        if(validador.isValido(veiculo)){
            _salvar(veiculo);
            sincronizar();
        }else{
            throw new VeiculoException(validador.getErros());
        }
    }

    private void _salvar(Veiculo veiculo) {
        int index = lista.indexOf(veiculo);
        if(index > -1){
            lista.set(index, veiculo);
            veiculo.setDataAlteracao(new Date());
        }else{
            lista.add(veiculo);
             veiculo.setDataCriacao(new Date());
             veiculo.setDataAlteracao(new Date());
        }
    }

    @Override
    public void remover(Veiculo veiculo) {
        lista.remove(veiculo);
        sincronizar();
    }

    @Override
    public Veiculo buscarPorId(Long id) {
        if(id == null){
            return null;
        }
        for (Veiculo veiculo : lista) {
            if(id.equals(veiculo.getId())){
                return veiculo;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Veiculo> buscarTodos() {
        return lista;
    }

    @Override
    public Veiculo buscarPorPlaca(String placa) {
         for (Veiculo veiculo : lista) {
            if(veiculo.getPlaca().equals(placa)){
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

    private static void carregarLista() {
        lista.clear();
        try {
            final File file = new File(ARQUIVO);
            if(!file.exists()){
                file.createNewFile();
            }
            Scanner leitor = new Scanner(file);
            Veiculo veiculo = null;
            String texto = null;
            while (leitor.hasNextLine()) {
                texto = leitor.nextLine();
                 String[] itens = texto.split(";");
                 if(itens.length >1){
                    veiculo = criarVeiculo(itens);
                    lista.add(veiculo);
                 }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private static Veiculo criarVeiculo( String[] itens) {
        Veiculo veiculo = null;
       
        try {
            Long id = Long.valueOf(itens[0]);
            Date dataCricacao = sdf.parse(itens[1]);
            Date dataAlteracao = sdf.parse(itens[2]);
            String placa = itens[3];
            String marca = itens[4];
            String modelo = itens[5];
            String cor = itens[6];
            int anoFabricacao = Integer.parseInt(itens[7]);
            int anoModelo = Integer.parseInt(itens[8]);
            veiculo = new Veiculo(placa, marca, modelo, cor, anoFabricacao, anoModelo, id, dataCricacao, dataAlteracao);
        } catch (ParseException ex) {
            Logger.getLogger(RepositorioVeiculoImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiculo;
    }

    private void sincronizar() {
        try(PrintWriter writer = new PrintWriter(ARQUIVO)) {
            
        for (Veiculo veiculo : lista) {
            writer.println(formatar(veiculo));
        }
        writer.flush();
        
        } catch (FileNotFoundException ex) {
            System.out.println("Falha ao Sincronizar");
        }
    }

    private String formatar(Veiculo veiculo) {
       StringBuilder formato = new StringBuilder();
       formato.append(veiculo.getId()).append(";")//
               .append(sdf.format(veiculo.getDataCriacao())).append(";")//
               .append(sdf.format(veiculo.getDataAlteracao())).append(";")//
               .append(veiculo.getPlaca()).append(";")//
               .append(getValor(veiculo.getMarca())).append(";")//
               .append(veiculo.getModelo()).append(";")//
               .append(getValor(veiculo.getCor())).append(";")//
               .append(veiculo.getAnoFabricacao()).append(";")//
               .append(veiculo.getAnoModelo());
       return formato.toString();
    }
    
    private static String getValor(String valor){
        return valor != null ? valor : "";
    }

}
