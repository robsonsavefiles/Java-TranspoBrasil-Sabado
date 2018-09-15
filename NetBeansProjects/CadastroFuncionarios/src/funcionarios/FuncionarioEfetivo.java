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
public class FuncionarioEfetivo extends Funcionario{
 
    private String dataAdmissao;
    private String dataDemissao;
 
    public FuncionarioEfetivo() {
    }
 
    public FuncionarioEfetivo(int _numeroRegistro, String _nome, String _funcao, float _salario, String _situacao, String _dataAdmissao, String _dataDemissao){
        numeroRegistro = _numeroRegistro;
        nome = _nome;
        funcao = _funcao;
        salario = _salario;
        situacao = _situacao;
        dataAdmissao = _dataAdmissao;
        dataDemissao = _dataDemissao;
    }
 
    public void DefinirDataAdmissao(String _dataAdmissao){
        dataAdmissao = _dataAdmissao;
    }
 
    public String ObterDataAdmissao(){
        return(dataAdmissao);
    }
 
    public void DefinirDataDemissao(String _dataDemissao){
        dataDemissao = _dataDemissao;
    }
 
    public String ObterDataDemissao(){
        return(dataDemissao);
    }
}  

