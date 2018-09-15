package aula.exercicios.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 78522
 */
public class NumerosUtil {

    private static final String CONECTOR = " e ";
    private static final Map<Integer, NumeroExtenso> numeros = new HashMap();
    private static final Map<Integer, NumeroExtensoPrefixo> prefixos = new HashMap();

    static {
        int i = 0;
        numeros.put(i++, new NumeroExtenso("zero", "", ""));
        numeros.put(i++, new NumeroExtenso("um", "dez", "cento"));
        numeros.put(i++, new NumeroExtenso("dois", "vinte", "duzentos"));
        numeros.put(i++, new NumeroExtenso("três", "trinta", "trezentos"));
        numeros.put(i++, new NumeroExtenso("quatro", "quarenta", "quatrocentos"));
        numeros.put(i++, new NumeroExtenso("cinco", "cinquenta", "quinhentos"));
        numeros.put(i++, new NumeroExtenso("seis", "sessenta", "seiscentos"));
        numeros.put(i++, new NumeroExtenso("sete", "setenta", "setecentos"));
        numeros.put(i++, new NumeroExtenso("oito", "oitenta", "oitocentos"));
        numeros.put(i++, new NumeroExtenso("nove", "noventa", "novecentos"));

        i = 0;
        prefixos.put(i++, new NumeroExtensoPrefixo("", ""));
        prefixos.put(i++, new NumeroExtensoPrefixo("mil", "mil"));
        prefixos.put(i++, new NumeroExtensoPrefixo("milhão", "milhões"));
        prefixos.put(i++, new NumeroExtensoPrefixo("bilhão", "bilhões"));
        prefixos.put(i++, new NumeroExtensoPrefixo("trilhão", "trilhões"));
        prefixos.put(i++, new NumeroExtensoPrefixo("quadrilhão", "quadrilhões"));
        prefixos.put(i++, new NumeroExtensoPrefixo("quintilhão", "quintilhões"));
        prefixos.put(i++, new NumeroExtensoPrefixo("sextilhão", "sextilhões"));
        prefixos.put(i++, new NumeroExtensoPrefixo("septilhão", "septilhões"));
        prefixos.put(i++, new NumeroExtensoPrefixo("octilhão", "octilhões"));
        prefixos.put(i++, new NumeroExtensoPrefixo("nonilhão", "nonilhões"));
        prefixos.put(i++, new NumeroExtensoPrefixo("decilhão", "decilhões"));
    }

    public static String numeroPorExtenso(int numero) {

        String retorno = "";
        char[] casasChar = String.valueOf(numero).toCharArray();
        int[] casas = new int[casasChar.length];

        for (int i = 0; i < casas.length; i++) {
            casas[i] = Integer.parseInt(String.valueOf(casasChar[i]));
        }

        for (int i = casas.length - 1; i >= 0; i--) {

            if ((i + 1) % 3 == 0) {
                if (casas[i] > 1) {
                    retorno = prefixos.get(Math.round((i - 1) / 3)).getPlural() + retorno;
                } else {
                    retorno = prefixos.get(Math.round((i - 1) / 3)).getSingular() + retorno;
                }
            }

            if (casas[i] != 0) {
                if (i > 0) {
                    if (casas[i - 1] == 1) {
                        switch (casas[i]) {
                            case 1:
                                retorno = "onze" + retorno;
                                break;
                            case 2:
                                retorno = "doze" + retorno;
                                break;
                            case 3:
                                retorno = "treze" + retorno;
                                break;
                            case 4:
                                retorno = "quatorze" + retorno;
                                break;
                            case 5:
                                retorno = "quinze" + retorno;
                                break;
                            case 6:
                                retorno = "dezesseis" + retorno;
                                break;
                            case 7:
                                retorno = "dezessete" + retorno;
                                break;
                            case 8:
                                retorno = "dezoito" + retorno;
                                break;
                            case 9:
                                retorno = "dezenove" + retorno;
                                break;
                        }
                        if (i - 2 >= 0) {
                            retorno = CONECTOR + retorno;
                        }
                        i--;
                        continue;
                    }
                }

                retorno = numeros.get(casas[i]).arrayValores()[(casas.length - i) % 3] + retorno;
                if (i != 0) {
                    retorno = CONECTOR + retorno;
                }
            } else {

                if (casas.length == 1) {
                    return numeros.get(0).getUnidade();
                }

                int conjuntoDeTres = 0;
                int seguidos = 0;
                int aux = 0;
                while (i - aux >= 0) {
                    if (casas[i - aux] == 0) {
                        seguidos++;
                        if (seguidos == 3) {
                            conjuntoDeTres++;
                            seguidos = 0;
                        }
                        aux++;
                    } else {
                        break;
                    }
                }

                if (conjuntoDeTres > 0) {
                    retorno = " " + retorno;
                }

                retorno = prefixos.get(conjuntoDeTres).getSingular() + retorno;
//                if (i > 0) {
//                    retorno = " " + retorno;
//                } else {
//                    retorno = numeros.get(0).getUnidade();
//                }
            }
        }

        return retorno.trim();
    }

//    public String numeroPorExtenso(int numero) {
//        String[][] palavras = new String[3][];
//        palavras[0] = CENTENAS;
//        palavras[1] = DEZENAS;
//        palavras[2] = UNIDADES;
//        String stringNumero = String.valueOf(numero);
//        StringBuilder retorno = new StringBuilder();
//        int numeroAtual;
//
//        if (numero > 19) {
//            for (int i = 0; i < stringNumero.length(); i++) {
//                numeroAtual = Integer.parseInt(String.valueOf(stringNumero.charAt(i)));
//                if (numeroAtual != 0) {
//                    if (i > 0) {
//                        retorno.append(" e ");
//                    }
//                    retorno.append(palavras[i][numeroAtual]);
//                }
//            }
//            return retorno.toString();
//        } else {
//            return UNIDADES[numero];
//        }
//    }
}
