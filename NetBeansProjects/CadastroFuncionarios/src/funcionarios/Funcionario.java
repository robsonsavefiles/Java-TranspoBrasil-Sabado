/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;

/**
 *
 * @author Robinho
 */
public class Funcionario {
    
 
    protected int numeroRegistro;
    protected String nome;
    protected String funcao;
    protected float salario;
    protected String situacao;
 
    public Funcionario() {
    }
 
    public Funcionario(int _numeroRegistro, String _nome, String _funcao, float _salario, String _situacao){
        numeroRegistro = _numeroRegistro;
        nome = _nome;
        funcao = _funcao;
        salario = _salario;
        situacao = _situacao;
    }
 
    public void DefinirNumeroRegistro(int _numeroRegistro){
         numeroRegistro = _numeroRegistro;
    }
 
    public int ObterNumeroRegistro(){
        return(numeroRegistro);
    }
 
    public void DefinirNome(String _nome){
        nome = _nome;
    }
 
    public String ObterNome(){
        return(nome);
    }
 
    public void DefinirFuncao(String _funcao){
        funcao = _funcao;
    }
 
    public String ObterFuncao(){
        return(funcao);
    }
 
    public void DefinirSalario(float _salario){
        salario = _salario;
    }
 
    public float ObterSalario(){
        return(salario);
    }
 
    public void DefinirSituacao(String _situacao){
        situacao = _situacao;
    }
 
    public String ObterSituacao(){
        return(situacao);
    }
}
    

