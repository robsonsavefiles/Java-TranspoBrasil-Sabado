//Factory- retorna uma instruçao de um objeto(esconder a criaçao de um objeto mais complexo).
//ocultar a instanciaçao do objeto
package br.com.proway.java.factory;

public abstract class Relatorio {

    public abstract Object gerar();

    public static Relatorio getRelatorio(String tipo) {
        Relatorio relatorio = null;

        if ("XML".equals(tipo)) {
            //Imagine aqui um codigo complexo
            relatorio = new RelatorioXML();
        } else if ("HTML".equals(tipo)) {
            //Imagine aqui um codigo complexo
            relatorio = new RelatorioHTML();
        } else if ("TXT".equals(tipo)) {
            //Imagine aqui um codigo complexo
            relatorio = new RelatorioTexto();
        } else if ("JSON".equals(tipo)) {
            //Imagine aqui um codigo complexo
            relatorio = new RelatorioJson();
        }

        return relatorio;

    }

}
