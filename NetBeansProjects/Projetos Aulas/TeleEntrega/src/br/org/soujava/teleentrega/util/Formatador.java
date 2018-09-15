/*
 * Formatador.java
 *
 
 * Created on 8 de Abril de 2006, 10:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.org.soujava.teleentrega.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author vsenger
 */
public class Formatador {
  private static SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
  private static DecimalFormat moeda = new DecimalFormat("#,##0.00");
  public static String dataSimplesParaString(java.util.Date data) {
    return data!=null ? dataSimples.format(data) : "";
  }
  public static java.util.Date dataSimplesParaObjeto(String data) {
    try {
      return data!=null ? dataSimples.parse(data) : null;
    } catch (ParseException ex) {
      return null;
    }
  }
  public static String moeda(float v) {
    return moeda.format(v);
  }
  public static String moeda(double v) {
    return moeda.format(v);
  }
}
