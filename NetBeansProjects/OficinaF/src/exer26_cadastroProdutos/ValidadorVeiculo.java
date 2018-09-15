/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exer26_cadastroProdutos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 88178
 *
 *     //anoFabricacao >= 1900 e anoFabricacao <= anoAtual
 * //anoModelo >= 1900 e anoModelo <= anoAtual+1
 */
public class ValidadorVeiculo {

//    isValido(veiculo) : boolean;
//    getErros() : ArrayList<Erro>
//Validar na tela...  
    public ArrayList<Erro> getErros(Veiculo veiculos) {

        ArrayList<Erro> lista = new ArrayList<>();
        lista.add(validarPlaca(veiculos));
        lista.add(validarAnoModelo(veiculos));
        lista.add(validarAnoFabricacao(veiculos));

        for (Erro abacate1 : lista) {
            if (abacate1 == null) {
                lista.remove(abacate1);
            }

        }
        return lista;
    }

    public Erro validarPlaca(Veiculo veiculos) {

        if (veiculos.getPlaca().equalsIgnoreCase("")) {
            Erro err = new Erro("Placa", "Placa invalida");
            return err;
        }
        return null;
    }

    public Erro validarAnoModelo(Veiculo veiculos) {

        if (veiculos.getAnoModelo() >= 1900 && veiculos.getAnoModelo() <= pegarDataAtualPlus()) {
            Erro err1 = new Erro("Ano modelo", "Ano do modelo cadastrado invalido");
            return err1;
        }
        return null;
    }

    public Erro validarAnoFabricacao(Veiculo veiculos) {

        if (veiculos.getAnoFabricacao() >= 1900 && veiculos.getAnoFabricacao() <= pegarDataAtual()) {
            Erro err2 = new Erro("Ano de fabricação", "Ano de fabricação invalido");
            return err2;
        }
        return null;
    }

    public int pegarDataAtualPlus() {

        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();

        calendar.roll(Calendar.YEAR, 1);
        int ano = calendar.get(Calendar.YEAR);

        return ano;
    }

    public int pegarDataAtual() {

        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();

        int ano = calendar.get(Calendar.YEAR);

        return ano;
    }

}
