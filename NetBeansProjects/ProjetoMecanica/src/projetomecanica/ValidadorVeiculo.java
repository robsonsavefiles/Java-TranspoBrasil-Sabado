/*
 ValidadorVeiculo
 metodo:
 + isValido(veiculo) : boolean
 + getErros() : ArrayList<Erro>
 ######Restriçoes##########
 anoFabricacao >=1900 && anoFabricacao <= anoAtual
 anoModelo >= 1900 E anoModelo <=anoAtual + 1(nao podem ficar vazios)
 id => nao vazio
 dataCriacao => nao vazio
 dataAlteracao => nao vazio
 placa => nao vazio
 modelo => nao vazio
 */
package projetomecanica;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ValidadorVeiculo {
    private ArrayList<Error> erros = new ArrayList<Error>();
    public ArrayList<ErroMecanica> getErros(Veiculo veiculos) {
        ArrayList<ErroMecanica> listaErros = new ArrayList<>();
        listaErros.add(validadorPlaca(veiculos));
        listaErros.add(validarMod(veiculos));
        listaErros.add(validarFab(veiculos));

        for (ErroMecanica erros : listaErros) {
            if (erros == null) {
                listaErros.remove(erros);
            }
        }
        return listaErros;

    }
 public boolean isValido(Veiculo veiculo){
        
        if(!ValidadorUtil.isDentroDoIntervado(veiculo.getAnoFabricacao(), 1900, getAnoAtual())){
           // erros.add(new Error("anoFabricacao","Ano incompativel"));
        }
        
        if(!ValidadorUtil.isDentroDoIntervado(veiculo.getAnoModelo(), 1900, getAnoAtual()+1)){
            //erros.add(new Error("anoModelo","Ano incompativel"));
        }
        if(ValidadorUtil.isVazio(veiculo.getPlaca())){
             //erros.add(new Error("placa","valor obrigatório"));
        }
        if(ValidadorUtil.isVazio(veiculo.getModelo())){
             //erros.add(new Error("modelo","valor obrigatório"));
        }
        return erros.isEmpty();
                
    }
    public ErroMecanica validadorPlaca(Veiculo veiculos) {
        if (veiculos.getPlaca().equalsIgnoreCase("")) {
            ErroMecanica err = new ErroMecanica("Placa","Placa Invalida");
            return err;
        }
        return null;
    }

    public int getDateMais() {
        
        Calendar calendar = Calendar.getInstance();
        Date agora = calendar.getTime();

        calendar.roll(calendar.YEAR, 1);
        int ano = calendar.get(Calendar.YEAR);
        
        return ano;

    }

    public int getDateAtual() {
        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();

        int ano = calendar.get(Calendar.YEAR);
        return ano;
    }

    public ErroMecanica validarMod(Veiculo veiculo){

        if (veiculo.getAnoModelo() > 1900 && veiculo.getAnoModelo() <= getDateMais()){
            ErroMecanica err1 = new ErroMecanica ("ANO MODELO","ANO DO MODELO CADASTRADO INVALIDO");
            return err1;
        }
        return null;
    }

    public ErroMecanica validarFab(Veiculo veiculo) {

        if(veiculo.getAnoFabricacao() >= 1900 && veiculo.getAnoFabricacao() <= getDateMais()) {
            ErroMecanica err2 = new ErroMecanica("ANO DE FABRICAÇÃO", "ANO DE FABRICAÇÃO INVALIDO");
            return err2;
        }

        return null;

    }

    private int getAnoAtual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
