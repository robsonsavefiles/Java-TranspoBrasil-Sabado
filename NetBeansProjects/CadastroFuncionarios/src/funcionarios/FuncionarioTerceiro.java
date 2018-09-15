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

   public class FuncionarioTerceiro extends Funcionario{
 
    private String dataInicio;
    private String duracaoContrato;
    private String nomeEmpresa;
 
    public FuncionarioTerceiro() {
    }
 
    public FuncionarioTerceiro(int _numeroRegistro, String _nome, String _funcao, float _salario, String _situacao, String _dataInicio, String _duracaoContrato, String _nomeEmpresa){
        numeroRegistro = _numeroRegistro;
        nome = _nome;
        funcao = _funcao;
        salario = _salario;
        situacao = _situacao;
        dataInicio = _dataInicio;
        duracaoContrato = _duracaoContrato;
        nomeEmpresa = _nomeEmpresa;
    }
 
    public void DefinirDataInicio(String _dataInicio){
        dataInicio = _dataInicio;
    }
 
    public String ObterDataInicio(){
        return(dataInicio);
    }
 
    public void DefinirDuracaoContrato(String _duracaoContrato){
        duracaoContrato = _duracaoContrato;
    }
 
    public String ObterDuracaoContrato(){
        return(duracaoContrato);
    }
 
    public void DefinirNomeEmpresa(String _nomeEmpresa){
        nomeEmpresa = _nomeEmpresa;
    }
 
    public String ObterNomeEmpresa(){
        return(nomeEmpresa);
    }
 
} 

