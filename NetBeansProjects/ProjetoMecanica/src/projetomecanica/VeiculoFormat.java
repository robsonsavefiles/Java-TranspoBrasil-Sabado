/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomecanica;


import java.text.SimpleDateFormat;



public class VeiculoFormat {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    private static final String EMPTY = "";
    public static String getPlaca(Veiculo veiculo) {
        return veiculo != null && veiculo.getPlaca() != null ? veiculo.getPlaca(): EMPTY;
    }

    public static String getMarca(Veiculo veiculo) {
        return veiculo != null && veiculo.getMarca() != null ? veiculo.getMarca(): EMPTY;
    }

    public static String getModelo(Veiculo veiculo) {
        return veiculo != null && veiculo.getModelo() != null ? veiculo.getModelo(): EMPTY;
    }

    public static String getCor(Veiculo veiculo) {
         return veiculo != null && veiculo.getCor() != null ? veiculo.getCor(): EMPTY;
    }

    public static int getAnoFabricacao(Veiculo veiculo) {
         return veiculo != null  ? veiculo.getAnoFabricacao(): 1900;
    }

    public static int getAnoModelo(Veiculo veiculo) {
         return veiculo != null  ? veiculo.getAnoModelo(): 1900;
    }

    public static String getId(Veiculo veiculo) {
         return veiculo != null && veiculo.getId()!= null ? String.valueOf(veiculo.getId()): EMPTY;
    }

    public static String getDataCriacao(Veiculo veiculo) {
         return veiculo != null && veiculo.getDataCriacao() != null ? sdf.format(veiculo.getDataCriacao()): EMPTY;
    }

    public static String getDataAlteracao(Veiculo veiculo) {
         return veiculo != null && veiculo.getDataAlteracao() != null ? sdf.format(veiculo.getDataAlteracao()): EMPTY;
    }
    
}
