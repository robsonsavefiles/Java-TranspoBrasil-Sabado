/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

/**
 *
 * @author 89087
 */
public class FolhaPagamentoTest {

    public static void main(String[] args) {

        Atendente atentende = new Atendente("A1BC3", "JOAQUIM", 1200.0);
        FolhaPagamento folha = new FolhaPagamento();
        folha.imprimirHolerite(atentende);

        Vendedor vendedor = new Vendedor("SIX203", "SALIN JUNIOR", 1200.00, 40000, 0.2);
        folha.imprimirHolerite(vendedor);

        Gerente gerente = new Gerente("GE52841", "ROBSON", 3000.0, 1000.0);
        folha.imprimirHolerite(gerente);

        Funcionario base = new Atendente();
        System.out.println(base.getClass());
        System.out.println(base.getSalarioBase());

        base = vendedor;
        System.out.println(base.getClass());
        System.out.println(base.getSalarioBase());

        base = gerente;
        System.out.println(base.getClass());
        System.out.println(base.getSalarioBase());
        
        base = new Diretor();
    
    
    /*
    funcionario:
    
            getcodigo();
            getnome();
            getsalario();
            getsalariobase();

    vendedor:
    
            getcodigo();
            getnome();
            getsalario();
            getsalariobase();
            gettotalvendas();
            getpercentualcomissao();

    
    
    */

}
}