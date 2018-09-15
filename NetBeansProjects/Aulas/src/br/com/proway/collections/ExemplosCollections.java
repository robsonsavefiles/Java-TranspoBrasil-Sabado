package br.com.proway.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class ExemplosCollections {

    public static void main(String[] args) {

        List<String> nomes = new LinkedList<String>();//navegar um a um 
        Set<String> nomesNaoRepetidos = new HashSet<String>();
        nomesNaoRepetidos.add("Robson");
        System.out.println("Size = " + nomesNaoRepetidos.size());
        nomesNaoRepetidos.add("Maria");
        System.out.println("Size = " + nomesNaoRepetidos.size());
        nomesNaoRepetidos.add("Maria");
        System.out.println("Size = " + nomesNaoRepetidos.size());
        nomesNaoRepetidos.add("Ana");
        System.out.println("Size = " + nomesNaoRepetidos.size());

        for (String nome : nomesNaoRepetidos) {
            System.out.println(nome);

        }

        Map<String, String> mapa = new HashMap<String, String>();//classe map procurar alguma coisa pela chave
        mapa.put("chave1", "valor1");
        mapa.put("chave2", "valor2");
        mapa.put("chave3", "valor3");
        mapa.put("chave4", "valor4");

        System.out.println(mapa.get("chave1"));
        System.out.println(mapa.get("chave2"));
        System.out.println(mapa.get("chave3"));
        System.out.println(mapa.get("chave4"));
        System.out.println(mapa.get("chave5"));//retorna null por nao ter valor no mapa.put

        for (Map.Entry<String, String> dado : mapa.entrySet()) {
            System.out.println(dado.getKey() + "==> " + dado.getValue());
        }
        Map<Pessoa, String> mapaPessoas = new HashMap<Pessoa, String>();
        mapaPessoas.put(new Pessoa("Felipe"), "Felipe");
        mapaPessoas.put(new Pessoa("Maria"), "Maria");
        System.out.println(mapaPessoas.get(new Pessoa("Felipe")));

        nomes = new ArrayList<String>();
        nomes.add("robson");
        nomes.add("João");
        nomes.add("adao");

        for (String nome : nomes) {
            System.out.println(nome);
        }
        System.out.println("=================================================");
        Collections.sort(nomes);

        for (String nome : nomes) {
            System.out.println(nome);
        }
        System.out.println("=================================================");

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa("felipe", "oliveira", 34));
        pessoas.add(new Pessoa("Adao", "Brasil", 40));
        pessoas.add(new Pessoa("Celina", "Silveira", 30));

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());
        }
        Collections.sort(pessoas);

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());

        }
        Collections.sort(pessoas, new ComparadorPessoaPorIdade());

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());

        }
        System.out.println("=================================================");
        //innerClass - uma classe dentro de outra classe
        Comparator<Pessoa> comparadorPorSobreNome = new Comparator<Pessoa>() {

            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o1.getNome().compareTo(o2.getSobrenome());

            }

        };

        Collections.sort(pessoas, comparadorPorSobreNome);

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());

        }
        System.out.println("=================================================");

        Collections.sort(pessoas, new Comparator<Pessoa>() {

            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return Integer.compare(o2.getIdade(), o1.getIdade());
            }
        });
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome() + " - " + pessoa.getIdade());
        }
        System.out.println("=================Lambida===========================");

        Collections.sort(pessoas, (Pessoa o1, Pessoa o2) -> Integer.compare(o2.getIdade(), o1.getIdade()));

        pessoas.forEach(new Consumer<Pessoa>() {

            @Override
            public void accept(Pessoa t) {
                System.out.println(t.getNome());
            }

        });
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome() + " - " + pessoa.getIdade());
        }

    }

}
