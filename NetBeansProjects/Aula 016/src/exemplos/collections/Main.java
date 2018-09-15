package exemplos.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        List<String> nomes;

        Set<String> nomesNaoRepetidos = new HashSet<>();

        nomesNaoRepetidos.add("Felipe");
        System.out.println("Size = " + nomesNaoRepetidos.size());
        nomesNaoRepetidos.add("Maria");
        System.out.println("Size = " + nomesNaoRepetidos.size());
        nomesNaoRepetidos.add("Maria");
        System.out.println("Size = " + nomesNaoRepetidos.size());
        nomesNaoRepetidos.add("Ana");
        System.out.println("Size = " + nomesNaoRepetidos.size());

        nomesNaoRepetidos.stream().forEach((nomesNaoRepetido) -> System.out.println(nomesNaoRepetido));

        Map<String, String> mapa = new HashMap();
        mapa.put("chave1", "Valor1");
        mapa.put("chave2", "Valor2");
        mapa.put("chave3", "Valor3");
        mapa.put("chave4", "Valor4");

        for (int i = 1; i <= mapa.size() + 1; i++) {
            System.out.println(mapa.get("chave" + i));
        }

        Map<Pessoa, String> mapaPessoas = new HashMap();
        mapaPessoas.put(new Pessoa("Felipe"), "Felipe");
        mapaPessoas.put(new Pessoa("Maria"), "Maria");
        System.out.println(mapaPessoas.get(new Pessoa("Felipe")));

        nomes = new ArrayList();
        nomes.add("Ahmed");
        nomes.add("Mohammed");
        nomes.add("Zephiroth");
        nomes.add("Aladin");
        nomes.add("Ahbdul");

        System.out.println("------");

        nomes.stream().forEach((nome) -> System.out.println(nome));

        System.out.println("------");

        Collections.sort(nomes);
        nomes.stream().forEach((nome) -> System.out.println(nome));

        System.out.println("------");

        List<Pessoa> pessoas = new ArrayList();
        pessoas.add(new Pessoa("Osama", "Binladen", 26));
        pessoas.add(new Pessoa("Ismael", "Grama", 45));
        pessoas.add(new Pessoa(null, "Grama", 54));
        pessoas.add(new Pessoa("Zordon", "King", 36));
        pessoas.add(new Pessoa(null, "King", 17));
        pessoas.add(new Pessoa("Richard", "Nixon", 70));

        pessoas.stream().forEach((pessoa) -> System.out.println(pessoa.getNome()));

        System.out.println("------");

        Collections.sort(pessoas, new ComparadorPessoaPorNome());
        pessoas.stream().forEach((pessoa) -> System.out.println(pessoa.getNome()));

        System.out.println("------");

        Collections.sort(pessoas, new ComparadorPessoaPorIdade());
        pessoas.stream().forEach((pessoa) -> System.out.println(pessoa.getNome() + " - " + pessoa.getIdade()));

        System.out.println("------");

        Comparator<Pessoa> comparadorPorSobrenome = (Pessoa o1, Pessoa o2) -> {
            if (o1 != null) {
                if (o1.getSobrenome() != null) {
                    if (o2 != null) {
                        if (o2.getSobrenome() != null) {
                            return o1.getSobrenome().compareTo(o2.getSobrenome());
                        }
                    }
                    return -1;
                }
            }
            return 1;
        };

        Collections.sort(pessoas, comparadorPorSobrenome);
        pessoas.stream().forEach((pessoa) -> System.out.println(pessoa.getNome() + " - " + pessoa.getSobrenome()));

        System.out.println("------");

        Collections.sort(pessoas, (Pessoa o1, Pessoa o2) -> {
            if (o1 != null) {
                if (o2 != null) {
                    return Integer.compare(o2.getIdade(), o1.getIdade());
                }
                return 1;
            }
            return -1;
        });
        pessoas.stream().forEach((pessoa) -> System.out.println(pessoa.getNome() + " - " + pessoa.getIdade()));

        System.out.println("------");
    }
}
