package br.com.proway.java;

import java.util.ArrayList;

public class ExemploBoxing {

    public static void main(String[] args) {
        Integer value = new Integer(11);
//       int temp = value intValue();// versao 1.4
//       temp++;
//       value = new Integer(temp)
//        
        value++;
        System.out.println(value);

        Long value2 = 1L;// New Long(L)
        Integer i = 15;// new integer(15)
        int value3 = i;//i.intValue();

        teste1(value3);
        testeVarArgs("Felipe", "maria", "jose");
        testeVarArgs("Felipe");
        testeVarArgs();

        String[] nomes = {"Felipe", "maria", "jose"};
        testeVarArgs(nomes);

//        Integer v1 = 10;
//        Integer v2 = 10;
//        System.out.println(v1.equals(v2));
//        Integer v3 = 128;
//        Integer v4 = 128;
//        System.out.println(v3 == v4);
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(new Integer(1));
        Object t1 = lista.get(0);
        Integer t2 = (Integer) t1;
        int valor = t2.intValue();

        ArrayList<Integer> lista2 = new ArrayList<Integer>();
        lista2.add(1);
        int valor2 = lista2.get(0);

    }

//    public static void  teste1(int a){
//        System.out.println("Chamou o primitivo");
//    
//}
//    public static void teste2(Integer a){
//        System.out.println("Chamou o objeto");
//    }
//    private static void teste1(long a){
//        System.out.println("Chamou o primitivo long");
//    }
    public static void teste1(Object a) {
        System.out.println("Chamou o objeto object");
    }

    public static void teste1(Number a) {
        System.out.println("Chamou o object Numeber");
    }

    public static void testeVarArgs(String... nomes) {
        System.out.println("Chamou var args");
        System.out.println(nomes.length);
        for (String nome : nomes) {
            System.out.println(nome);
        }

    }

}
